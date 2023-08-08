
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int x, y, w, h;
		// w = 직사각형의 가로 길이
		// h = 직사각형의 세로 길이
		
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		y = sc.nextInt();
		w = sc.nextInt();
		h = sc.nextInt();
		
		int subWidth, subHeight;
		
		if(x<=(double)w/2) {
			subWidth = x;
		}
		else {
			subWidth = w-x;
		}
		
		if(y<=(double)h/2) {
			subHeight = y;
			
		}
		else {
			subHeight = h-y;
		}
		
		if(subWidth<=subHeight) {
			System.out.println(subWidth);
			
		}
		else {
			System.out.println(subHeight);
		}
	}

}
