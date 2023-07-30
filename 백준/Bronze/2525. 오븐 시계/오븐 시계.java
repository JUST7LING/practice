import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int x, y, z, a;
		Scanner s = new Scanner(System.in);
		
		x = s.nextInt();
		y = s.nextInt();
		z = s.nextInt();
		
		x += z/60;
		y += z%60;
		
		if (y>=60) {
			y -= 60;
			x ++;
		}
		if (x>=24) {
			x -= 24;
		}
		
		System.out.println(x+" "+y);
	}

}
