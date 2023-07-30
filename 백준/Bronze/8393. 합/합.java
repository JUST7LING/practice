
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int x, sum;
		sum = 0;
		Scanner s = new Scanner(System.in);
		x = s.nextInt();
		for(int i = 1; i<x+1; i++) {
			sum +=i;
		}
		System.out.println(sum);
				
	} // main
		
} // Main
