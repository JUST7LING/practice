
import java.util.Scanner;

public class Main {
     public static void main(String[] args)
    {
      	 Scanner s = new Scanner(System.in);
      	 
      	 int[] found = new int[6];
      	 int[] chess = {1, 1, 2, 2, 2, 8};
      	 int[] compare = new int[6];      	 
      	 for(int i = 0; i<found.length; i++) {
      		 
      		 found[i] = s.nextInt();
      	 }
      	 
      	 for(int j = 0; j<compare.length; j++) {
      		 
      		 compare[j] = chess[j]-found[j];
      		 
      		 
      	 }
      	 
      	 for(int k : compare) {
      		 
      		 System.out.print(k+" ");
      	 }
      	 
    }
}