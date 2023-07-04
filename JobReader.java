/*
 * Sam Polyakov
 * JobReader.java
 * 03/05/2023
 * Project 4
 * CS231 B
 */

import java.io.*;

public class JobReader {
  // reads input txt file

    public Queue<Job> readJobFile(String filename){
    
        try {
            // assign to a variable of type FileReader a new FileReader object, passing filename to the constructor
            FileReader fr = new FileReader(filename);
            // assign to a variable of type BufferedReader a new BufferedReader, passing fr to the constructor
            BufferedReader br = new BufferedReader(fr);
            // assign to a variable of type Queue<Job> a new LinkedList.
            Queue<Job> jobSequence = new LinkedList<Job>();
      
            // assign to a variable of type String line the result of calling the readLine method of the BufferedReader.
            String line = br.readLine();
            // everytime we call br.readLine(), we advance to the next line of the file we are reading. 
            // Since the first line of the job files are just the headers, 
            //   let's skip the first line by calling br.readLine again: 
            line = br.readLine();
            // start a while loop that loops while line isn't null
            while(line != null){
                // assign to an array of type String the result of calling split on the line with the argument ","
                String[] arr = line.split(",");
                // let's see what this array holds: 
                // System.out.println("the first item in arr: " + arr[0] + ", the second item in arr: " + arr[1]);
                // using this String array arr, make a new Job object and offer it into jobSequence:
                Job newJob = new Job(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]));
                jobSequence.offer(newJob);
                line = br.readLine();
            }
            // call the close method of the BufferedReader:
            br.close();
            return jobSequence;
          }
          catch(FileNotFoundException ex) {
            System.out.println("JobReader.read():: unable to open file " + filename + ": file not found");
          }
          catch(IOException ex) {
            System.out.println("JobReader.read():: error reading file " + filename);
          }
      
          return null;
        }

        public static void main(String[] args) {
          JobReader jobReader = new JobReader();
          // Queue<Job> jobSequence = jobReader.readJobFile("JobSequence_7_30.txt");
          Queue<Job> jobSequence = jobReader.readJobFile("Jobs.txt");
          LeastWorkDispatcher lwDispatcher = new LeastWorkDispatcher(10);
          lwDispatcher.handleJobs(jobSequence);

          double total = 0;
          for (Job job : lwDispatcher.jobsList) {
              total += job.timeInQueue();
              System.out.println("Arrival time: " + job.arrivalTime + " Finish time: " + job.finishTime);
          }
  
          System.out.println("Total time: " + total);
  
          double averageTimeInQueue = total / lwDispatcher.jobsList.size();
  
          System.out.println("Average time: " + averageTimeInQueue);

        }
}
