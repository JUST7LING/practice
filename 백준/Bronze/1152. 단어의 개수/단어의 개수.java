
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		String s = sc.nextLine(); // flush
		String temp;
		StringTokenizer st = new StringTokenizer(s, " ");
		
		while(true) {
		
		//for(int i = 0; i<7; i++) {
			try {
				temp = st.nextToken();
			
			  	count++;
			}
			catch(NoSuchElementException e) {
				
				break;
			}
			
		}
		
		System.out.println(count);
		
	} // main
		
} // Main
