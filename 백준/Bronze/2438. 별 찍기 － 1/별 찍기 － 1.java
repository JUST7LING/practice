
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int loop = s.nextInt();
		
		for(int i = 0; i<loop; i++) {
			for(int j = 0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

		
		
}
