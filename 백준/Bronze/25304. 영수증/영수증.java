
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int a, b, pay, sum, loop;
		sum = 0;
		Scanner s = new Scanner(System.in);
		pay = s.nextInt();
		loop = s.nextInt();
		
		for (int i =0; i<loop; i++) {
			a = s.nextInt();
			b = s.nextInt();
			sum += a*b;
			
		}
		
		if(sum == pay) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
	} // main
		
} // Main