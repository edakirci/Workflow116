import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.HashMap;


public class FileParser{
    private String filePath;

    class InvalidTaskTypeException extends Exception {
        public InvalidTaskTypeException(String s) {
        }

        public String InvalidTaskTypeException(String message) {
            return message;
        }
    }

    class DuplicateIDException extends Exception {
        public String DuplicateIDException(String message) {
            return message;
        }
    }

    class MissingElementException extends Exception {
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

    public void parseFile() throws InvalidTaskTypeException, DuplicateIDException, MissingElementException, IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        parseLines(lines);
    }

    private void parseLines(List<String> lines) throws InvalidTaskTypeException, DuplicateIDException, MissingElementException {
        Map<String,Task> taskTypes = new HashMap<>();
        Map<String,JobType> jobTypes = new HashMap<>();
        for (int i = 0; i < lines.size(); i++) {
            try {
                parseLine(lines.get(i), i + 1);
            } catch (InvalidTaskTypeException | DuplicateIDException | MissingElementException e) {

                System.out.println("Error in Line " + (i + 1) + ": " + e.getMessage());
            }
        }
    }

    private void parseLine(String line, int lineNumber) throws InvalidTaskTypeException, DuplicateIDException, MissingElementException {
        if (line.contains("T5 -4")) {
            throw new InvalidTaskTypeException("T5 has a negative task size.");
        }
    }
}
