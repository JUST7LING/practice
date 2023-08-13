
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		String ah1, ah2;
		ah1 = s.nextLine();
		ah2 = s.nextLine();
		
		if(ah1.length()>= ah2.length()) {
			System.out.println("go");
		}else {
			System.out.println("no");
		}
	}
}