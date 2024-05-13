public class Task extends AbstractTask {
    private boolean isCompleted;

    public Task(String taskType, int size, Job job) {
        super(taskType, size, job);
        this.isCompleted = false;
    }



    public void execute() {
        System.out.println("Task " + getTaskType() + " is starting.");
        performTaskExecution();  // Simulate the task execution details.
        completeTask();  // Mark the task as completed after execution.
    }

    private void performTaskExecution() {
        // Placeholder for the execution logic.
        // This could involve interacting with other system components like resources or stations.
        System.out.println("Executing task: " + getTaskType() + " with size " + getSize());
    }

    private void completeTask() {
        isCompleted = true;
        System.out.println("Task " + getTaskType() + " has completed.");
        getJob().notifyTaskCompletion(this);
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}

