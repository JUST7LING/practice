
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		
		int count = 0;
		for (int i = 0; i<str.length()/2; i++) {
			
			if(str.charAt(str.length()-1-count)==str.charAt(count))
					count++;
			
			else {
				count = 0;
				break;
			}
			
		}
		
		if(str.length()==1) {
			count = 1;
		}
		
		if(count>=1)
			count = 1;
		
		System.out.println(count);
	} // main
	
} // Main
