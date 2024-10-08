import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Job {

    private String jobID;
    private JobType jobType;
    private int startTime;

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    private int duration;
    private Queue<Task> tasks;
    private boolean isComplete;
    private int currentTime;
    private int currentTaskIndex;

    public Job(String jobID,JobType jobType, int startTime, int duration) {
        this.jobID = jobID;
        this.startTime = startTime;
        this.duration = duration;
        this.tasks = new LinkedList<>(); // Assume JobType.getTasks() returns a list of tasks
        this.isComplete = false;
        this.currentTime = 0; // Simulation start time for this job
        this.jobType = jobType;
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


    public void startJob() throws IOException {
        if (!tasks.isEmpty() && currentTime >= startTime) {
            executeNextTask();
        } else {
            System.out.println("Job " + jobID + " is scheduled to start at " + startTime);
        }
        findStation();



    }
    public void findStation() throws IOException {
        String filepath = "src/input.txt";
        FileParser fileParser = new FileParser(filepath,"src/Job.txt");
        Task currentTask = tasks.poll();
        for (int i = 0; i < fileParser.stationTypes.size(); i++) {
            if(fileParser.stationTypes.get(i).taskSpeeds.containsKey(currentTask)){
                System.out.println("Task is proccessing at Station: " + fileParser.stationTypes.get(i).getStationID());
            }
        }
    }

    public void executeNextTask() {
        if (!tasks.isEmpty()) {
            Task currentTask = tasks.poll();
            Station station = SystemEnvironment.findSuitableStation(currentTask);
            if (station != null) {
                station.addTask(currentTask, station);
            } else {
                System.out.println("No suitable station found for task " + currentTask.getTaskType());
            }
        }
    }

    public void notifyTaskCompletion(Task task) {
        System.out.println("Task completed: " + task.getTaskType());
        executeNextTask();
        if (tasks.isEmpty()) {
            isComplete = true;
            System.out.println("Job " + jobID +")"+ " completed.");
        }
    }

    public void checkJobCompletion() {
        if (tasks.isEmpty()) {
            isComplete = true;
            System.out.println("Job " + jobID +")"+ " completed.");
        }
    }

    public Station findStationForTaskStation(Task task) {
        // This method would interact with the system environment to find a suitable station.
        // Placeholder for demonstration.
        return SystemEnvironment.findSuitableStation(task);
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
