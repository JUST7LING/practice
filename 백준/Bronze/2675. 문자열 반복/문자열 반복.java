
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int loop = sc.nextInt(); // 반복 횟수
		sc.nextLine(); // flush
		StringTokenizer st;
		
		int r;
		String s;
		
		for (int i= 0; i<loop; i++) {
			
			String tok = sc.nextLine();
			st = new StringTokenizer(tok, " ");
			
			r = Integer.parseInt(st.nextToken());
			
			s = st.nextToken();
			
			
				
			for(int k = 0; k<s.length(); k++) {
					for (int j = 0; j<r; j++) {
					System.out.print(s.charAt(k));
				}
				
			}
			System.out.println();
		}
		
	} // main
		
} // Main