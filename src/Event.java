public class Event {
    public enum EventType {
        JOB_START,
        TASK_COMPLETE
    }

    private EventType type;
    private double time;
    private Object details; // This could be a Job or Task object

    public Event(EventType type, double time, Object details) {
        this.type = type;
        this.time = time;
        this.details = details;
    }

    public EventType getType() {
        return type;
    }

    public double getTime() {
        return time;
    }

    public Object getDetails() {
        return details;
    }
}