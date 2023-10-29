/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling.
 */
 
import java.util.*;

public class RR implements Algorithm{
    List<Task> taskList;
    private int taskCount = 0;

    private int quantum = 10;

    public RR(List<Task> x)
    {
        taskList = x;
    }
    
    public void schedule()
    {
        System.out.println("\n");
    
        while(taskList.size() != 0){
            Task runningTask = pickNextTask(); 
         
            System.out.println("Will Run Name: "+runningTask.getName());

            System.out.println("Tid: "+runningTask.getTid());

            System.out.println("Priority: "+runningTask.getPriority());

            System.out.println("Burst: "+runningTask.getBurst());
            try {
                Thread.sleep(runningTask.getBurst());
               
                int objIndex = taskList.indexOf(runningTask);

                runningTask.setBurst(runningTask.getBurst() - quantum);

                taskList.set(objIndex, runningTask);

                if(runningTask.getBurst() <= 0)
                {
                    taskList.remove(objIndex);
                    taskCount -= 1;
                }
            } 
            catch (InterruptedException e)
             {
                e.printStackTrace();
            }
            
            if(runningTask.getBurst() <= 0)
            {
                System.out.println("\nTask "+runningTask.getName()+" finished.\n");
            }
            else
            {
                System.out.println("\n");
            }
        }
    }
    public Task pickNextTask()
    {
        Task currentTask = taskList.get(taskCount);
        
        if(currentTask.getBurst() <= 0)
        {
            taskList.remove(taskCount);
            
            currentTask = taskList.get(taskCount);
        }
        
        if (taskCount+1 >= taskList.size())
        {
            taskCount = 0;
        }
        else
        {
            taskCount += 1;
        }
        return currentTask;
    }
}