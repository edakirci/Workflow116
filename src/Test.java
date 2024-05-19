import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your text file path");
        String filePath = sc.nextLine();
        System.out.println("Please enter your job file path");
        String jobPath = sc.nextLine();
        sc.close();
        try {
            FileParser jobParser = new FileParser(filePath, jobPath);
            jobParser.parseFiles();
            jobParser.parseJobFile();
            System.out.println("Parsing completed successfully for job data.");
            for (Map.Entry<String, JobType> entry : jobParser.getJobTypes().entrySet()) {
                System.out.println("Job ID: " + entry.getKey() + " has type: " + jobParser.getJobListText());

            }
        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }

        public static void workflowSimulator () {

        }
    }