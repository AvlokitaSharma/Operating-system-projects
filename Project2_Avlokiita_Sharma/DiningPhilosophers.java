/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 *
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class DiningPhilosophers {
   private static final int NUMBER_OF_PHILOSOPHERS = 5;

   public static void main(String[] args) {
      DiningServer diningServer = new DiningServerImpl(NUMBER_OF_PHILOSOPHERS); // Server

      ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHERS); // Thread pool

      IntStream.range(0, NUMBER_OF_PHILOSOPHERS).mapToObj(i -> new Philosopher(i, diningServer)).forEach(executorService::execute); // Philosophers initializing

      // Let the philosophers eat and think for 30 seconds
      try {
         Thread.sleep(30 * 1000);
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
      }

      // Shutdown the executor service and stop the philosophers
      executorService.shutdownNow();
   }
}