public abstract class AbstractTask {
    private String taskType;
    private int size;
    private Job job;

    public AbstractTask(String taskType, int size, Job job) {
        this.taskType = taskType;
        this.size = size;
        this.job = job;
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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
