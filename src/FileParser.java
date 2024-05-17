import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileParser {

    public void parseFiles() throws IOException {


        List<String> lines = Files.readAllLines(Paths.get("src/input.txt"));
        Map<String, Task> taskTypes = new HashMap<>();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) {
                System.out.println("1 line is passing...");
                continue;
            }
            try {
                if (line.startsWith("(TASKTYPES")) {
                    parseTaskTypes(line, taskTypes);
                } else if (line.startsWith("(JOBTYPES")) {


                } else if (line.startsWith("(STATIONS")) {


                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

    public void parseTaskTypes(String line, Map<String, Task> taskTypes) throws MissingElementException {
        double size = 1.0;
        String[] parts = line.split("\s");
        for (String s : parts) {
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
        System.out.println(taskTypes.get("T3").getDefaultSize());


    }
    public void parseJobTypes(){

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