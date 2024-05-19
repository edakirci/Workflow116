import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        FileParser fileParser = new FileParser();
        fileParser.parseFiles();

        JobType jobtype= new JobType("J1");

        Job job = new Job("J5",jobtype,5,2);
        Task task = new Task("T3", 2);
        Station station = new Station("S1", 10, true, false, 2);

            job.startJob();
            task.execute(station);
            task.performTaskExecution();
            task.completeTask(station);
            job.notifyTaskCompletion(task);
        }
    }
