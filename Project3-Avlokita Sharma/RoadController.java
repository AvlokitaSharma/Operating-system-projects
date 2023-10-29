import java.util.concurrent.Semaphore;
 
public class RoadController
{  
   public static void main(String args[]){
      Semaphore s = new Semaphore(1);  
               //making an object of semaphore 
      East_village east = new East_village(s);  
               //making an object of East_village  
      West_village west = new West_village(s);  
               // making an object of West_village 

      east.start(); //starting a thread for East Village

      west.start(); // starting a thread for West Village
   }
}