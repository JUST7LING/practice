import java.util.Scanner;

public class Main {
	// 완탐
	static char[][] board;
	static int size;
	static int count = 0;
	
	static class Idx {
		int r, c;
		public Idx(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		set();
		find(0);
		System.out.println(count);
	}
	
	static void set() {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		board = new char[size][size];
		
		sc.nextLine(); // 개행제거
		
		for(int i = 0; i<size; i++) {
			String thisLine = sc.nextLine();
			for(int j = 0; j<size; j++) {
				board[i][j] = thisLine.charAt(j);
			}
		}
	}
	
	static void find(int index) {
		if(index == size*size) return;
		
		// 사방탐색 후 기준점과 다른 요소의 상/하/좌/우 좌표 swap에 전달 
		// -> swap 직후 longest 돌려서 최대길이 찍기
		// -> longest 실행 후 swap 한 번 더 실행(원상태로 돌려놓기)
		
		Idx pin = new Idx(index/size, index%size);
		
		int[] dr = {-1, 1, 0, 0}; // 상하좌우
		int[] dc = {0, 0, -1, 1};
		
		for(int i = 0; i<dr.length; i++) {
			int newR = pin.r+dr[i];
			int newC = pin.c+dc[i];
			if(newR < 0 || newR >= board.length || newC < 0 || newC >= board.length) continue;
			
			if(board[pin.r][pin.c] != board[newR][newC]) {
				Idx newP = new Idx(newR, newC);
				swap(pin, newP);
				longest();
				swap(pin, newP);
			}
			
		}
		
		find(index+1);
		
	}
	
	static void swap(Idx to, Idx from) { // 서로 다른 두 개의 요소를 바꾸기만 하므로 param 순서는 상관 없다
		char temp = board[to.r][to.c];
		board[to.r][to.c] = board[from.r][from.c];
		board[from.r][from.c] = temp;
	}
	
	static void longest() { // 가장 긴 연속하는 같은 알파벳 길이
		if(count == size) return;
        int cnt =  Math.max(maxRow(), maxCol());
        if(cnt > count) count = cnt;
		
	}
	

    // 행 탐색 
    public static int maxRow() {
        int max = 0;
        for (int i = 0; i < board.length; i++) {
            int curr = 1;
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    curr++;
                } else {
                    max = Math.max(max, curr);
                    curr = 1;
                }
            }
            max = Math.max(max, curr);
        }
        return max;
    }
    
    // 열 탐색
    public static int maxCol() {
        int max = 0;
        for (int j = 0; j < board[0].length; j++) {
            int curr = 1;
            for (int i = 1; i < board.length; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    curr++;
                } else {
                    max = Math.max(max, curr);
                    curr = 1;
                }
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
