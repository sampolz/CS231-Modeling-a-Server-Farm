/*
 * Sam Polyakov
 * LeastWorkDispacher.java
 * 03/05/2023
 * Project 4
 * CS231 B
 */



public class LeastWorkDispatcher extends JobDispatcher{
    // dispaches jobs to servers in order of which job has the least work in its queue

    private LinkedList<Server> serversAvailable;
    private Server tempServer;

    public LeastWorkDispatcher(int k) {
        super(k);
    }

    public Server pickServer(Job j) {
        //picks the Server with the least remaining processing time in its queue
        serversAvailable = super.serversMaintained;
        tempServer = serversAvailable.get(0);

        for(Server s : serversAvailable){
            if(s.remainingWorkInQueue() < tempServer.remainingWorkInQueue()){
                tempServer = s;
            }
        }
        return tempServer;
    }
    
}
