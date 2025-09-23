import java.util.*;

public class Main {
	static int N, B, C;
	static int[] A;
	
	static void setter() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine(); // 개행문자 제거
		String[] nums = sc.nextLine().split(" ");
		A = new int[nums.length];
		for(int i = 0; i<nums.length; i++) {
			A[i] = Integer.parseInt(nums[i]);
		}
		
		B = sc.nextInt();
		C = sc.nextInt();
		sc.close();
		
		// System.out.printf("%d, %s, %d, %d\n", N, Arrays.toString(A), B, C);
	}
	
	public static void main(String[] args) {
		setter();
		System.out.println(count());
		// 총감독관은 무조건 있어야 한다. 
	}
	
	public static long count() {
		long result = 0L;
		for(int each : A) {
			result++;
			if(each > B)  {
				int left = each - B;
				result += left / C;
				if(left % C != 0) result++; 
			}
		}
		return result;
	}	
}
