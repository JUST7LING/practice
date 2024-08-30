import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 char[] in = sc.next().toCharArray();
		 
		 for(int i = 0; i<in.length; i++) {
			 if((int) in[i]>96) {
				 System.out.print((char) (in[i]-32));
				 continue;
			 }
			 System.out.print((char) (in[i]+32));
		 }
	}
}
