package st10077892prog5121poeparttwo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskDescriptionSuccess() {
        Task task = new Task("Login Feature", 0, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertTrue(task.checkTaskDescription());
    }

    @Test
    public void testTaskDescriptionFailure() {
        Task task = new Task("Login Feature", 0, "This description is way too long and should definitely fail the check", "Robyn Harrison", 8, "To Do");
        assertFalse(task.checkTaskDescription());
    }

    @Test
    public void testTaskIDCorrectness() {
        Task task1 = new Task("Login Feature", 0, "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        assertEquals("LO:0:SON", task1.createTaskID());

        Task task2 = new Task("Add Task Feature", 1, "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");
        assertEquals("AD:1:ITH", task2.createTaskID());
    }

    @Test
    public void testTotalHours() {
        Task[] tasks = {
            new Task("Task1", 0, "Description1", "Developer1", 10, "To Do"),
            new Task("Task2", 1, "Description2", "Developer2", 12, "Doing"),
            new Task("Task3", 2, "Description3", "Developer3", 55, "Done"),
            new Task("Task4", 3, "Description4", "Developer4", 11, "To Do"),
            new Task("Task5", 4, "Description5", "Developer5", 1, "Doing")
        };
        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.getTaskDuration();
        }
        assertEquals(89, totalHours);
    }
}
