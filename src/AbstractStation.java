import java.util.*;
public abstract class AbstractStation {
    private String stationID;
    private int maxCapacity;
    private boolean multiflag;
    private boolean fifoflag;
    private List<TaskType> currentTasks;
    private PriorityQueue<TaskType> taskQueue;

    public AbstractStation(String stationID, int maxCapacity, boolean multiflag, boolean fifoflag, List<TaskType> currentTasks, PriorityQueue<TaskType> taskQueue) {
        this.stationID = stationID;
        this.maxCapacity = maxCapacity;
        this.multiflag = multiflag;
        this.fifoflag = fifoflag;
        this.currentTasks = currentTasks;
        this.taskQueue = taskQueue;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
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

    public List<TaskType> getCurrentTasks() {
        return currentTasks;
    }

    public void setCurrentTasks(List<TaskType> currentTasks) {
        this.currentTasks = currentTasks;
    }

    public PriorityQueue<TaskType> getTaskQueue() {
        return taskQueue;
    }

    public void setTaskQueue(PriorityQueue<TaskType> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void scheduleTasks(){

    }
}
