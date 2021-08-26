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

    @Test
    public void TaskTypeCheck(){
        Task privateTask = new Task(TaskType.PRIVATE,"private");
        switch(privateTask.getType()){
            case WORK:
                assertEquals("work", privateTask.getBody());
                break;
            case PRIVATE:
                assertEquals("private", privateTask.getBody());
                break;
        }
    }

    @Test
    public void DayOfTheWeekTest(){
        assertEquals("日曜日", DayOfTheWeek.Sunday.getJapaneseName());
        assertEquals("月曜日", DayOfTheWeek.Monday.getJapaneseName());
        assertEquals("火曜日", DayOfTheWeek.Tuesday.getJapaneseName());
        assertEquals("水曜日", DayOfTheWeek.Wednsday.getJapaneseName());
        assertEquals("木曜日", DayOfTheWeek.Thursday.getJapaneseName());
        assertEquals("金曜日", DayOfTheWeek.Friday.getJapaneseName());
        assertEquals("土曜日", DayOfTheWeek.Saturday.getJapaneseName());

    }
    
}
