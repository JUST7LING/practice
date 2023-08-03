import java.util.Scanner;

public class Main {
     public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      int length = s.nextInt();
      
      int[] score = new int[length];
      double[] newScore = new double[length];
      
      for(int j = 0; j<length; j++) {
    	  score[j] = s.nextInt();
    	  
      }
      
      int max, i;
      max = score[0];
      for(i=0; i<length; i++) {
    	  if(max<score[i])
    		  max = score[i];
      }
      
      for(int j = 0; j<length; j++) {
    	  newScore[j] = (double) score[j]/max*100;
    	  
      }
      
      double sum = 0;
      double avg;
      for(int j =0; j<length; j++) {
    	  sum+=newScore[j];
      }
      
      avg = sum / length;
      
      System.out.println(avg);

    }
}