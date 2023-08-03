
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int[] homework = new int[30];
		int did;
		
		for (int i = 0; i<homework.length; i++) {
			homework[i] = 0;
			
		}
		for (int i = 0; i<28; i++) {
			did = s.nextInt();
			did -= 1;
			
			homework[did] = 1;
			
		}
		for (int i = 0; i<homework.length; i++) {

			if(homework[i] == 0) {
				System.out.println(i+1);
			}
			else{
				continue;
			}
			
		}
		
	}

		
		
}
