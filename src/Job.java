import java.util.Queue;

public class Job {


    private String jobID;
    private JobType jobType;
    private int startTime;
    private int duration;
    private int currentTaskIndex;
    private Queue<Task> tasks;
    private boolean isComplete;

    public Job(String jobID, JobType jobType, int startTime, int duration, int currentTaskIndex, Queue<Task> tasks, boolean isComplete) {
        this.jobID = jobID;
        this.jobType = jobType;
        this.startTime = startTime;
        this.duration = duration;
        this.currentTaskIndex = currentTaskIndex;
        this.tasks = tasks;
        this.isComplete = isComplete;
    }

    public Job(String jobID, JobType jobType, int startTime, int duration, int currentTaskIndex) {
        this.jobID = jobID;
        this.jobType = jobType;
        this.startTime = startTime;
        this.duration = duration;
        this.currentTaskIndex = currentTaskIndex;
    }

    public <Task> Task getNextTask() {
        Task nextTask = jobType.getNextTask(currentTaskIndex);
        currentTaskIndex++;
        return nextTask;
    }


    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCurrentTaskIndex() {
        return currentTaskIndex;
    }

    public Queue<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Queue<Task> tasks) {
        this.tasks = tasks;
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