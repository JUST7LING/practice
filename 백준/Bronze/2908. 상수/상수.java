
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		String s = sc.nextLine(); 
		int compA, compB;
		StringTokenizer st = new StringTokenizer(s, " ");
		
		compA = Integer.parseInt(st.nextToken());
		compB = Integer.parseInt(st.nextToken());
		
		compA = reverse(compA);
	/**/
		compB = reverse(compB);
		
		if(compA>compB) {
			System.out.println(compA);
			
		}else {
			System.out.println(compB);
		}
	
	} // main
	
	public static int reverse(int comp) {
		
		int hundred, ten, one; // 자릿수
		hundred = comp/100;
		
		comp -= hundred*100;
		
		ten = comp/10;
		
		comp -= ten*10;
		
		one = comp;
		
		comp = one*100 + ten*10 + hundred;
		
		return comp;
		
	}
		
} // Main
