import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int[] arr = new int[9];
	static int[] result = new int[7];
	static Stack<Integer> pick = new Stack<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<arr.length; i++) {
			arr[i] = sc.nextInt(); 
		}
		pick7(0);
		
		Arrays.sort(result);
		for(int i : result) System.out.println(i);
			
	}
	
	public static void pick7(int index) {
		if(index >= arr.length) {
			// 끝까지 다 돌았다
			if(pick.size() == 7) {
				// System.out.println(Arrays.toString(pick.toArray())); // 조합 확인하기
				int sum = 0;
				for(int i : pick) {
					sum += i;
				}
				if(sum == 100) {
					for(int i = 0; i<result.length; i++) {
						result[i] = (int) pick.toArray()[i];
					}
					
					// 원본 stack의 요소와 순서를 건드리지 않도록 주의한다. 남은 DFS 시행이 있기 때문임 
				}
			}
			return;
		} 
		
		// arr[index]를 답안에 포함하기
		pick.add(arr[index]);
		pick7(index+1);
		
		// arr[index]를 답안에서 제외하기
		pick.pop();
		pick7(index+1);
	}
}
