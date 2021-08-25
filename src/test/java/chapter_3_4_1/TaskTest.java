package chapter_3_4_1;

import static org.junit.Assert.*;
import org.junit.Test;

public class TaskTest {

    @Test
    public void TaskClassCheck(){
        Task task = new Task(TaskType.PRIVATE, "ToDo01");

        assertEquals(TaskType.PRIVATE,task.getType());
        assertEquals("ToDo01", task.getBody());

        task.setBody("ToDoChanged");
        task.setType(TaskType.WORK);

        assertEquals(TaskType.WORK,task.getType());
        assertEquals("ToDoChanged", task.getBody());
    }
    
}
