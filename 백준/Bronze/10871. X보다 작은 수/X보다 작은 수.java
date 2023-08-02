import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int gae, find, found;
		int small;
		Scanner s = new Scanner(System.in);
		
		gae = s.nextInt(); // 몇 개의 정수?
		int[] list = new int[gae];
		small = s.nextInt();
		
		for(int i = 0; i<gae; i++) {
			list[i] = s.nextInt();
		}
		for(int i = 0; i<list.length; i++) {
			if(small > list[i]) {
				System.out.print(list[i]+" ");
			}
		}
	}

		
		
}