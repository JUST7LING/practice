import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int shortest = Integer.MAX_VALUE;
	static Queue<Idx> Q = new LinkedList<>();
	
	static void setter() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		map = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		
		for(int i = 0; i<map.length; i++) {
			String line = br.readLine();
			for(int j = 0; j<map[0].length; j++) {
				map[i][j] = line.charAt(j)-48;
			}
		}
		br.close();
	}
	
	static class Idx {
		int row, col;
		Idx(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	static void BFS() {
		// 상, 하, 좌, 우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		while(!Q.isEmpty()) {
			Idx curr = Q.poll();
			if(curr.row == map.length-1 && curr.col == map[0].length-1) break;
			for(int i = 0; i<dr.length; i++) {
				if(curr.row + dr[i] >= 0 && curr.row + dr[i] < map.length) {
					if(curr.col + dc[i] >= 0 && curr.col + dc[i] < map[0].length) {
						if(map[curr.row+dr[i]][curr.col+dc[i]] == 1) {
							Q.add(new Idx(curr.row+dr[i], curr.col+dc[i]));
							map[curr.row+dr[i]][curr.col+dc[i]] = map[curr.row][curr.col]+1;
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		setter();
		Q.add(new Idx(0, 0)); // 시작점
		BFS();
		if(shortest > map[map.length-1][map[0].length-1]) shortest = map[map.length-1][map[0].length-1];
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(shortest+"\n");
		bw.flush();
		bw.close();
	}

}
