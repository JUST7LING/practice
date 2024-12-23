import java.util.Scanner;

public class Main {
	static int loop, H, nth;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		loop = sc.nextInt();
		for(int i = 0; i<loop; i++) {
			// init
			H = nth = 0;
			// set
			H = sc.nextInt();
			sc.nextInt();
			nth = sc.nextInt();
			
			// 앞에 '0' 붙이는 출력형태 찾아서 추가
			int roomH, roomW;
			roomH = roomW = 0;
			
			int border = nth % H;
			
			if(border == 0) {
				roomH = H;
				roomW = nth/H;
			}else {
				roomH = border;
				roomW = nth/H + 1;
			}
			System.out.printf("%d", roomH);
			System.out.printf("%02d\n", roomW);
		}
	}

}
