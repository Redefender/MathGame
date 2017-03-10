import java.lang.Object;
import java.util.Scanner;

public class MathChallenge {

   public static void main(String[] args) throws InterruptedException {
      //create vars

      StopWatch timer = new StopWatch();
      GameKeeper warden = new GameKeeper();
      Scanner stdin = new Scanner(System.in);
      boolean gameRunning = true;
 
      System.out.println("Enter player 1 name: ");
      Player player1 = new Player(stdin.nextLine());
      
      System.out.println("Enter player 2 name: ");
      Player player2 = new Player(stdin.nextLine());
      
   
      while(warden.gameRunning)
      {
         warden.getTimePerPlayer();
         warden.setArena();
         System.out.println(player1.getName() + "'s turn!");
         warden.ready();
         warden.prep();
         warden.start(); //must start outside of player loop or else will restart every time
         while(player1.turn)
         {
            
            //System.out.println(warden.elapsed()); 
            warden.generateQuestion();
            player1.setAnswer();
            if(player1.getAnswer() == warden.getAnswer() )
            {
               System.out.println("Correct!");
               player1.increaseNumCorrect();
            } 
            warden.endTimerWhenDone();
            
            if(warden.timerDone)
            {
               player1.turn = false;
               player2.turn = true;
               warden.timerDone = false;
            }

         }

         System.out.println(player2.getName() + "'s turn!");
         warden.ready();
         warden.prep();
         warden.start();
         while(player2.turn)
         {
            //System.out.println(warden.elapsed());
            warden.generateQuestion();
            player2.setAnswer();
     
    
            if(player2.getAnswer() == warden.getAnswer() )
            {
               System.out.println("Correct!");
               player2.increaseNumCorrect();
            } 
            warden.endTimerWhenDone();

            
            if(warden.timerDone) //noooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
            {
               player1.turn = true;
               player2.turn = false;
               warden.timerDone = false;
            }
         }
         
         System.out.println(player1.getName() + ": " +  player1.getNumCorrect() + " " + player2.getName() + ": " +  player2.getNumCorrect() );
         warden.gameAgain();
      }//end gameRunning
   
   

  
   
      
   
 
   String toString = warden.toString();
   System.out.println("You played for " + toString);
  } //end main
  
}