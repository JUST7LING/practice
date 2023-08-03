import java.util.Scanner;

public class Main {
     public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      int loop;
      String str;
      loop = s.nextInt();
      String[] strs = new String[loop];
      /* */
      s.nextLine();
      for ( int i = 0; i<loop; i++) {
    	  
    	  str = s.nextLine();
    	  strs[i] = str.charAt(0)+""+str.charAt(str.length()-1)+"";
      }
      
      for(String sr : strs) {
    	  
    	  System.out.println(sr);
      }
    
    }
}