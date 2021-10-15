import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TaskServiceTest {
    String testID = "0123456789";
    String testName = "TaskName<21";
    String testDescription = "Description<51";

    @Test
    public void testTaskService() {
        // This task has the same id ("2223456789") to test the update task service
        // Also I am doing this in one big test rather than separating each test
        Task updateTask = new Task("2223456789", "UpdateName", "UpdateDescription");

        TaskService taskService = new TaskService();
        taskService.addTask("2223456789", testName, testDescription);
        taskService.addTask(testID, testName, testDescription);
        taskService.deleteTask(testID);

        taskService.updateTask(updateTask);
        assertEquals(updateTask.getTaskId(), "2223456789");
        assertEquals(updateTask.getTaskName(), "UpdateName");
        assertEquals(updateTask.getTaskDescription(), "UpdateDescription");
    }


}

