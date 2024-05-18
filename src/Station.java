import java.util.HashMap;
import java.util.Map;

public class Station extends AbstractStation {
    private double stationSpeed;
    public Map<String,Double> taskSpeeds;
    public Map<String,Station> stationTypes;

    public Station(String stationID, int maxCapacity, boolean multiflag, boolean fifoflag, double stationSpeed) {
        super(stationID, maxCapacity, multiflag, fifoflag);
        this.taskSpeeds = taskSpeeds;
        this.stationSpeed = stationSpeed;
    }

    public double getSpeed() {
        return stationSpeed;
    }

    public void setSpeed(double speed) {
        this.stationSpeed = speed;
    }

    @Override
    public void addTask(Task task,Station station) {
        super.addTask(task, station);
        System.out.println("Task " + task.getTaskType() + " added to Station " + getStationID() + " with speed " + stationSpeed);
    }
    public boolean canExecuteTask(Task task) {
        // Check if the station's capacity allows adding new tasks
        if (getCurrentTasks().size() >= getMaxCapacity()) {
            System.out.println("Station " + getStationID() + " is at full capacity.");
            return false;
        }

        // Check if the station can handle the task type based on the multiflag setting
        if (!getMultiflag() && !getCurrentTasks().isEmpty() && !getCurrentTasks().get(0).getTaskType().equals(task.getTaskType())) {
            System.out.println("Station " + getStationID() + " does not support multiple task types concurrently.");
            return false;
        }

        return true;
    }
    @Override
    public void taskCompleted(Task task, Station station) {
        super.taskCompleted(task, station);
        System.out.println("Task " + task.getTaskType() + " completed at Station " + getStationID());
    }
}
