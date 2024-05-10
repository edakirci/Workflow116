import java.util.List;
import java.util.PriorityQueue;
public class Station extends AbstractStation{
    private double speed;
    public Station(String taskType, int maxCapacity, boolean multiflag, boolean fifoflag, List<Task> currentTasks, PriorityQueue<Task> taskQueue) {
        super(taskType, maxCapacity, multiflag, fifoflag, currentTasks, taskQueue);
        this.speed = speed;
    }
    public double getSpeed() {
        return speed;
    }


    /*

    public void addTask(){
    if(tasksize(+ start time??) < maxCapacity)
    ...
    }

    public void processTask(){

        //System.out.println("Executing task " + task.getTaskType() + " at station " + getStationID() + " will take " + speed + " minutes.");
    }

    public void fifoFlag(){}
    public void multiFlag(){ if(...) = Y ... else break;}

     */

}