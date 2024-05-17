import java.util.PriorityQueue;
import java.util.Comparator;

public class SystemEnvironment {
    private PriorityQueue<Event> eventQueue;

    public SystemEnvironment() {
        this.eventQueue = new PriorityQueue<>(new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                return Double.compare(e1.getTime(), e2.getTime());
            }
        });
    }

    public static Station findSuitableStation(Task currentTask) {

        return null;
    }

    public void scheduleEvent(Event event) {
        eventQueue.add(event);
    }

    public void runSimulation() {
        while (!eventQueue.isEmpty()) {
            Event currentEvent = eventQueue.poll();
            processEvent(currentEvent);
        }
    }

    private void processEvent(Event event) {
        switch (event.getType()) {
            case JOB_START:
                handleJobStart((Job) event.getDetails());
                break;
            case TASK_COMPLETE:
                handleTaskCompletion((Task) event.getDetails());
                break;
        }
    }
    private void handleJobStart(Job job) {
        System.out.println("Job " + job.getJobID() + " started at time " + job.getStartTime());
        // Schedule the first task of this job
        Task firstTask = job.getCurrentTask();
        if (firstTask != null) {
            scheduleEvent(new Event(Event.EventType.TASK_COMPLETE, job.getStartTime() + firstTask.getDuration(), firstTask));
        }
    }

    private void handleTaskCompletion(Task task) {
        System.out.println("Task " + task.getTaskType() + " completed.");
        // Move to the next task in the job, if any
        Job job = task.getJob();
        job.completeCurrentTask();
        Task nextTask = job.getCurrentTask();
        if (nextTask != null) {
            scheduleEvent(new Event(Event.EventType.TASK_COMPLETE, getCurrentTime() + nextTask.getDuration(), nextTask));
        } else {
            System.out.println("Job " + job.getJobID() + " is fully completed.");
        }
    }

    private double getCurrentTime() {
        // This method should return the current simulation time
        // For example purposes, just return a placeholder value
        return 0.0;
    }
}