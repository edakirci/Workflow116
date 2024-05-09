import java.util.*;
public abstract class AbstractStation {
    private String taskType;
    private int maxCapacity;
    private boolean multiflag;
    private boolean fifoflag;
    private List<Task> currentTasks;
    private PriorityQueue<Task> taskQueue;

    public AbstractStation(String taskType, int maxCapacity, boolean multiflag, boolean fifoflag, List<Task> currentTasks, PriorityQueue<Task> taskQueue) {
        this.taskType = taskType;
        this.maxCapacity = maxCapacity;
        this.multiflag = multiflag;
        this.fifoflag = fifoflag;
        this.currentTasks = currentTasks;
        this.taskQueue = taskQueue;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean isMultiflag() {
        return multiflag;
    }

    public void setMultiflag(boolean multiflag) {
        this.multiflag = multiflag;
    }

    public boolean isFifoflag() {
        return fifoflag;
    }

    public void setFifoflag(boolean fifoflag) {
        this.fifoflag = fifoflag;
    }

    public List<Task> getCurrentTasks() {
        return currentTasks;
    }

    public void setCurrentTasks(List<Task> currentTasks) {
        this.currentTasks = currentTasks;
    }

    public PriorityQueue<Task> getTaskQueue() {
        return taskQueue;
    }

    public void setTaskQueue(PriorityQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void scheduleTasks(){

    }
}
