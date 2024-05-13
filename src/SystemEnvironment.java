import java.util.ArrayList;
import java.util.List;

public class SystemEnvironment {
    private List<Job> jobs = new ArrayList<>();

    public void addJob(Job job) {
        jobs.add(job);
    }

    public void runSimulation() {
        for (Job job : jobs) {
            while (!job.isComplete()) {
                job.executeNextTask();
            }
        }
    }
}