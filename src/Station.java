import java.util.List;
import java.util.PriorityQueue;

public class Station extends AbstractStation{
    public Station(String stationID, int maxCapacity, boolean multiflag, boolean fifoflag, List<TaskType> currentTasks, PriorityQueue<TaskType> taskQueue) {
        super(stationID, maxCapacity, multiflag, fifoflag, currentTasks, taskQueue);
    }
}
