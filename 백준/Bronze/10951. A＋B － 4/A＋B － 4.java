
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		int a, b, sum;
		String line;
		Scanner s = new Scanner(System.in);
		StringTokenizer st;
		
		while(s!=null) {
			try {
			line = s.nextLine();
			st = new StringTokenizer(line, " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			sum =  a+b;
			System.out.println(sum);
			}
			catch(NoSuchElementException e) {
				break;
			}
		}
	}

		
		
}