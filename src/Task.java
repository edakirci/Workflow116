public class Task {
    private boolean isCompleted;
    private String taskType;
    private double defaultSize;
    private Job job;
    private double duration;

    public Task(String taskType, double defaultSize) {
        this.isCompleted = isCompleted;
        this.taskType = taskType;
        this.defaultSize = defaultSize;
        this.isCompleted = false;
    }


    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public double getDefaultSize() {
        return defaultSize;
    }

    public void setDefaultSize(double defaultSize) {
        this.defaultSize = defaultSize;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void execute(Station station) {
        System.out.println("Task " + getTaskType() + " is starting at Station " + station.getStationID());
        performTaskExecution();
        completeTask(station);
    }

    private void performTaskExecution() {
        System.out.println("Executing task: " + getTaskType() + " with size " + getDefaultSize());
    }

    private void completeTask(Station station) {
        isCompleted = true;
        System.out.println("Task " + getTaskType() + " has completed at Station " + station.getStationID());
        station.taskCompleted(this, station);
        getJob().notifyTaskCompletion(this);
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
