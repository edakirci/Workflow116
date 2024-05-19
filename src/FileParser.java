import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import static java.lang.String.*;


public class FileParser {
    List<String> lines = Files.readAllLines(Paths.get("src/input.txt"));
    List<String> jobfilelines = Files.readAllLines((Paths.get("src/Job.txt")));
    Map<String, Task> taskTypes = new HashMap<>();
    Map<String, JobType> jobTypes = new HashMap<>();
    Map<String, Station> stationTypes = new HashMap<>();
    Map<String,Job> jobListText = new HashMap<>();
    List<Task> tasks = new ArrayList<>();
    Map<String,Double> taskSpeeds = new HashMap<>();
    public FileParser() throws IOException {
    }
    public void parseJobFile(){
        String line = "";
        String jobID = "";
        JobType jobType;
        int startTime = 0;
        int duration = 0;
        String[] parts = {};
        for (int i = 0; i < jobfilelines.size(); i++) {
            line = jobfilelines.get(i).trim();
            System.out.println(line);
            parts = line.split("\\s");
            if(parts.length >= 4){
                jobID = parts[0];
                jobType = new JobType(parts[1],tasks);
                startTime = Integer.parseInt(parts[2]);
                duration = Integer.parseInt(parts[3]);

                Job job = new Job(jobID,jobType,startTime,duration);
                jobListText.put(jobID,job);

            }else{
                System.out.println("Invalid line format: " + line);
            }
        }
        System.out.println(jobListText.get("Job3").getDuration());


    }
    public void parseFiles() throws IOException {


        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) {
                System.out.println("1 line is passing...");
                continue;
            }
            try {
                if (line.startsWith("(TASKTYPES")) {
                    parseTaskTypes(line, taskTypes);
                } else if (line.startsWith("(J") && line.endsWith(")")) {
                    parseJobTypes(line, jobTypes, tasks,taskTypes);
                } else if (line.startsWith("(S") && line.endsWith(")")) {
                    parseStations(line, stationTypes,taskSpeeds);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

    public void parseTaskTypes(String line, Map<String, Task> taskTypes){
        double size = 1.0;
        String[] parts = line.split("\\s");
        for(String s : parts){
            System.out.println(s);
        }
        for (int j = 1; j < parts.length; j++) {

            if (j == parts.length - 1 && parts[j].contains("T")) {
                size = 1.0;
                String taskTypeId = parts[j];
                taskTypes.put(taskTypeId, new Task(taskTypeId, size));
                break;
            }

            if (!parts[j].contains("T")) {
                continue;
            }
            String taskTypeId = parts[j];
            if (parts[j + 1].contains("T")) {
                size = 1;
            } else if (!parts[j + 1].contains("T")) {
                size = Double.parseDouble(parts[j + 1]);
            } else if (size < 1) {
                System.err.println("Size must be > 0");
            }
            if (taskTypes.containsKey(taskTypeId)) {
                System.err.println("Duplicated id error ");
            }
            taskTypes.put(taskTypeId, new Task(taskTypeId, size));

        }


    }

    public void parseJobTypes(String line, Map<String, JobType> jobTypes, List<Task> tasks, Map<String, Task> taskTypes) {
        if (line.endsWith(") )")) {
            line = line.substring(1, line.length() - 3);
        } else {
            line = line.substring(1, line.length() - 1);
        }
        System.out.println(line);
        String[] parts = line.split("\\s+");
        for (String s : parts) {
            System.out.println(s);
        }
        String jobTypeId = parts[0].substring(1);
        tasks.clear();

        for (int i = 1; i < parts.length; i++) {
            double size = 1;

            if (i == parts.length - 1 && !parts[i].contains("T")) {
                break;
            }

            if (!parts[i].contains("T")) {
                continue;
            }
            String taskTypeID = parts[i];
            if (i < parts.length - 1 && !parts[i + 1].contains("T")) {
                size = Double.parseDouble(parts[i + 1]);
                i++; // Skip the next part as it is the size for this task
            } else {
                size = taskTypes.get(parts[i]).getDefaultSize();
            }

            Task task = new Task(taskTypeID, size);
            tasks.add(task);
        }

        jobTypes.put(jobTypeId, new JobType(jobTypeId, new ArrayList<>(tasks)));
    }

    public void parseStations(String line, Map<String, Station> stationTypes,Map<String,Double> taskSpeeds) {
        if(line.endsWith(") )")){
            line = line.substring(0,line.length() - 2);
        }
        line.substring(0,line.length() - 1);
        String[] parts = line.split("\\s");
        System.out.println(parts.length);
        String stationID = parts[0].substring(1);
        int capacity = Integer.parseInt(parts[1]);
        boolean multiflag = parts[2].equals("Y");
        boolean fifoflag = parts[3].equals("Y");
        double stationSpeed = 1;
        String taskID = "";
        double taskSpeed = 1;
        if(parts.length % 2 != 0){
            stationSpeed = Double.parseDouble(parts[parts.length - 1]);
            for (int i = 4; i < parts.length - 1; i++) {
                if (!parts[i].contains("T")) {
                    continue;
                }
                taskID = parts[i];
                taskSpeed = Double.parseDouble(parts[i + 1]);
                taskSpeeds.put(taskID,taskSpeed);
                Station station = new Station(stationID,capacity,multiflag,fifoflag,stationSpeed);
                stationTypes.put(stationID,station);
            }

        }
        else if(parts.length % 2 == 0){
            stationSpeed = 1;
            for (int i = 4; i < parts.length; i++) {
                if (!parts[i].contains("T")) {
                    continue;
                }
                taskID = parts[i];
                taskSpeed = Double.parseDouble(parts[i + 1]);
                taskSpeeds.put(taskID,taskSpeed);
                Station station = new Station(stationID,capacity,multiflag,fifoflag,stationSpeed);
                stationTypes.put(stationID,station);
            }

        }

    }
    class InvalidTaskTypeException extends Exception {
        public InvalidTaskTypeException(String s) {
        }

        public String InvalidTaskTypeException(String message) {
            return message;
        }
    }

    class MissingElementException extends Exception {
        public MissingElementException(String s) {

        }

        public String MissingElementException(String message) {
            return message;
        }
    }
}
