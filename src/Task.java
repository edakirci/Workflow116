public class Task{
    private String taskType;
    private double defaultsize;
    public Task(String taskType, double defaultSize) {
        this.defaultsize = defaultSize;
        this.taskType = taskType;
    }




    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public double getDefaultSize() {
        return defaultsize;
    }

    public void setDefaultSize(double defaultsize) {
        this.defaultsize = defaultsize;
    }
}

