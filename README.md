![Java](https://img.shields.io/badge/Language-Java-red)
![Simulation](https://img.shields.io/badge/Type-DiscreteEventSimulation-green)
![Scheduling](https://img.shields.io/badge/Concept-WorkflowScheduling-orange)
![CLI](https://img.shields.io/badge/Interface-CommandLine-blue)

# Workflow Simulation System

This project is a **discrete event workflow simulation system** developed for the **SE116 course**.

The system simulates how jobs move through different stations in a workflow environment such as government offices, hospitals, factories, or service systems.

Each job consists of multiple tasks that must be processed in sequence at appropriate stations. The simulation tracks job execution, station utilization, waiting queues, and scheduling decisions.

---

# Features

- Workflow simulation using **Discrete Event Simulation**
- Parsing workflow definitions from input files
- Support for **multiple job types**
- Station scheduling and task routing
- Event queue management
- Job state tracking
- Station utilization tracking
- Detection of syntax and semantic errors in workflow files
- Calculation of job tardiness and station utilization statistics

---

# System Overview

The system models a workflow consisting of:

- **Jobs**  
- **Tasks**
- **Stations**
- **Event queue**

Each **job** contains a sequence of tasks.  
Each **task** must be executed at a station that supports its task type.

Jobs move through the system as events occur, such as:

- job arrival
- task completion
- task dispatch to station

The simulation processes these events in chronological order.

---

# Input File Structure

The workflow is defined using three sections:

(TASKTYPES)

(JOBTYPES)

(STATIONS)

Example structure:

(TASKTYPES T1 T2 T3)

(JOBTYPES

(J1 T1 T2 T3)

(J2 T2 T3)

)

(STATIONS

(S1 1 N N T1 T2)

(S2 2 Y Y T2)

)


The system parses these definitions and validates them before running the simulation.

---

# Simulation Logic

The program uses an **event queue** to manage the timeline of the simulation.

Events include:

- job arrival
- task start
- task completion
- station scheduling decisions

Instead of simulating each second, the system jumps directly to the **next event time**, which improves efficiency.

---

# Scheduling Strategy

Stations process tasks according to:

- **FIFO (First-In-First-Out)**  
or  
- **Earliest Job Deadline First**

depending on the station configuration.

Stations may also support:

- multiple task types
- concurrent task execution
- fixed or variable processing speeds.

---

# Output

During simulation, the system prints:

- event timeline
- job states
- station states
- scheduling decisions

At the end of the simulation, the program calculates:

- **average job tardiness**
- **station utilization percentages**

---

# Technologies Used

- Java
- Object-Oriented Programming
- Discrete Event Simulation
- Scheduling Algorithms
- File Parsing

---

# Example Workflow Execution

Example job file format:

Job1 J1 1 30

Job2 J1 2 29

Job3 J2 5 40


The system reads the workflow configuration and schedules tasks across available stations.

---

# How to Run the Project

1. Clone the repository

```bash
git clone https://github.com/edakirci/Workflow116.git
```
2. Compile the project

   javac *.java
3. Run the simulation

   java Main workflow.txt jobs.txt

The system will parse the workflow file and start the simulation.

---
# Course Information
Course: SE116 – Introduction to Programming II

Semester: Spring 2023-2024
