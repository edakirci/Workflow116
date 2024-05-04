public class Job {
    private int jobID;
    private double jobSize;

    public Job(int jobID, double jobSize) {
        this.jobID = jobID;
        this.jobSize = jobSize;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public double getJobSize() {
        return jobSize;
    }

    public void setJobSize(double jobSize) {
        this.jobSize = jobSize;
    }
}

