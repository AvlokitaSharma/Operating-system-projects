/**
 * Philosopher.java
 *
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 *
 */

import java.util.Random;

public class Philosopher implements Runnable {
    private final int philosopherNumber;
    private final DiningServer diningServer;
    private final Random random;

    public Philosopher(int philosopherNumber, DiningServer diningServer) {
        this.philosopherNumber = philosopherNumber;
        this.diningServer = diningServer;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                think();
                diningServer.takeForks(philosopherNumber);
                eat();
                diningServer.returnForks(philosopherNumber);
            }
        } catch (InterruptedException e) {
            System.out.println("Philosopher " + philosopherNumber + " was interrupted.");
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        int milliseconds = random.nextInt(2000) + 1000; // Between 1 and 3 seconds
        System.out.println("Philosopher " + philosopherNumber + " will think for " + milliseconds / 1000.0 + " seconds");
        Thread.sleep(milliseconds);
    }

    private void eat() throws InterruptedException {
        int milliseconds = random.nextInt(2000) + 1000; // Between 1 and 3 seconds
        System.out.println("Philosopher " + philosopherNumber + " will eat for " + milliseconds / 1000.0 + " seconds");
        Thread.sleep(milliseconds);
    }
}