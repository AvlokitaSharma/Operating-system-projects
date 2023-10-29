import java.util.concurrent.Semaphore;
public class East_village extends Thread
{
  private String taskArray[] = {"is Playing Cards.",
                                "is Eating Donuts.",
                                "is Reading JJK.",   
                                "is Drinking wine."};
  private Semaphore sema_phore; 
        // Constructor of East_Village 
  public East_village(Semaphore s){
    this.sema_phore = s;
  }
  
  @Override
  public void run(){
    try{
      this.sema_phore.acquire(); 
            // Acquires a permit from this semaphore

      for(int m=0; m<5; m++){
        int num = (int)Math.floor(Math.random()*(3-0+1)+0); 
              // generating a random integer

        System.out.println("East_village " +(m+1) +" is traveling on the road."); 
              // traveler started travelling 

        System.out.println("East_village " +(m+1)+" "+taskArray[num]); 
              // using the randomly generated integer 

        Thread.sleep(1000);  
        System.out.println("East_village " +(m+1)+" has finished the exchange\n"); 
      }
    }
    catch(Exception e){
      System.out.println(e);
    }
    this.sema_phore.release(); 
          // Releases a permit
  }
}