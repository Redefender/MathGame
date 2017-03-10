import java.util.Random;


import java.util.Scanner;

public class GameKeeper extends StopWatch {
   private String arena = "";
   private int answer = 0;
   boolean gameRunning = true;
   
   public void gameAgain() {
      Scanner stdin = new Scanner(System.in);
      
      String i = "";
      System.out.println("Would you like to play again (Y/N)?");
      i = stdin.nextLine();
      while((!"Y".equalsIgnoreCase(i)) && (!"N".equalsIgnoreCase(i)))
      {
         System.out.println("Enter either Y or N");
         i = stdin.nextLine();
      }
      if("Y".equals(i) || "y".equals(i))
      {
         gameRunning = true;
      }
      else
      {
         gameRunning  = false;
      }
      
   }
   public void setArena()
   {
      Scanner stdin = new Scanner(System.in);
      
      System.out.println("Choose your Arena:");
      System.out.println("MULTIPLICATION");
      System.out.println("DIVISION");
      System.out.println("SUBTRACTION");
      System.out.println("ADDITION");
      
      String a = stdin.nextLine();
      
      while(!"MULTIPLICATION".equalsIgnoreCase(a) && !"DIVISION".equalsIgnoreCase(a)
      && !"SUBTRACTION".equalsIgnoreCase(a) && !"ADDITION".equalsIgnoreCase(a))
      {
         System.out.println("That's not an option try again: ");
         a = stdin.nextLine();
      }
      
      arena = a.toUpperCase();
   }
   public void generateQuestion()
   {
      Random rand = new Random();
      int num1 =0, num2=0;
      
      
      if("MULTIPLICATION".equals(arena))
      {
         num1 = rand.nextInt(12) + 1; //0 - 12
         num2 = rand.nextInt(12) + 1;
         
         System.out.println(num1 + " * " +  num2);
         answer = num1 * num2;
      }
      else if("DIVISION".equals(arena))
      {
         num1 = rand.nextInt(144) + 1; //tests  up to 12X12 tables
         num2 = rand.nextInt(12) + 1;
         
         while(num1%num2 != 0 || num1/num2 > 12 )
         {
            num1 = rand.nextInt(100) + 1;
            num2 = rand.nextInt(12) + 1;
         }
         System.out.println( num1 + " / " + num2);
         answer = num1/num2;
      }
      else if("SUBTRACTION".equals(arena))
      {
         num1 = rand.nextInt(100) + 1;
         num2 = rand.nextInt(100) + 1;
         
         while(num1 - num2 < 0)
         {
            num1 = rand.nextInt(100) + 1;
            num2 = rand.nextInt(100) + 1;
         }
         
         System.out.println(num1 +  " - " + num2 );
         answer = num1-num2;
         
      }
      else if("ADDITION".equals(arena))
      {
         num1 = rand.nextInt(100) + 1;
         num2 = rand.nextInt(100) + 1;
         
         System.out.println(num1 + " + " + num2);
         answer = num1 + num2;
      }
      else
      {
         System.out.println("method error(minor)");
      }
   }
   public void ready() throws InterruptedException
  {
      Scanner stdin = new Scanner(System.in);
      
      System.out.println("Ready(Y)?");
      String userConfirm = stdin.nextLine();
      
      
      
      while(!"Y".equalsIgnoreCase(userConfirm))
      {
         System.out.println("Enter Y to continue: ");
         userConfirm = stdin.nextLine();
      }
      System.out.println("1...");
      Thread.sleep(1000);
      System.out.println("2...");
      Thread.sleep(1000);
      System.out.println("3...");
      Thread.sleep(1000);
      System.out.println("GO!");
      System.out.println();
     
      
  }
   
   public int getAnswer(){return answer;}
   
 }