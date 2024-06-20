import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int loop;
	static int[] triNums; // 범위 내의 모든 삼각수를 저장함
	static boolean is3; // 3개의 삼각수의 합으로 이루어질 수 있는가
	
	
	public static void main(String[] args) {
		// 3<=k<=1000이기 때문에 1000을 넘지 않는 범위까지의 삼각수 배열 모두 만들기
		setArr();
		Scanner sc = new Scanner(System.in);
		loop = sc.nextInt(); // TC 수
		for(int i =0; i<loop; i++) {
			is3 = false; // 초기화
			calc(sc.nextInt(), 1); // 중복을 허용하는 triNums 내의 모든 조합 확인 
			if(is3) System.out.println(1); 
			else System.out.println(0);
		} // for
		
	} // main
	
	static void setArr() { // 범위 내의 모든 삼각수를 세팅하는 함수
		// T(n) = T(n-1) + n
		int T = 1; 
		int n = 2;
		ArrayList<Integer> nums = new ArrayList<>();
		while(T<=1000) {
			nums.add(T);
			T += n;
			n++;
		}
		
		triNums = new int[nums.size()];
		for(int i = 0; i<nums.size(); i++) {
			triNums[i] = nums.get(i);
		}
		
	}
	
	static void calc(int num, int nth) { // DFS, 삼각수 배열을 순회하면서 num에서 반복적으로 삼각수를 뺀다
		// nth == 3이고 num == 0일 때가 성공 조건이다.
		for(int i =0; i<triNums.length; i++) {
			int sub = num-triNums[i];
			if(sub<0) break; // 뒤로 갈수록 큰 수다. 삼각수가 num을 초과하기 시작하면 진행하지 않음
			
			
			if(nth<3 && sub != 0) {
				calc(sub, nth+1);
				
			}else if(nth==3) {
				if(sub==0) {
					is3 = true;
					return;
				}
				// return; // << 여기에 return이 있으면 특정 케이스(e.g. 9, 30, 1000 등)에서 잘못된 값 도출
			}
		}
		
		
	} // void calc
} // class Main
