
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int gae;
		int ind, max;
		Scanner s = new Scanner(System.in);
		
	//	gae = s.nextInt(); // 몇 개의 정수?
		gae = 9;
		int[] list = new int[gae];
		
		for(int j = 0; j<gae; j++) {
			list[j] = s.nextInt();
		}
		
		max = list[0];
	//	min = list[0];
		ind = 0;
		int i;
		for(i = 0; i<list.length; i++) {
			if(max < list[i]) {
				max = list[i];
				ind = i;
			}
		}
		System.out.println(max);
		System.out.println(ind+1);
	}

		
		
}
