import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int size = s.nextInt();
		
		for(int i = 0; i<size/4; i++) {
			System.out.print("long ");
		}
		System.out.println("int");
	}

}
