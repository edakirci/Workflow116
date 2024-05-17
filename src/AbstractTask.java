public abstract class AbstractTask {
    private String taskTypeID;
    private double defaultSize;

    public AbstractTask(String taskTypeID,double defaultSize) {
        this.defaultSize = defaultSize;
        this.taskTypeID = taskTypeID;
    }

    public String getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(String taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public double getDefaultSize() {
        return defaultSize;
    }

    public void setDefaultSize(double defaultSize) {
        this.defaultSize = defaultSize;
    }
}
