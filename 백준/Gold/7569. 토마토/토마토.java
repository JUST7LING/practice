import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 토마토
	static int[][][] farm;
	static Queue<Idx> Q = new LinkedList<>();
	static int days; // 토마토가 다 익는 데 걸리는 시간
	
	static void setter() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		farm = new int[height][row][col];
		
		for(int i = 0; i<height; i++) {
			for(int j = 0; j<row; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k = 0; k<col; k++) {
					farm[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
	}
	
	static void printOut() { // 디버깅 용도
		for(int[][] layer : farm) {
			System.out.println("=================");
			for(int[] line : layer) {
				System.out.println(Arrays.toString(line));
			}
		}
	}
	
	static class Idx {
		int row, col, height;
		Idx(int h, int r, int c){
			row = r;
			col = c;
			height = h;
		}
	}
	
	static void BFS() {
		// BFS 내부에서는 뭘 해야 할까?
		// 0. Q가 비어있지 않은 동안 실행할 반복문 구조를 만듭니다
		// 1. Q에서 요소를 하나 빼줍니다
		// 2. 그 요소를 가지고 사방탐색을 해줍니다
		// 3. 탐색해서 찾은 친구들을 Q에 넣어 줍니다
		
		// 델타배열 : 위, 아래, 상, 하, 좌, 우
		int[] dh = {-1, 1, 0, 0, 0, 0};
		int[] dr = {0, 0, -1, 1, 0, 0};
		int[] dc = {0, 0, 0, 0, -1, 1};
		
		while(!Q.isEmpty()) {
			Idx curr = Q.poll();
			for(int i = 0; i<dh.length; i++) {
				int nh = curr.height + dh[i];
				int nr = curr.row + dr[i];
				int nc = curr.col + dc[i];
				if(nh>=0 && nh<farm.length &&
					nr>=0 && nr<farm[0].length &&
					nc>=0 && nc<farm[0][0].length ) {
					if(farm[nh][nr][nc] == 0) {
						farm[nh][nr][nc] = farm[curr.height][curr.row][curr.col]+1;
						if(farm[nh][nr][nc] > days) days = farm[nh][nr][nc];
						Q.add(new Idx(nh, nr, nc));
					}
				}
			}
		}
	}
	
	static boolean check() { // 토마토가 다 익었는지 확인해요
		for(int[][] layer : farm) {
			for(int[] line : layer) {
				for(int tomato : line) {
					if(tomato == 0) return false; 
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		setter();
		if(check()) {
			System.out.println(days);
			return; 
		}
		
		for(int i = 0; i<farm.length; i++) {
			for(int j = 0; j<farm[0].length; j++) {
				for(int k = 0; k<farm[0][0].length; k++) {
					// 익은 토마토 찾기
					if(farm[i][j][k] > 0) {
						Q.add(new Idx(i, j, k));
					}
				}
			}
		}
		BFS();
		
		if(!check()) {
			System.out.println("-1");
			return;
		}
		
		System.out.println(days-1);
	}

}
