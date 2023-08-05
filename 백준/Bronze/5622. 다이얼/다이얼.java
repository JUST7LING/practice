
import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		String chars1 = "ABC";
		String chars2 = "DEF";
		String chars3 = "GHI";
		String chars4 = "JKL";
		String chars5 = "MNO";
		String chars6 = "PQRS";
		String chars7 = "TUV";
		String chars8 = "WXYZ";
		
		int sum =0;
		String text = sc.nextLine();
		char[] textChar;
		int[] dial;
		for(int i = 0; i<text.length(); i++) {
			
			textChar = new char[text.length()];
			textChar[i] = text.charAt(i);
			dial = new int[text.length()];
			
			if(chars1.contains(textChar[i]+""))
				dial[i] = 2;
			else if(chars2.contains(textChar[i]+""))
				dial[i] = 3;
			else if(chars3.contains(textChar[i]+""))
				dial[i] = 4;
			else if(chars4.contains(textChar[i]+""))
				dial[i] = 5;
			else if(chars5.contains(textChar[i]+""))
				dial[i] = 6;
			else if(chars6.contains(textChar[i]+""))
				dial[i] = 7;
			else if(chars7.contains(textChar[i]+""))
				dial[i] = 8;
			else if(chars8.contains(textChar[i]+""))
				dial[i] = 9;
			else
				dial[i] = 0;
			
			dial[i]++;
			sum+= dial[i];
			
		}
		
		System.out.println(sum);
		
		
		
	} // main
	
} // Main
