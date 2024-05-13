public class Station extends AbstractStation {
    private double speed;

    public Station(String stationID, int maxCapacity, boolean multiflag, boolean fifoflag, double speed) {
        super(stationID, maxCapacity, multiflag, fifoflag);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void addTask(Task task) {
        super.addTask(task);
        System.out.println("Task " + task.getTaskType() + " added to Station " + getStationID() + " with speed " + speed);
    }

    @Override
    public void taskCompleted(Task task) {
        super.taskCompleted(task);
        System.out.println("Task " + task.getTaskType() + " completed at Station " + getStationID());
    }
}