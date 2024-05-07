import java.util.*;
public class JobType {
    private String jobTypeID;
    private List<TaskType> tasks;

    public JobType(String jobTypeID, List<TaskType> tasks) {
        this.jobTypeID = jobTypeID;
        this.tasks = tasks;
    }

    public String getJobTypeID() {
        return jobTypeID;
    }

    public void setJobTypeID(String jobTypeID) {
        this.jobTypeID = jobTypeID;
    }

    public List<TaskType> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskType> tasks) {
        this.tasks = tasks;
    }

    public void addTask(TaskType task) {

    }

    public <Task> Task getNextTask(int currentTaskIndex) {
        return null;
    }
}

