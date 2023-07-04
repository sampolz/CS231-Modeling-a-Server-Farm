/*
 * Sam Polyakov
 * WorstDispacher.java
 * 03/05/2023
 * Project 4
 * CS231 B
 */

 import java.util.Random;

 public class WorstDispacher extends JobDispatcher{
    // creates worst possible dispacher
 
     protected LinkedList<Server> serversAvailable;
     Random rand = new Random() ;
 
     public WorstDispacher(int k) {
         // specifies number of servers
         super(k);
     }
 
     public Server pickServer(Job j) {
         // puts all work in 1 server
         serversAvailable = super.serversMaintained;
         return serversAvailable.get(0);
     }
     
 }
 