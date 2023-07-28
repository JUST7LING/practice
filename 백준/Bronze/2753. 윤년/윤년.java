import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int A;
		Scanner s = new Scanner(System.in);
		A = s.nextInt();
		int yoonYear;
		
		if(A%400 ==0) {
			yoonYear = 1;
		}
		else if(A%4==0 && A%100!=0) {
			yoonYear = 1;
		}
		else {
			yoonYear = 0;
		}
		System.out.println(yoonYear);
	}

}
