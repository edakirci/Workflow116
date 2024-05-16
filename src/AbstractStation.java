import java.util.*;

public abstract class AbstractStation {
    private String stationID;
    private int maxCapacity;
    private boolean multiflag;
    private boolean fifoflag;
    private List<Task> currentTasks;
    private PriorityQueue<Task> taskQueue;

    public AbstractStation(String stationID, int maxCapacity, boolean multiflag, boolean fifoflag) {
        this.stationID = stationID;
        this.maxCapacity = maxCapacity;
        this.multiflag = multiflag;
        this.fifoflag = fifoflag;
        this.currentTasks = new ArrayList<>();
        this.taskQueue = new PriorityQueue<>(new TaskPriorityComparator(fifoflag));
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
    public boolean getMultiflag() {return multiflag;}

    public boolean getFifoflag() {
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



    public void addTask(Task task) {
        if (multiflag || currentTasks.stream().allMatch(t -> t.getTaskType().equals(task.getTaskType()))) {
            if (currentTasks.size() < maxCapacity) {
                currentTasks.add(task);
                task.execute(); // Simulate task execution immediately for demonstration
            } else {
                taskQueue.add(task);
            }
        } else {
            System.out.println("Cannot add different task types concurrently at " + stationID);
        }

        updateStationStatus();
    }

    public void taskCompleted(Task task) {
        currentTasks.remove(task);
        if (!taskQueue.isEmpty()) {
            Task nextTask = taskQueue.poll();
            addTask(nextTask);
        } else {
            updateStationStatus();
        }
    }

    private void updateStationStatus() {
        if (currentTasks.isEmpty() && taskQueue.isEmpty()) {
            System.out.println("Station " + stationID + " is idle.");
        } else {
            System.out.println("Station " + stationID + " is active.");
        }
    }

    // Comparator to manage task scheduling based on FIFO or deadline
    private class TaskPriorityComparator implements Comparator<Task> {
        private boolean byDeadline;

        public TaskPriorityComparator(boolean byDeadline) {
            this.byDeadline = byDeadline;
        }

        @Override
        public int compare(Task t1, Task t2) {
            if (byDeadline) {
                return Integer.compare(t1.getJob().getStartTime() + t1.getJob().getDuration(), t2.getJob().getStartTime() + t2.getJob().getDuration());
            }
            return Integer.compare(t1.getJob().getStartTime(), t2.getJob().getStartTime());
        }
    }
}







