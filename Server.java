/*
 * Sam Polyakov
 * Server.java
 * 03/05/2023
 * Project 4
 * CS231 B
 */

public class Server {
    // creates a server
    private Queue<Job> queue;
    private double systemTime;
    private double remainingWork;

    public Server(){
        //this constructor initializes whatever fields the Server will need in order for it to support the other methods. 
        systemTime = 0;
        queue = new LinkedList<Job>();
        remainingWork = 0;
    } 

    public void addJob(Job job){
        //adds the specified Job job into the queue.
        queue.offer(job);
        remainingWork += job.getTotalProcessingTime();
    }

    public void processTo(double time){
        // The first thing I'll do is keep track of is how much time I've got until I reach the specified time to which I'm processing:
        double timeRemaining = time - systemTime;

        while (queue.size() > 0 && timeRemaining > 0.0) {
            Job currentJob = queue.peek();
            double timeToProcess = currentJob.getTimeRemaining();

            if (timeRemaining >= timeToProcess) {
                // In here, I need to make sure I process next for the right amount of time, update sysTime and myTimeRemaining, and make sure I set next's finish time accordingly. Also, since next is done, I should poll it from the queue.
                currentJob.process(timeToProcess);
                systemTime += timeToProcess;
                timeRemaining -= timeToProcess;
                currentJob.setFinishTime(systemTime);
                remainingWork -= timeToProcess;
                queue.poll();
            }
            // if myTimeRemaining is less than next's remaining processing time, then I can't finish it now, and should instead process it for all of my remaining time
            else {
                // In here, I need to make sure I process next for the right amount of time, update sysTime and myTimeRemaining. In this case, I shouldn't be setting next's finish time since it's not done yet.
                currentJob.process(timeRemaining);
                systemTime += timeRemaining;
                remainingWork -= timeRemaining;
                timeRemaining = 0;
            }
        }
        // At the end of the while loop, I should make sure that I set my sysTime to be the specified time, in case I ran out of jobs to process:
        systemTime = time;
    }
    

    public double remainingWorkInQueue(){
        //returns the total remaining processing time in this Server's queue.
        return remainingWork;
    }

    public int size(){
        //returns the number of Jobs in this Server's queue.
        return queue.size();
    }

    public static void main(String[] args) {
        Job j1 = new Job(0,30);
        Job j2 = new Job(30,20);

        Server s = new Server();

        s.addJob(j1);
        s.addJob(j2);
        System.out.println("size:" + s.size() + "\n remaining work:" + s.remainingWorkInQueue());
        s.processTo(20);
        System.out.println("size:" + s.size() + "\n remaining work:" + s.remainingWorkInQueue());
        s.processTo(30);
        System.out.println("size:" + s.size() + "\n remaining work:" + s.remainingWorkInQueue());
    }
}
