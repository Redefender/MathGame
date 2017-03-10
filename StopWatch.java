
import java.lang.Object;
import java.util.Scanner;

public class StopWatch {
   public double timePerPlayer=0;
   public boolean timerDone = false;
    /**
     * Whether the stopwatch is running
     */
    private boolean running;

    /**
     * Whether the Stopwatch has been paused... not actively counting but the start time should be preserved
     */
    private boolean paused;
    public boolean stopped;

    /**
     * The start time in microseconds
     */
    private long start;

    /**
     * The Start time for the current paused time
     */
    private long pausedStart;

    /**
     * The end time
     */
    private long end;

    /**
     * Default Constructor
     */
    public StopWatch() {
        this.pausedStart = 0;
        this.start = 0;
        this.end = 0;
    }

    /**
     * Determines if the Stopwatch is running (could be paused)
     *
     * @return Whether the stopwatch is currently running
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Whether this stopwatch is paused
     *
     * @return true if it is currently paused
     */
    public boolean isPaused() {
        return paused;
    }

    /**
     * Starts the Stopwatch
     */
    public void start() {
        end = 0;
        start = System.nanoTime();
        running = true;
        paused = false;
        pausedStart = -1;
    }

    /**
     * Stops the stopwatch and returns the time elapsed
     *
     * @return Stops the StopWatch
     */
    public long stop() {
        if (!isRunning()) {
            stopped = true;
            return -1;
        } else if (isPaused()) {
            running = false;
            paused = false;
            stopped = true;

            return pausedStart - start;
        } else {
            end = System.nanoTime();
            running = false;
            stopped = true;
            return end - start;
        }
    }

    /**
     * Pauses the Stopwatch
     *
     * @return The time elapsed so far
     */
    public long pause() {
        if (!isRunning()) {
            return -1;
        } else if (isPaused()) {
            return (pausedStart - start);
        } else {
            pausedStart = System.nanoTime();
            paused = true;
            return (pausedStart - start);
        }
    }

    /**
     * Resumes the StopWatch from its paused state
     */
    public void resume() {
        if (isPaused() && isRunning()) {
            start = System.nanoTime() - (pausedStart - start);
            paused = false;
        }
    }

    /**
     * Returns the total time elapsed
     *
     * @return The total time elapsed
     */
    public double elapsed() {
        if (isRunning()) {
            if (isPaused())
                return (pausedStart - start) ;
            return (System.nanoTime() - start)/1000000000.0 ;
        } else
            return (end - start);
    }

    /**
     * Returns the number of seconds this Stopwatch has elapsed
     *
     * @return The String of the number of seconds
     */
    public String toString() {
        double enlapsed = elapsed();
        return ((double) enlapsed ) + " Seconds";
    }
    
    public void getTimePerPlayer()
    {
      Scanner stdin  = new Scanner(System.in);
      System.out.println("Enter time each player gets per round: ");
      timePerPlayer = stdin.nextDouble();


    }
   
    public void endTimerWhenDone()
   {
      
      if(timePerPlayer < this.elapsed()) {
       
         timerDone = true;
      }
    
   }
   public void prep()
   {
      running = true;
      paused = false;
   }
   
    

}