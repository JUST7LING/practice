import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int x, y;
		Scanner s = new Scanner(System.in);
		
		y = s.nextInt();
		x = s.nextInt();
		
		if(x<45) {
			x +=60;
			y --;
			if (y<0) {
				y +=24;
			}
		}
		
		System.out.println(y+" "+(x-45));
	}

}
