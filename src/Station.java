import java.util.List;
import java.util.PriorityQueue;

public class Station extends AbstractStation{
<<<<<<< HEAD
    public Station(String taskType, int maxCapacity, boolean multiflag, boolean fifoflag, List<Task> currentTasks, PriorityQueue<Task> taskQueue) {
        super(taskType, maxCapacity, multiflag, fifoflag, currentTasks, taskQueue);
=======
    public Station(String stationID, int maxCapacity, boolean multiflag, boolean fifoflag, List<TaskType> currentTasks, PriorityQueue<TaskType> taskQueue) {
        super(stationID, maxCapacity, multiflag, fifoflag, currentTasks, taskQueue);
>>>>>>> 21ae6736f4d461efc00105dc755e87007e747f41
    }
}
