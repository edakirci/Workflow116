public class Event {
    private int time;
    private String type;
    private String details;

    public Event(int time, String type, String details) {
        this.time = time;
        this.type = type;
        this.details = details;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void executeEvent(){

    }
}
