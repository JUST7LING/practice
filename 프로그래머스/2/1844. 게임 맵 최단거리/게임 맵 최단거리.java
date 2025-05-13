import java.util.*;

class Solution {
    // 최단거리를 구하는 BFS
    // 칸에 도착할 때마다 그 칸까지의 거리를 업데이트해둔다
    static int[][] maps, visited;
    static Queue<Idx> Q;
    
    static class Idx { // 좌표값 class
        int r, c;
        Idx(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    public void setter(int[][] maps){
        this.maps = maps;
        visited = new int[maps.length][maps[0].length];
        Q = new LinkedList<>();
    }
    
    public int solution(int[][] maps) {
        setter(maps);   
        visited[0][0] = 1;
        Q.add(new Idx(0,0)); // 시작점 지정
        BFS();
        int result = visited[maps.length-1][maps[0].length-1];
        if(result > 0) return result;
        return -1;
    }
    
    public void BFS(){
        // 상하좌우 델타 배열
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while(!Q.isEmpty()){
            // BFS logic
            Idx curr = Q.poll();
            for(int i = 0; i<4; i++){ // 델타배열 탐색
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                if(nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[0].length) continue;
                if(maps[nr][nc] == 1 && visited[nr][nc] == 0) {
                    // 1. visited에 방문 표시 먼저 하고
                    visited[nr][nc] = visited[curr.r][curr.c] + 1;
                    // 2. Q에 넣기
                    Q.add(new Idx(nr, nc));
                }
            }
        }
    }
}