import java.util.*;
public abstract class AbstractStation {
    private String stationID;
    private int maxCapacity;
    private boolean multiflag;
    private boolean fifoflag;
    private List<Task> currentTasks;
    private PriorityQueue<Task> taskQueue;


    public AbstractStation(String stationID, int maxCapacity, boolean multiflag, boolean fifoflag, List<Task> currentTasks, PriorityQueue<Task> taskQueue) {
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
    public void addTask(Task task){

    }
}




