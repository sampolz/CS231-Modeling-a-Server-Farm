/*
 * Sam Polyakov
 * RoundRobinDispacher.java
 * 03/05/2023
 * Project 4
 * CS231 B
 */



 public class ReverseRoundRobinDispatcher extends JobDispatcher{
    // dispaches jobs to servers in a reverse round-robin order

    private LinkedList<Server> serversAvailable;
    int counter;

    public ReverseRoundRobinDispatcher(int k) {
        // specifies number of servers
        super(k);
        counter = k-1;
    }

    public Server pickServer(Job j) {
        // returns Servers in a reverse round-robin process
        serversAvailable = super.serversMaintained;

        if(counter < 0){
            counter = serversAvailable.size()-1;
        }
        counter--;

        return serversAvailable.get(counter+1);
    }   

}
