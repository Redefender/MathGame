import java.util.Scanner;

public class Player {

    public Player(String n)
   {
      name  = n;
   }
   
   private String name = "";
   private int wins = 0;
   private int numCorrectInRound = 0;
   private int answer = 0;
   public boolean turn = true;
   
   public int getAnswer() {return answer;}
   public int getNumCorrect() {return numCorrectInRound;}
   public String getName() {return name;}
   
   public void setAnswer()
   {
      Scanner stdin = new Scanner(System.in);
      System.out.println("Answer: ");
      answer = stdin.nextInt();
   }
   public void increaseNumCorrect()
   {
      numCorrectInRound++;
   }
   public void increaseWins()
   {
      wins++;
   }
   
}