/*
 * Sam Polyakov
 * Job.java
 * 03/05/2023
 * Project 4
 * CS231 B
 */

public class Job {
    // creates jobs
    double arrivalTime;
    double processingTime;
    double timeProcessed;
    double finishTime;

    public Job(double arrivalTime, double processingTime){
        //this constructs the job with the specified arrival time and necessary total processing time.
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
    }

    public double getArrivalTime(){
        //this returns the arrival time of this job.
        return arrivalTime;
    }

    public double getTotalProcessingTime(){
        //this returns the total necessary processing time of the job.
        return processingTime;
    }

    public double getTimeProcessed(){
        // this returns the time spent working on this job so far.
        return timeProcessed;
    }

    public double getTimeRemaining(){
        // this method returns the necessary time remaining to spend working on this job
        return (processingTime - timeProcessed);
    }

    public boolean isFinished(){
        // returns true if this job has been run to completion.
        return (processingTime == timeProcessed);
    }

    public void setFinishTime(double time){
        //this sets the time when the job completed.
        finishTime = time;
    }

    public double getFinishTime(){
        //this method returns the time when the job was completed.
        return finishTime;
    }

    public double timeInQueue(){
        //returns the difference in time between the arrival and finish times of this job
        return(finishTime - arrivalTime);
    }

    public void process(double time){
        // processes this job for the specified time units of time
        timeProcessed += time;
    }


}
