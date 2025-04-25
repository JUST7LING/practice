class Solution {
    static int[] diffs, times;
    static long limit;
    
    public int solution(int[] diffs, int[] times, long limit) {
        // 할당
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        // 이분탐색 포인터 정하기
        int start, end, mid;
        end = 0;
        start = 1;
        int result = Integer.MAX_VALUE;
        
        for(int i : diffs){
            if(i>end) end = i;
        } // 초기 end값 세팅(탐색할 level의 상한선)
        
        mid = 1; // 임의의 0이 아닌 값으로 초기화
        while(start <= end){
            mid = (start + end) / 2;
            if(solving(mid)) {
                // 최솟값을 찾는 것이므로 탐색 범위를 아래로 내려야 한다.
                if(result > mid) result = mid;
                end = mid - 1;
                continue;
            }
            
            start = mid + 1;
        }
        
        return result;
    }
    
    public boolean solving(int level){
        // 제한 시간 내 가능 여부를 리턴한다.
        long spend = 0L;
        for(int i = 0; i<diffs.length; i++){
            if(level >= diffs[i]) {
                spend += times[i];
                continue;
            }
            
            // diffs[0] = 1임이 보장되어 있고, level은 양의 정수여야 하므로
            // i == 0에서의 시행은 무조건 위 if condition을 만족한다.
            // 따라서, 아래 diffs[i-1] 연산에서 i == 0인 경우(ArrayOutOfBoundsException)에 대한 케어는 진행하지 않는다.
            // 이를 응용하여, 반복문을 i = 1부터 시작해도 좋다.
            
            spend += (times[i] + times[i-1]) * (diffs[i] - level);
            spend += times[i];
            if(limit < spend) return false; // TC 3번은 왜 여기서 못 걸러내나?
        }
        
        if(limit < spend) return false;   
       // System.out.printf("Whoo! %d\n", spend); // TC 3번은 위 조건문이 없으면 1724가 나온다!
        return true;
    }
}