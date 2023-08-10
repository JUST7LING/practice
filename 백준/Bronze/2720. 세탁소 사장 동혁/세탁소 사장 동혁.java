
import java.util.Scanner;

public class Main {
     public static void main(String[] args)
    {
      	Scanner s = new Scanner(System.in);
      	int loop = s.nextInt();
      	int change;
      	int qt, dm, nk, pn;
      	
      	for(int i = 0; i<loop; i++) {
      		
      		change = s.nextInt();
      		qt = change/25;
      		change = change-qt*25;
      		dm = change/10;
      		change = change-dm*10;
      		nk = change/5;
      		change = change-nk*5;
      		pn = change;
      		
      		System.out.println(qt+" "+dm+" "+nk+" "+pn);
      	}
    	
    }// static void main
}// class main