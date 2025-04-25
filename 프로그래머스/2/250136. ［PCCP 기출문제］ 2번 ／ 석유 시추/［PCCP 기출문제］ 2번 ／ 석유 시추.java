import java.util.*;

class Solution {
    // 발전시키기
    // 1. 발견할 수 있는 모든 석유 덩어리에 대한 정보를 저장해 보자. 
    // 2. 열마다 지금까지 방문한 덩어리 정보를 저장해 보자.
    // 3. 해당 열에서 이미 방문한 석유 덩어리라면, continue
    
    static class Idx {
        int r, c;
        Idx (int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    static HashMap<Integer, Integer> oilPots;
    static HashSet<Integer> found;
    static Queue<Idx> Q;
    static int[][] land, newLand; // 초기 BFS 시 land를, 열 단위 탐색 시 newLand를 사용하게 된다.
    static int result;
    
    // 상하좌우 델타배열
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        init(land);
        for(int i = 0; i<land[0].length; i++){
            int thisResult = lineSearch(i);
            if(thisResult > result) result = thisResult;
        }
        return result;
    }
    
    public int lineSearch(int colNum){
        found = new HashSet<>(); // 탐색 중인 열에서 찾은 구덩이 ID를 저장하는 Set
        int result = 0;
        for(int i = 0; i<newLand.length; i++){
            if(newLand[i][colNum] > 0){
                if(!found.contains(newLand[i][colNum])) {
                    found.add(newLand[i][colNum]);
                    result += oilPots.get(newLand[i][colNum]);
                }
            }
        }
        
        return result;
    }
    
    public void init(int[][] land){ // 변수 초기화, 초기 BFS를 수행한다.
        Q = new LinkedList<>();
        this.land = land;
        newLand = new int[land.length][land[0].length];
        oilPots = new HashMap<>();
        
        for(int i = 0; i<land.length; i++){
            for(int j = 0; j<land[0].length; j++){
                if(land[i][j] == 1 && newLand[i][j] == 0){
                    newLand[i][j] = oilPots.size()+1; // 방문체크 겸 덩어리 ID 부여
                    Q.add(new Idx(i, j));
                    oilPots.put(newLand[i][j], initBFS());
                }
            }
        }
    }
    
    public int initBFS(){ // 덩어리의 크기를 반환함
        int result = 1; // 초기 위치가 포함된 덩어리 크기
        while(!Q.isEmpty()){
            Idx curr = Q.poll();
            for(int i = 0; i<4; i++){
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];
                if(nr >= 0 && nr < newLand.length && 
                   nc >= 0 && nc < newLand[0].length){
                    if(land[nr][nc] == 1 && newLand[nr][nc] == 0){
                        newLand[nr][nc] = newLand[curr.r][curr.c];
                        result++;
                        Q.add(new Idx(nr, nc));
                    }
                }
            }
        }
        
        return result;
    }
    

}