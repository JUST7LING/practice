
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int A,B;
		Scanner s = new Scanner(System.in);
		A = s.nextInt();
		B = s.nextInt();
		if(A>B) System.out.println(">");
		else if(A<B) System.out.println("<");
		else if(A==B) System.out.println("==");

	}

}
