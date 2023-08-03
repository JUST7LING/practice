
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int gae;
		int min, max;
		Scanner s = new Scanner(System.in);
		
		gae = s.nextInt(); // 몇 개의 정수?
		int[] list = new int[gae];
		
		for(int i = 0; i<gae; i++) {
			list[i] = s.nextInt();
		}
		max = list[0];
		min = list[0];
		for(int i = 0; i<list.length; i++) {
			if(max < list[i]) {
				max = list[i];
			}
			if(min > list[i]) {
				min = list[i];
			}
		}
		System.out.println(min+" "+max);
	}

		
		
}
