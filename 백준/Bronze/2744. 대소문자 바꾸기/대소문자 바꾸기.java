import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 char[] in = sc.next().toCharArray();
		 
		 String result = "";
		 for(int i = 0; i<in.length; i++) {
			 if((int) in[i]>96) {
				 result += (char) (in[i]-32);
				 continue;
			 }
			 result += (char) (in[i]+32);
		 }
		 
		 System.out.println(result);
	}
}
