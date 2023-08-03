
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n, m;
		int start, end, num, temp;
		
		n = s.nextInt();//바구니의 개수
		m = s.nextInt(); // 공을 던질 횟수
		
		int[] baskets = new int[n];
		for(int i =0; i<baskets.length; i++) {
			baskets[i] = i+1;
		}
		
		/**/
		for(int i =0; i<m; i++) {
			start = s.nextInt();
			end = s.nextInt();
		//	num = s.nextInt();
			start--;
			end--;
			
			temp = baskets[start];
			baskets[start] = baskets[end];
			baskets[end] = temp;
			
		}
		for(int i : baskets) {

			System.out.print(i + " ");
		}
		
	}

		
		
}
