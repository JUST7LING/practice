import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int A;
		Scanner s = new Scanner(System.in);
		A = s.nextInt();
		char grade;
		switch(A/10) {
		case 10: grade = 'A'; break;
		case 9: grade = 'A'; break;
		case 8: grade = 'B'; break;
		case 7: grade = 'C'; break;
		case 6: grade = 'D'; break;
		default: grade = 'F'; break;
		}
		System.out.println(grade);
	}
}