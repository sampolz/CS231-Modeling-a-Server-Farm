/*
 * Sam Polyakov
 * RoundRobinDispacher.java
 * 03/05/2023
 * Project 4
 * CS231 B
 */



public class RoundRobinDispatcher extends JobDispatcher{
    // dispaches jobs to servers in a round-robin order

    private LinkedList<Server> serversAvailable;
    int counter;

    public RoundRobinDispatcher(int k) {
        // specifies number of servers
        super(k);
        counter = 0;
    }

    public Server pickServer(Job j) {
        // returns Servers in a round-robin process
        serversAvailable = super.serversMaintained;

        if(counter == serversAvailable.size()){
            counter = 0;
        }
        counter++;

        return serversAvailable.get(counter-1);
    }   

}
