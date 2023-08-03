import java.util.Scanner;

public class Main {
     public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      String lala = s.nextLine(); // 버릴 거임 ㅋㅋ
      
      String a = s.nextLine();
      char[] as;
      int sum =0;
      for(int i = 0; i<a.length(); i++) {
    	  as = new char[a.length()];
    	  as[i] = a.charAt(i);
    	  sum += (int)as[i]-48;
      }
      System.out.println(sum);
      
    }
}