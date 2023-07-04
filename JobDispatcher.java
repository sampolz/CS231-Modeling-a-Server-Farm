/*
 * Sam Polyakov
 * JobDispacher.java
 * 03/05/2023
 * Project 4
 * CS231 B
 */


public abstract class JobDispatcher{
    // dispaches jobs to servers
    
    protected LinkedList<Server> serversMaintained;
    private double systemTime;
    LinkedList<Job> jobsList;


    public JobDispatcher(int k){
        //constructs a JobDispatcher with k total Servers
        serversMaintained = new LinkedList<Server>() ;
        jobsList = new LinkedList<>();
        systemTime = 0;
        for(int i = 0; i < k; i++){
            Server s = new Server();
            serversMaintained.add(s) ;
        }
    }
    

    public void advanceTimeTo(double time){
        //updates the current time to the specified time and calls the processTo method for each Server it maintains.
        systemTime = time;
        for (Server s : serversMaintained){
            s.processTo(time);
        }       
    }


    public void finishUp(){
        // advances the time to the earliest point when all jobs will have completed.
        double longestTime = 0;
        for (Server s : serversMaintained){
            if(s.remainingWorkInQueue()>longestTime){
                longestTime = s.remainingWorkInQueue();
            }
        }
        advanceTimeTo(systemTime+longestTime); 
    }


    public void handleJob(Job job){
        /*  advances the time to job's arrival time, 
        picks the Server appropriate for job (whichever one is returned by the pickServer method), 
        and adds job to the chosen Server.
        */
        advanceTimeTo(job.getArrivalTime());
        pickServer(job).addJob(job);
    }


    public void handleJobs(Queue<Job> jobs){
        /*polls each Job from the specified queue of Jobs and calls handleJob on them. 
        After all the Jobs have been handled, calls finishUp() */
        int n = jobs.size();
        for(int i = 0; i < n; i++){
            Job firstJob = jobs.poll();
            jobsList.add(firstJob);
            handleJob(firstJob);
        }
        finishUp();
    }


    public abstract Server pickServer(Job j);
    // picks server to send job to that server
    
}