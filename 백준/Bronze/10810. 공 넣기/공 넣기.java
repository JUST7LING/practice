import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n, m;
		int start, end, num;
		
		n = s.nextInt();//바구니의 개수
		m = s.nextInt(); // 공을 던질 횟수
		
		int[] baskets = new int[n];
		for(int i : baskets) {
			i = 0;
		}
		
		for(int i =0; i<m; i++) {
			start = s.nextInt();
			end = s.nextInt();
			num = s.nextInt();
			
			for (int j = start-1; j<end; j++) {
				baskets[j] = num;
				
			}
			
		}
		for(int i : baskets) {

			System.out.print(i + " ");
		}
		
	}

		
		
}
