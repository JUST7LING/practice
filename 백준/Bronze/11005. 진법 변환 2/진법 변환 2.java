import java.util.Scanner;

public class Main {
	static char[] chars;
	static int num, N; // num은 10억 이하이기 때문에 int
	
	public static void main(String[] args) {
		set();
		convert();
	}
	
	static void set() {
		chars = new char[26];
		for(int i = 0; i<chars.length; i++) {
			chars[i] = (char) (65+i);
		}
		
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		N = sc.nextInt(); // N진법
		sc.close();
	}
	
	static void convert() { // 변환
		String result = "";
		
		while(N <= num) {
			int line = num%N;
			if(line<10) result += line+"";
			else result += chars[line-10];
			num /= N;
		}
		
		if(num<10) result += num+"";
		else result += chars[num-10];
		
		// 거꾸로 뒤집기 .. . .... ..
		char[] cs = result.toCharArray();
		char[] rs = new char[cs.length];
		for(int i = 0; i<cs.length; i++) {
			rs[i] = cs[cs.length-1-i];
		}
		
		for(int i = 0; i<rs.length; i++) {
			System.out.print(rs[i]);
		}
	}
}
