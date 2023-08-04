
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
     public static void main(String[] args)
    {
   
    	 Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      
      
      ArrayList<Character> chars = new ArrayList<>();
      for(int i = 0; i<s.length(); i++) {
    	  chars.add(s.charAt(i));
      }
      
      ArrayList<Character> abc = new ArrayList<>();
      String rawAbc = "abcdefghijklmnopqrstuvwxyz";
      for(int i = 0; i<rawAbc.length(); i++) {
    	  abc.add(rawAbc.charAt(i));
      }
      
      for(int i = 0; i<abc.size(); i++) {
    	  if(chars.contains(abc.get(i))) {
    		  System.out.print( chars.indexOf(abc.get(i))+" ");
    	  }
    	  else
    	  System.out.print(-1+" ");
    	  
      }
      
     
    }
}