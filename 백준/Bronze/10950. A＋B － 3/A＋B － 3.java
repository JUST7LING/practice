
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int x, y, loop;
		Scanner s = new Scanner(System.in);
		loop = s.nextInt();
		
		int[] add = new int[loop];
		
		for(int i =0; i<loop; i++) {
			
			x = s.nextInt();
			y = s.nextInt();
			add[i] = x+y;
		}
		
		for(int i : add) {
			System.out.println(i);
		}
		
				
	}
		
}