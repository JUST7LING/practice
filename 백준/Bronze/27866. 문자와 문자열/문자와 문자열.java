import java.util.Scanner;

public class Main {
     public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      String str; int i;
      
      str = s.nextLine();
      i = s.nextInt()-1;
      
      System.out.println(str.charAt(i));
    }
}