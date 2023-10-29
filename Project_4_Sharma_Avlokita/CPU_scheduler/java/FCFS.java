/**
 * FCFS scheduling algorithm.
 */
 
import java.util.*;
public class FCFS implements Algorithm{
    List<Task> taskList;

    public FCFS(List<Task> x)
    { //constructor
        taskList = x;
    }


    public void schedule()
    {
        System.out.println("\n");
        while(taskList.size() != 0)
        {
            Task runningTask = pickNextTask();  // calling the function pickNextTask() to get the new task
            System.out.println("Will run name: "+runningTask.getName());
                                                //print run name
            System.out.println("Tid: "+runningTask.getTid());
                                                //print tid
            System.out.println("Priority: "+runningTask.getPriority());
                                                //print priority
            System.out.println("Burst: "+runningTask.getBurst());
                                                //print burst
            try 
            {
                Thread.sleep(runningTask.getBurst()); 
            } 
            
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("\nTask "+runningTask.getName()+" finished.\n");
        }
    }
    public Task pickNextTask()
    
    {
        Task currentTask = taskList.remove(0); //remove every task
        return currentTask;//return the task current
    }
}