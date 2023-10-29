/**
 * DiningServer.java
 *
 * This class contains the methods called by the  philosophers.
 * You are flexible to change it, here only display a sample
 */

public interface DiningServer {
   // called by a philosopher when they wish to eat 
   void takeForks(int philosopherNumber);

   // called by a philosopher when they are finished eating 
   void returnForks(int philosopherNumber);
}
