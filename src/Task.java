public class Task extends Job {
    private int tasktypeID;
    private double taskSize;

    public Task(int jobtypeID, double jobSize, int tasktypeID, double taskSize) {
        super(jobtypeID, jobSize);
        this.tasktypeID = tasktypeID;
        this.taskSize = taskSize;
    }

    public int getTasktypeID() {
        return tasktypeID;
    }

    public void setTasktypeID(int tasktypeID) {
        this.tasktypeID = tasktypeID;
    }

    public double getTaskSize() {
        return taskSize;
    }

    public void setTaskSize(double taskSize) {
        this.taskSize = taskSize;
    }
}
