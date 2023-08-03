
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int add, diff;
		
		diff = 0;
		ArrayList<Integer> nums = new ArrayList<>();
		for(int i = 0; i<10; i++) {
			add = s.nextInt()%42;
			
			if(nums.size() != 0) {
				if(!nums.contains(add))
					diff++;
				nums.add(add);
			}
			else
				nums.add(add);
			
			
		}
		System.out.println(diff+1);
		
	}

		
		
}
