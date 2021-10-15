import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskService {

    public static List<Task> taskList = new ArrayList<>();

    public boolean addTask(String taskID, String taskName, String taskDescription) {
        Task newTask = new Task(taskID, taskName, taskDescription);

        int i = getIndex(newTask);

        if (i < 0 && validateID(newTask.getTaskId()) &&
                validateName(newTask.getTaskName()) &&
                validateDescription(newTask.getTaskDescription())) {
            taskList.add(newTask);
            return true;
        }
        return false;
    }

    public void deleteTask(String taskId) {
        Task delTask = new Task(taskId, "", "");
        int i = getIndex(delTask);

        if (i >= 0)
            taskList.remove(i);
    }

    public void updateTask(Task task) {
        // Search for the input task through against the task list
        for (Task taskObj : taskList) {
            if (taskObj.equals(task) &&
                    validateName(task.getTaskName()) &&
                    validateDescription(task.getTaskDescription())) {

                // Once we found the task update the name and description fields
                taskObj.setTaskName(task.getTaskName());
                taskObj.setTaskDescription(task.getTaskDescription());

            }
        }
    }

    public int getIndex(Task task) {
        int i = Collections.binarySearch(taskList, task, Task.compareById);
        return i;
    }

    // These are the same validators as the ones in my Task Object but
    // Since my id validation is private I had to remake the validation here
    // For consistency I redid all validations in this class (but return a bool instad of the exception)
    public boolean validateID(String taskId) {
        if (taskId != null && taskId.length() < 11)
            return true;

        return false;
    }

    public boolean validateName(String taskName) {
        if (taskName != null && taskName.length() < 21)
            return true;

        return false;
    }

    public boolean validateDescription(String taskDescription) {
        if (taskDescription != null && taskDescription.length() < 51)
            return true;

        return false;
    }
}
