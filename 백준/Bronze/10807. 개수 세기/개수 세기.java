
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int gae, find, found;
		Scanner s = new Scanner(System.in);
		
		gae = s.nextInt(); // 몇 개의 정수?
		int[] list = new int[gae];
		
		for(int i = 0; i<gae; i++) {
			list[i] = s.nextInt();
		}
		found = 0;
		find = s.nextInt();
		for(int i = 0; i<list.length; i++) {
			if(find == list[i]) {
				found++;
			}
		}
		System.out.println(found);
	}

		
		
}
