package sugimomoto;

import chapter_3_4_1.Task;
import chapter_3_4_1.TaskType;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Task task = new Task(TaskType.PRIVATE, "Hello");
        System.out.println(task.toString());   
        System.out.println( "Hello World!" );
    }
}
