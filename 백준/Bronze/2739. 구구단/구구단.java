import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int x;
		Scanner s = new Scanner(System.in);
		
		x = s.nextInt();
		
		for(int i =1; i<10; i++) {
			System.out.println(x+" * "+i+" = "+x*i);
		}
				
	}
		
}
