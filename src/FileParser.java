import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;
import java.util.HashMap;
import java.lang.Throwable;


public class FileParser {
    private String filePath;

    class InvalidTaskTypeException extends Exception {
        public InvalidTaskTypeException(String s) {
        }

        public String InvalidTaskTypeException(String message) {
            return message;
        }
    }

    class DuplicateIDException extends Exception {
        public DuplicateIDException(String s){

        }
        public String DuplicateIDException(String message) {
            return message;
        }
    }

    class MissingElementException extends Exception {
        public MissingElementException(String s){
        }
        public String MissingElementException(String message) {
            return message;
        }
    }

    public FileParser(String filePath) {

        this.filePath = filePath;

    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void parseFile() throws InvalidTaskTypeException, DuplicateIDException, MissingElementException, IOException, ParseException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        parseLines(lines);
    }

    private void parseLines(List<String> lines) throws InvalidTaskTypeException, DuplicateIDException, MissingElementException,ParseException {
        Map<String, Task> taskTypes = new HashMap<>();
        Map<String, JobType> jobTypes = new HashMap<>();
        String line;
        for (int i = 0; i < lines.size(); i++) {
            line = lines.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }
            try {
                if (line.startsWith("(TASKTYPES")) {
                    i = parseTaskTypes(lines, i, taskTypes);
                }else if (line.startsWith("(JOBTYPES")){
                    i = parseJobTypes(lines,i,jobTypes,taskTypes);
                }
            } catch (InvalidTaskTypeException e) {

                throw new InvalidTaskTypeException("Error at line " + (i + 1) + ": " + e.getMessage());
            } catch (DuplicateIDException e) {

                throw new DuplicateIDException("Error at line " + (i + 1) + ": " + e.getMessage());
            }

        }
    }
    private int parseTaskTypes(List<String>lines,int start, Map<String,Task> taskType) throws InvalidTaskTypeException, DuplicateIDException{
        for (int i = start + 1; i < lines.size() ; i++) {
            String line = lines.get(i).trim();
            if(line.equals("}")){
                return i;
            }
            String[] parts = line.split("\\s+");
            if(parts.length<2) throw new InvalidTaskTypeException("Invalid Task Type");
            String taskTypeId = parts[0];

            if(taskType.containsKey(taskTypeId)){
                throw new DuplicateIDException("Duplicate task type ID: " + taskType);
            }
            int size = Integer.parseInt(parts[1]);
            taskType.put(taskTypeId, new Task(taskTypeId,size));
        }
        return start;
    }
    private int parseJobTypes(List<String> lines,int start,Map<String,JobType> jobTypes,Map<String,Task> taskTypes ) throws InvalidTaskTypeException, DuplicateIDException{
        for (int i = start + 1; i < lines.size() ; i++) {
            String line = lines.get(i).trim();
            if(line.equals(")")){
                return i;
            }
            String[] parts = line.split("\\s+");
            if(parts.length < 2) throw new InvalidTaskTypeException("Invalid job type format");
            String jobTypeId = parts[0];
            if(jobTypes.containsKey(jobTypeId)){
                throw new DuplicateIDException("Duplicate job type ID: " + jobTypeId);
            }
            JobType jobType = new JobType(jobTypeId);
            for (int j = 1; j < parts.length; j+= 2) {
                String taskTypeId = parts[j];
                Task taskType = taskTypes.get(taskTypeId);
                if(taskType == null) throw new InvalidTaskTypeException("Referenced task type not found..." + taskTypeId);
                int size = Integer.parseInt(parts[j + 1]);
                jobType.addTask(new Task(taskTypeId,size));
            }
            jobTypes.put(jobTypeId,jobType);
        }
        return start;
    }
}
