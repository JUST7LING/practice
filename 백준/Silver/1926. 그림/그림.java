import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] canvas;
	static int pictures, maxSize;
	static Queue<Integer[]> Q = new LinkedList<>();
	
	
	static void setter() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		canvas = new int[row][col];
		for(int i = 0; i<row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<col; j++) {
				canvas[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
	
	static int BFS() {
		// 상, 하, 좌, 우
		int size = 1;
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		while(!Q.isEmpty()) {
			Integer[] curr = Q.poll(); // 꺼내고
			canvas[curr[0]][curr[1]] = 0; // 방문체크 하고
			for(int i = 0; i<4; i++) {
				if(curr[0]+dr[i]>=0 && curr[0]+dr[i]<canvas.length) { // 행 이동 체크
					if(curr[1]+dc[i]>=0 && curr[1]+dc[i]<canvas[0].length) { // 열 이동 체크
						if(canvas[curr[0]+dr[i]][curr[1]+dc[i]] == 1) {
							canvas[curr[0]+dr[i]][curr[1]+dc[i]] = 0;
							size++;
							Q.add(new Integer[] {curr[0]+dr[i], curr[1]+dc[i]});
						}
					}
				}
			}
		}
		return size;
	}
	
	public static void main(String[] args) throws IOException {
		setter();
		for(int i = 0; i<canvas.length; i++) {
			for(int j = 0; j<canvas[0].length; j++) {
				if(canvas[i][j] == 1) { // 새로운 그림을 찾았다!
					Q.add(new Integer[] {i, j});
					pictures++;
					int size = BFS();
					if(size>maxSize) maxSize = size;
				}
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(pictures + "\n"); // 그림의 개수 출력
		bw.write(maxSize + "\n");  // 가장 큰 그림의 크기 출력
		bw.flush();
		bw.close();
	}
}
