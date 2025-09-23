import java.util.*;

public class Main {
	
	static int[][] schedule;
	static int result;
	
	static void setter() {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		schedule = new int[size][2];
		for(int i = 0; i<size; i++) {
			schedule[i][0] = sc.nextInt(); // 첫 줄은 상담하는 데 걸리는 시간 T
			schedule[i][1] = sc.nextInt(); // 두 번째 줄은 상담 보수 P
		}
	}
	
	public static void main(String[] args) {
		// 좋겠다 퇴사할 수 있는 직장인이라서
		setter();
		filter();
		calc(0, 0);
		System.out.println(result);
	}
	
	static void filter() { // 불가능한 일정을 감지하고 0으로 바꾼다.
		int lastDay = schedule.length - 1;
		for(int i = 0; i<schedule.length; i++) {
			if(schedule[i][0] + i - 1 > lastDay) {
				schedule[i][1] = 0; 
				// calc가 T를 기준으로 재귀호출을 중지하므로, P만 무효시킨다.
			}
		}
	}
	
	// index번째의 상담을 한다 vs 만다
	static void calc(int index, int sum) { 
		if(index >= schedule.length) {
			// 종료 조건 및 정리
			if(sum > result) result = sum;
			return;
		}
		
		// 진행시켜
		sum += schedule[index][1];
		calc(index + schedule[index][0], sum);
		
		// 가마이써
		sum -= schedule[index][1];
		calc(index + 1, sum);
	}

}
