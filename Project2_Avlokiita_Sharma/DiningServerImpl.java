/**
 * DiningServer.java
 *
 * This class contains the methods called by the philosophers.
 *
 */


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningServerImpl implements DiningServer {
    private enum State {THINKING, HUNGRY, EATING} // States of philosophers

    private final State[] philosopherStates;
    private final Condition[] philosopherConditions;
    private final Lock lock;
    private final int numberOfPhilosophers;

    public DiningServerImpl(int numberOfPhilosophers) {
        this.numberOfPhilosophers = numberOfPhilosophers;
        lock = new ReentrantLock();
        philosopherStates = new State[numberOfPhilosophers];
        philosopherConditions = new Condition[numberOfPhilosophers];

        for (int i = 0; i < numberOfPhilosophers; i++) { // Initializing of states and locks
            philosopherStates[i] = State.THINKING;
            philosopherConditions[i] = lock.newCondition();
        }
    }

    @Override
    public void takeForks(int philosopherNumber) {
        lock.lock();
        try {
            philosopherStates[philosopherNumber] = State.HUNGRY;
            test(philosopherNumber);
            while (philosopherStates[philosopherNumber] != State.EATING) {
                philosopherConditions[philosopherNumber].await();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void returnForks(int philosopherNumber) {
        lock.lock();
        try {
            philosopherStates[philosopherNumber] = State.THINKING;
            test((philosopherNumber + numberOfPhilosophers - 1) % numberOfPhilosophers);
            test((philosopherNumber + 1) % numberOfPhilosophers);
        } finally {
            lock.unlock();
        }
    }

    private void test(int philosopherNumber) {
        if (philosopherStates[philosopherNumber] == State.HUNGRY
                && philosopherStates[(philosopherNumber + numberOfPhilosophers - 1) % numberOfPhilosophers] != State.EATING
                && philosopherStates[(philosopherNumber + 1) % numberOfPhilosophers] != State.EATING) { // Checking the neighbors
            philosopherStates[philosopherNumber] = State.EATING;
            philosopherConditions[philosopherNumber].signal();
        }
    }
}
