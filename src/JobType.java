import java.util.*;
public class JobType {
    private String jobTypeID;
    private List<Task> tasks;

    public JobType(String jobTypeID, List<Task> tasks) {
        this.jobTypeID = jobTypeID;
        this.tasks = tasks;
    }

    public String getJobTypeID() {
        return jobTypeID;
    }

    public void setJobTypeID(String jobTypeID) {
        this.jobTypeID = jobTypeID;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {

    }

    public <Task> Task getNextTask(int currentTaskIndex) {
        return null;
    }
}

