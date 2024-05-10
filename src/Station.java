import java.util.List;
import java.util.PriorityQueue;




public class Station extends AbstractStation{

    public Station(String taskType, int maxCapacity, boolean multiflag, boolean fifoflag, List<Task> currentTasks, PriorityQueue<Task> taskQueue) {
        super(taskType, maxCapacity, multiflag, fifoflag, currentTasks, taskQueue);

    }
}
