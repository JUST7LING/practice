
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int i = s.nextInt();
		
		if(i%5 == 0)
			System.out.println(i/5);
		else 
			System.out.println(i/5+1);
		
	}
}