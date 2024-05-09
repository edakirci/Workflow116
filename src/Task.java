public class Task extends AbstractTask{
    private String taskType;
    private int size;

    public Task(String taskTypeID, double defaultSize, String taskType, int size) {
        super(taskTypeID, defaultSize);
        this.taskType = taskType;
        this.size = size;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

