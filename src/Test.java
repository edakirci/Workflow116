import java.io.*;
import java.util.*;
import java.util.Collection;

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
            List<Job> jobList = new ArrayList<>();
            List<Integer> startTimes = new ArrayList<>();
            List<Task> completedTasks = new ArrayList<>();
            for (Map.Entry<String, Job> entry : jobParser.getJobListText().entrySet()) {
                System.out.println("Job ID: " + entry.getKey());
                Job job = new Job(entry.getKey(), jobParser.jobListText.get(entry.getKey()).getJobType(), jobParser.jobListText.get(entry.getKey()).getStartTime(), jobParser.jobListText.get(entry.getKey()).getDuration());
                jobList.add(job);
                startTimes.add(jobParser.jobListText.get(entry.getKey()).getStartTime());
                Collections.sort(startTimes);
            }
            for (int i = 0; i < startTimes.size(); i++) {
                boolean jobStarted = false;
                for (int j = 0; j < jobList.size(); j++) {
                    if (startTimes.get(i) == jobList.get(j).getStartTime()) {
                        jobList.get(j).startJob();
                        jobStarted = true;
                        // Ensure 'i' is within the bounds of 'jobParser.getTasks()'
                        if (i < jobParser.getTasks().size()) {
                            Task task = jobParser.getTasks().get(i);
                            Station station = new Station("S1", 4, true, false, 2);

                            for (int k = 0; k < jobParser.getTasks().size(); k++) {
                                task.execute(station);
                                break;
                            }
                        } else {
                            System.out.println("Task not found");
                        }
                    }
                }
                if (!jobStarted) {
                    System.out.println("No job found with start time: " + startTimes.get(i));
                }
            }


        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }


}

}

