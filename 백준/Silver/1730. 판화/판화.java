import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	static int size;
	static char[] orderLine;
	static char[][] board;
	static boolean stop;
	
	static class Move{
		int x, y;
		char c;
		private Move(int y, int x, char c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		set();
		activate();
		draw();
	}
	
	static void set() {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		board = new char[size][size];
		for(char[] ard : board) {
			Arrays.fill(ard, '.');
		}
        
		sc.nextLine(); // 개행 제거, order가 없는 경우도 케어
		String order = sc.nextLine();
		if(order.isEmpty()) {
			stop = true;
			return;
		}
		orderLine = new char[order.length()];
		
		for(int i = 0; i<order.length(); i++) {
			orderLine[i] = order.charAt(i);
		}
		
	}
	
	static void activate() {
		if(stop) return;
		HashMap<Character, Move> controller = new HashMap<Character, Move>();
		controller.put('D', new Move(0, 1, '|'));
		controller.put('U', new Move(0, -1, '|'));
		controller.put('L', new Move(-1, 0, '-'));
		controller.put('R', new Move(1, 0, '-'));
		
		Move curr = new Move(0, 0, '$');
		
		for(char i : orderLine) {
			Move now = controller.get(i);
			if(curr.x+now.x >= size || curr.x+now.x < 0 || curr.y+now.y >= size || curr.y+now.y < 0) continue;
			
			if(board[curr.x][curr.y] != '.' && board[curr.x][curr.y] != now.c) board[curr.x][curr.y] = '+';
			else board[curr.x][curr.y] = now.c;
			
			curr.x = curr.x+now.x;
			curr.y = curr.y+now.y;
			
			if(board[curr.x][curr.y] != '.' && board[curr.x][curr.y] != now.c) board[curr.x][curr.y] = '+';
			else board[curr.x][curr.y] = now.c;
		}
	}
	
	static void draw() {
		for(char[] ard : board) {
			for(char bo : ard) {
				System.out.print(bo);
			}
			System.out.println();
		}
	}

}
