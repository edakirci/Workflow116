import java.util.LinkedList;
import java.util.Queue;

public class Job {
    private String jobID;
    private JobType jobType;
    private int startTime;
    private int duration;
    private Queue<Task> tasks;
    private boolean isComplete;
    private int currentTime;
    private int currentTaskIndex;

    public Job(String jobID, JobType jobType, int startTime, int duration) {
        this.jobID = jobID;
        this.jobType = jobType;
        this.startTime = startTime;
        this.duration = duration;
        this.tasks = new LinkedList<>(JobType.getTasks()); // Assume JobType.getTasks() returns a list of tasks
        this.isComplete = false;
        this.currentTime = 0; // Simulation start time for this job
    }

    // Getters and Setters
    public String getJobID() {
        return jobID;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isCompleted() {
        return isComplete;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }


    // Method to start the job execution
    public void startJob() {
        if (!tasks.isEmpty() && currentTime >= startTime) {
            executeNextTask();
        } else {
            System.out.println("Job " + jobID + " is scheduled to start at " + startTime);
        }
    }

    // Method to execute the next task in the queue
    public void executeNextTask() {
        if (!tasks.isEmpty()) {
            Task currentTask = tasks.poll();
            System.out.println("Executing task: " + currentTask.getTaskType() + " for Job ID: " + jobID);
            currentTime += currentTask.getDuration(this); // Increment current time by the task's duration
            checkJobCompletion();
        }
    }

    // Method to check if the job is completed
    private void checkJobCompletion() {
        if (tasks.isEmpty()) {
            isComplete = true;
            int deadline = startTime + duration;
            if (currentTime <= deadline) {
                System.out.println("Job " + jobID + " completed on time at " + currentTime);
            } else {
                System.out.println("Job " + jobID + " completed late at " + currentTime);
            }
        }
    }


    // This method calculates the remaining duration to the deadline
    public int timeToDeadline() {
        int deadline = startTime + duration;
        return deadline - currentTime;
    }

    // This method calculates the total time elapsed since the job start
    public int elapsedTime() {
        return currentTime - startTime;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public void setCurrentTaskIndex(int currentTaskIndex) {
        this.currentTaskIndex = currentTaskIndex;
    }

    public void addTask(Task task) {
        tasks.offer(task);
    }

    public Task getCurrentTask() {
        return tasks.peek();
    }

    public void completeCurrentTask() {
        tasks.poll();
        if (tasks.isEmpty()) {
            isComplete = true;
            System.out.println("Job " + jobID + " is completed.");
        }
    }

    public boolean isComplete() {
        return isComplete;
    }
}