import java.util.Comparator;

public class Task {

    private String taskId;
    private String taskName;
    private String taskDescription;

    public Task(String taskId, String taskName, String taskDescription) {
        // Setting the values for the constructor using the set methods (validations are there already)
        this.setTaskId(taskId);
        this.setTaskName(taskName);
        this.setTaskDescription(taskDescription);
    }

    public String getTaskId() {
        return taskId;
    }

    private void setTaskId(String taskId) {
        // Since I set this method to private, then it should not be updatable outside of the class
        // And I will only call it inside the constructor
        if (taskId != null && taskId.length() < 11) {
            this.taskId = taskId;
        } else {
            throw new IllegalArgumentException("Invalid Task Id");
        }
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        if (taskName != null && taskName.length() < 21) {
            this.taskName = taskName;
        } else {
            throw new IllegalArgumentException("Invalid Task Name");
        }
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        if (taskDescription != null && taskDescription.length() < 51) {
            this.taskDescription = taskDescription;
        } else {
            throw new IllegalArgumentException("Invalid Task Description");
        }
    }

    // Found this example in stack overflow/(mr. google), this seems a more thorough way to compare the task objects
    public static Comparator<Task> compareById = new Comparator<Task>() {
        @Override
        public int compare(Task t1, Task t2) {
            return t1.getTaskId().compareTo(t2.getTaskId());
        }
    };

    // Overriding the equals operator to compare (extension of the stack overflow example)
    // A simpiler way I first did was just to compare the taskIds
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Task t = (Task) obj;
        return getTaskId().equals(t.getTaskId());
    }

    // Instead of printing the string for testing, I found we can override the toString method
    @Override
    public String toString() {
        return "taskId: " + getTaskId() +
                "\ntaskName: " + getTaskName() +
                "\ntaskDescription: " + getTaskDescription() + "\n";
    }

}
