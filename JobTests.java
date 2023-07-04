/*
 * Sam Polyakov
 * JobTests.java
 * 03/05/2023
 * Project 4
 * CS231 B
 */

public class JobTests {
    // tests job
    public static void jobTest() {
        {
            // Setup
            Job j1 = new Job(0, 10);
            Job j2 = new Job(10, 20);

            // Verify
            System.out.println(j1.getArrivalTime() + " == 0.0");
            System.out.println(j2.getArrivalTime() + " == 10.0");

        }
        {
            // Setup
            Job j1 = new Job(0, 10);
            Job j2 = new Job(10, 20);

            // Verify
            System.out.println(j1.getTotalProcessingTime() + " == 10.0");
            System.out.println(j2.getTotalProcessingTime() + " == 20.0");

        }
        {
            // Setup
            Job j1 = new Job(0, 10);
            Job j2 = new Job(10, 20);

            // Test process, isFinished, setFinished, getTimeRemaining, and getFinished
            j1.process(10);
            j2.process(5);

            if (j1.isFinished()) {
                j1.setFinishTime(j1.getArrivalTime() + 10);
            }

            // Verify
            System.out.println(j1.timeInQueue() + " == 10.0");
            System.out.println(j2.getTimeRemaining() + " == 15.0");
            System.out.println(j1.isFinished() + " == true");
            System.out.println(j2.isFinished() + " == false");

            System.out.println(j1.getFinishTime() + " == 10.0");

        }
    }

    public static void main(String[] args) {
        jobTest();
    }
}