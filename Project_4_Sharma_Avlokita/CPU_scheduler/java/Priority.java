/**
 * Non-preemptive priority scheduling algorithm.
 */
 
import java.util.*;
public class Priority implements Algorithm{
    List<Task> taskList;
    public Priority(List<Task> x)
    {
        taskList = x;
    }


    public void schedule()
    {
        System.out.println("\n");
        taskList.sort(new SortByPriority()); 
        while(taskList.size() != 0){
            Task runningTask = pickNextTask(); 
                                                // printing out current/running task
            System.out.println("Will Run Name: "+runningTask.getName());

            System.out.println("Tid: "+runningTask.getTid());

            System.out.println("Priority: "+runningTask.getPriority());

            System.out.println("Burst: "+runningTask.getBurst());

            try 
            {
                Thread.sleep(runningTask.getBurst());
            } 
            
            catch (InterruptedException e)
             {
                e.printStackTrace();
            }
            System.out.println("\nTask "+runningTask.getName()+" finished.\n"); //PRINT THE RUNNING TASK
        }
    }
    
    // function for picking up the next task
    public Task pickNextTask()
    {
        Task currentTask = taskList.remove(0); // removing every task
        return currentTask;
    }

}