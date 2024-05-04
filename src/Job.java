public class Job {
    private int jobtypeID;
    private double jobSize;

    public Job(int jobtypeID, double jobSize) {
        this.jobtypeID = jobtypeID;
        this.jobSize = jobSize;
    }

    public int getJobtypeID() {
        return jobtypeID;
    }

    public void setJobtypeID(int jobtypeID) {
        this.jobtypeID = jobtypeID;
    }

    public double getJobSize() {
        return jobSize;
    }

    public void setJobSize(double jobSize) {
        this.jobSize = jobSize;
    }
}