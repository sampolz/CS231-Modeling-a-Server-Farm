/*
 * Sam Polyakov
 * RandomDispacher.java
 * 03/05/2023
 * Project 4
 * CS231 B
 */

import java.util.Random;

public class RandomDispatcher extends JobDispatcher{
    // dispaches jobs to servers in a random order

    protected LinkedList<Server> serversAvailable;
    Random rand = new Random() ;

    public RandomDispatcher(int k) {
        // specifies number of servers
        super(k);
    }

    public Server pickServer(Job j) {
        // returns a random server
        serversAvailable = super.serversMaintained;
        return serversAvailable.get(rand.nextInt(serversAvailable.size()));
    }
    
}
