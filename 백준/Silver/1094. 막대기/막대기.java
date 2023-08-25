
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	   int want;
	   
	   Scanner s = new Scanner(System.in);
	   want = s.nextInt();
	   if(want>64)
		   System.out.println("퉤");
	   else
		   System.out.println(sticks(want));
	}
	
	public static int sticks(int w) {
		int stick = 0;
		int zzo = 0;
		
		int[] lengths = {64, 32, 16, 8, 4, 2, 1};
		while(w!=0) {
			for(int length:lengths) {
				zzo = w/length;
				
				if(zzo == 1) {
					stick++;
					w = w%length;
				}
				
				if(w==0)
					break;
			}
		}
		return stick;
	}

}