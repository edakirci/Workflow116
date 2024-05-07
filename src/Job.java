public class Job {







        private String jobID;
        private JobType jobType;
        private int startTime;
        private int duration;
        private int currentTaskIndex;

        public Job(String jobID, JobType jobType, int startTime, int duration, int currentTaskIndex) {
            this.jobID = jobID;
            this.jobType = jobType;
            this.startTime = startTime;
            this.duration = duration;
            this.currentTaskIndex = currentTaskIndex;
        }

        public <Task> Task getNextTask() {
            Task nextTask = jobType.getNextTask(currentTaskIndex);
            currentTaskIndex++;
            return nextTask;
        }

        // Getters and setters for the fields

        public String getJobID() {
            return jobID;
        }

        public void setJobID(String jobID) {
            this.jobID = jobID;
        }

        public JobType getJobType() {
            return jobType;
        }

        public void setJobType(JobType jobType) {
            this.jobType = jobType;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getCurrentTaskIndex() {
            return currentTaskIndex;
        }

        public void setCurrentTaskIndex(int currentTaskIndex) {
            this.currentTaskIndex = currentTaskIndex;
        }
    }