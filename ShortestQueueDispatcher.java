/*
 * Sam Polyakov
 * ShortestQueueDispacher.java
 * 03/05/2023
 * Project 4
 * CS231 B
 */


public class ShortestQueueDispatcher extends JobDispatcher{
    // dispaches jobs to servers in order of smallest queue
    private LinkedList<Server> serversAvailable;
    private Server tempServer;

    public ShortestQueueDispatcher(int k) {
        super(k);
    }


    public Server pickServer(Job j) {
        //picks whichever Server has the smallest-sized queue
        serversAvailable = super.serversMaintained;
        tempServer = serversAvailable.get(0);

        for(Server s : serversAvailable){
            if(s.size() < tempServer.size()){
                tempServer = s;
            }
        }
        return tempServer;
    }
    
}
