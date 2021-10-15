import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskTest {
    String testID = "0123456789";
    String testName = "TaskName<21";
    String testDescription = "Description<51";

    @Test
    public void createValidTask() {
        Task task = new Task(testID, testName, testDescription);

        assertEquals(task.getTaskId(), testID);
        assertEquals(task.getTaskName(), testName);
        assertEquals(task.getTaskDescription(), testDescription);
        System.out.println(task.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskTooLong() {
        Task task = new Task("1234098230498230498230498230498", testName, testDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskNameTooLong() {
        Task task = new Task(testID, "Thisoisdoifjaosidjfoiasdjfoaisdjfoiasjdfoiasjdofiajsodfm jmfioofdiufoasidjfoasdijfoasidfjosad", testDescription);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTaskDescriptionTooLong() {
        Task task = new Task(testID, testName, "aosdifjoasdijfoasidjfoaisdjfoaisdjfoiasdjfoiajsdofijasdofijasodifjaosidfjoasdijfioasjdfoiajsdofiasjdfoiasjdofiajsdofijasdofijasodifjaosdifjosadijfoasidjfoaisdjfoisajdfoasd");
    }

}
