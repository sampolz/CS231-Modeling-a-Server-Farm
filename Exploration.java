/*
 * Sam Polyakov
 * Exploration.java
 * 03/05/2023
 * Project 4
 * CS231 B
 */

import java.util.Scanner;

public class Exploration {
    public static void main(String[] args) {
        // uses dispachers to read files, prints out the average time in queue of a job
        Scanner scanner = new Scanner(System.in);


        double lwTotalTimeInQueue = 0;
        double randTotalTimeInQueue = 0;
        double sqTotalTimeInQueue = 0;
        double rrTotalTimeInQueue = 0;
        double worstTotalTimeInQueue = 0;
        double reverseTotalTimeInQueue = 0;
        
        JobReader jobReader = new JobReader();

        System.out.println("Enter number of servers: ");
        int k = scanner.nextInt();
        scanner.close();

        LeastWorkDispatcher lwDispatcher = new LeastWorkDispatcher(k);
        RandomDispatcher randDispatcher = new RandomDispatcher(k);
        ShortestQueueDispatcher sqDispatcher = new ShortestQueueDispatcher(k);
        RoundRobinDispatcher rrDispacher = new RoundRobinDispatcher(k);
        WorstDispacher worstDispacher = new WorstDispacher(k);
        ReverseRoundRobinDispatcher reverseDispacher = new ReverseRoundRobinDispatcher(k);

        lwDispatcher.handleJobs(jobReader.readJobFile("Jobs.txt"));
        randDispatcher.handleJobs(jobReader.readJobFile("Jobs.txt"));
        rrDispacher.handleJobs(jobReader.readJobFile("Jobs.txt"));
        sqDispatcher.handleJobs(jobReader.readJobFile("Jobs.txt"));
        worstDispacher.handleJobs(jobReader.readJobFile("Jobs.txt"));
        reverseDispacher.handleJobs(jobReader.readJobFile("Jobs.txt"));

        // int n = lwDispatcher.jobsList.size();
        
        int i = 0;  
        for (Job job : lwDispatcher.jobsList) {
            if (job.timeInQueue()<0 || i++ < 10 || i > lwDispatcher.jobsList.size() -10) {
                System.out.println(job.getArrivalTime() + " : " + job.getTotalProcessingTime() + " : " + job.getFinishTime() + " : " + job.timeInQueue());
                lwTotalTimeInQueue += job.timeInQueue();
            }
        } 
        
        i = 0;
        for (Job job : randDispatcher.jobsList) {
            if (job.timeInQueue()<0 || i++ < 10 || i > randDispatcher.jobsList.size() -10) {
                System.out.println(job.getArrivalTime() + " : " + job.getTotalProcessingTime() + " : " + job.getFinishTime() + " : " + job.timeInQueue());
                randTotalTimeInQueue += job.timeInQueue();
            }
        }
        
        i = 0;
        for (Job job : sqDispatcher.jobsList) {
            if (job.timeInQueue()<0 || i++ < 10 || i > sqDispatcher.jobsList.size() -10) {
                System.out.println(job.getArrivalTime() + " : " + job.getTotalProcessingTime() + " : " + job.getFinishTime() + " : " + job.timeInQueue());
                sqTotalTimeInQueue += job.timeInQueue();
            }
        }
        
        i = 0;
        for (Job job : rrDispacher.jobsList) {
            if (job.timeInQueue()<0 || i++ < 10 || i > rrDispacher.jobsList.size() -10) {
                System.out.println(job.getArrivalTime() + " : " + job.getTotalProcessingTime() + " : " + job.getFinishTime() + " : " + job.timeInQueue());
                rrTotalTimeInQueue += job.timeInQueue();
            }
        }

        i = 0;
        for (Job job : worstDispacher.jobsList) {
            if (job.timeInQueue()<0 || i++ < 10 || i > worstDispacher.jobsList.size() -10){
                System.out.println(job.getArrivalTime() + " : " + job.getTotalProcessingTime() + " : " + job.getFinishTime() + " : " + job.timeInQueue());
                worstTotalTimeInQueue += job.timeInQueue();
            }
        }

        i = 0;
        for (Job job : reverseDispacher.jobsList) {
            if (job.timeInQueue()<0 || i++ < 10 || i > reverseDispacher.jobsList.size() -10) {
                System.out.println(job.getArrivalTime() + " : " + job.getTotalProcessingTime() + " : " + job.getFinishTime() + " : " + job.timeInQueue());
                reverseTotalTimeInQueue += job.timeInQueue();
            }
        }

        System.out.println("lwDispacher time in queue: " + lwTotalTimeInQueue);
        System.out.println(" randDispacher time in queue: " + randTotalTimeInQueue);
        System.out.println("sqDispacher time in queue: " + sqTotalTimeInQueue);
        System.out.println(" rrDispacher time in queue: " + rrTotalTimeInQueue);
        System.out.println("worstDispacher time in queue: " + worstTotalTimeInQueue);
        System.out.println(" reverseDispacher time in queue: " + reverseTotalTimeInQueue);

    }
}