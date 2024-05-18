import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import static java.lang.String.*;


public class FileParser {

    public void parseFiles() throws IOException {


        List<String> lines = Files.readAllLines(Paths.get("src/input.txt"));
        Map<String, Task> taskTypes = new HashMap<>();
        Map<String, JobType> jobTypes = new HashMap<>();
        Map<String, Station> stationTypes = new HashMap<>();
        List<Task> tasks = new ArrayList<>();
        List<JobType> jobList = new ArrayList<>();

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
                    parseJobTypes(line, jobTypes, tasks);


                } else if (line.startsWith("(S") && line.endsWith(")")) {
                    parseStations(line, stationTypes);

                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

    public void parseTaskTypes(String line, Map<String, Task> taskTypes){
        double size = 1.0;
        String[] parts = line.split("\\s");
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

    public void parseJobTypes(String line, Map<String, JobType> jobTypes, List<Task> tasks) {
        String[] parts = line.split("\\s");
        String jobTypeId = parts[0].substring(1);
        for (int i = 1; i < parts.length; i++) {
            if (parts[i].contains("T")) {
                if (i == parts.length - 1) {
                    jobTypeId = parts[0];
                    Task task = new Task(parts[i], 1);
                    tasks.add(task);
                    jobTypes.put(jobTypeId, new JobType(jobTypeId, tasks));
                    break;
                } else if (!parts[i + 1].startsWith("T")) {
                    Task task = new Task(parts[i], Double.parseDouble(parts[i + 1]));
                    tasks.add(task);
                } else if (parts[i + 1].startsWith("T")) {
                    Task task = new Task(parts[i], 1);
                    tasks.add((task));
                }
                jobTypes.put(jobTypeId, new JobType(jobTypeId, tasks));


            }
        }
    }

    public void parseStations(String line, Map<String, Station> stationTypes) {
        double stationSpeed = 1.0;
        line.substring(0,line.length() - 1);
        String[] parts = line.split("\\s");
        System.out.println(parts.length);
        String stationID = parts[0].substring(1);
        int capacity = Integer.parseInt(parts[1]);
        boolean multiflag = parts[2].equals("Y");
        boolean fifoflag = parts[3].equals("Y");
        if ((parts.length - 1) % 2 == 0) {
            stationSpeed = 1;
            Station s1 = new Station(stationID, capacity, multiflag, fifoflag, stationSpeed);
            int i = 4;
            while ((i < parts.length - 1)) {
                String taskId = parts[i];
                double taskSpeed = Double.parseDouble(parts[i + 1]);
                s1.taskSpeeds.put(taskId, taskSpeed);
                i += 2;
            }
            System.out.println("31");
            stationTypes.put(stationID, s1);
        } else if((parts.length - 1) % 2 != 0) {
            stationSpeed = Double.parseDouble(parts[parts.length - 1]);
            Station s1 = new Station(stationID, capacity, multiflag, fifoflag, stationSpeed);
            int i = 4;
            while ((i < parts.length - 1)) {
                String taskId = parts[i];
                double taskSpeed = Double.parseDouble(parts[i + 1]);
                s1.taskSpeeds.put(taskId, taskSpeed);
                i += 2;
            }
            System.out.println("222222");
        }
        System.out.println(stationTypes.get("S1").getMaxCapacity());
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


