/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling.
 * 
 * Armando Sanchez & Everardo Camarena
 */
 
import java.util.*;

public class RR implements Algorithm{
    private List<Task> queue;
    // Constructor to initialize the RR scheduler with a list of tasks
    public RR(List<Task> queue) {
        this.queue = queue;
    }
    //executes the algorithm
    @Override
    public void schedule() {
        System.out.println("Round Robin Scheduling:"); //prints the scheduling algorithm
        int timeQuantum = 10; // Length of time quantum for round robin. 10ms

        while (!queue.isEmpty()) { //checks that it is not empty
            Task current = pickNextTask(); // gets next task to be executed
            // displays data about the current executing tasks
            System.out.println("Task " + current.getName() +
                                " (Tid: " + current.getTid() +
                                ", Burst Time: " + current.getBurst() +
                                ", Priority: " + current.getPriority() +
                                ")");

            // updates the remaining burst time for the task
            int NewBurst = current.getBurst() - timeQuantum;

            if (NewBurst > 0) {  // If the task still has burst time, reinsert it into the queue
                current.setBurst(NewBurst);
                queue.add(current);
            }
        }   
    }

    //picks the next task. First one in queue
    @Override
    public Task pickNextTask() {
        return queue.remove(0); // gets and remove the first task in the queue
        
    }
}
