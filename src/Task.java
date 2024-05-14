public class Task extends AbstractTask {
    private boolean isCompleted;

    public Task(String taskType, int size, Job job) {
        super(taskType, size, job);
        this.isCompleted = false;
    }

    public void execute(Station station) {
        System.out.println("Task " + getTaskType() + " is starting at Station " + station.getStationID());
        performTaskExecution();
        completeTask(station);
    }

    private void performTaskExecution() {
        System.out.println("Executing task: " + getTaskType() + " with size " + getSize());
    }

    private void completeTask(Station station) {
        isCompleted = true;
        System.out.println("Task " + getTaskType() + " has completed at Station " + station.getStationID());
        station.taskCompleted(this);
        getJob().notifyTaskCompletion(this);
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
