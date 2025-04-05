import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] canvas;
	static int pictures, maxSize;
	static Queue<Idx> Q = new LinkedList<>();
	
	static class Idx{
		int row, col;
		Idx(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static void setter() {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		canvas = new int[row][col];
		for(int i = 0; i<row*col; i++) {
			canvas[i/col][i%col] = sc.nextInt();
		}
	}
	
	static void printOut() {
		for(int[] rows : canvas) {
			System.out.println(Arrays.toString(rows));
		}
	}
	
	static int BFS() {
		// 상, 하, 좌, 우
		int size = 1;
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		while(!Q.isEmpty()) {
			Idx curr = Q.poll(); // 꺼내고
			canvas[curr.row][curr.col] = 0; // 방문체크 하고
			for(int i = 0; i<4; i++) {
				if(curr.row+dr[i]>=0 && curr.row+dr[i]<canvas.length) { // 행 이동 체크
					if(curr.col+dc[i]>=0 && curr.col+dc[i]<canvas[0].length) { // 열 이동 체크
						if(canvas[curr.row+dr[i]][curr.col+dc[i]] == 1) {
							canvas[curr.row+dr[i]][curr.col+dc[i]] = 0;
							size++;
							Q.add(new Idx(curr.row+dr[i], curr.col+dc[i]));
						}
					}
				}
			}
		}
		return size;
	}
	
	public static void main(String[] args) {
		setter();
		for(int i = 0; i<canvas.length; i++) {
			for(int j = 0; j<canvas[0].length; j++) {
				if(canvas[i][j] == 1) { // 새로운 그림을 찾았다!
					Q.add(new Idx(i, j));
					pictures++;
					int size = BFS();
					if(size>maxSize) maxSize = size;
				}
			}
		}
		
		System.out.printf("%d\n%d", pictures, maxSize);
	}
}
