class Solution {
    // 발견하기
    // 1. '몇 개'의 상자를 꺼내야 하는가?를 묻는 문제이지 '몇 번'상자를 '어떤 순서로' 꺼내는 것인가?를 묻지 않았다.
    // 2. 그렇다면 왜 지그재그를 강조했을까? n개의 박스가 w로 '나누어 떨어지지 않을 때' 남는 박스가 어디에 위치해 있느냐에 따라 답이 달라지기 때문이다.
    // 3. 순회 방향에서의 규칙성 : n을 w로 나눈 몫이 홀수라면, n개의 박스가 모두 채워진 마지막 줄은 왼쪽 -> 오른쪽으로 순회한다. 짝수라면 그 반대이다.
    // 3-1. n을 w로 나눈 몫이 h, 나머지를 d라고 하자. h가 짝수이면, d는 h+1행의 0~d-1열까지를 차지한다. 반대로 홀수이면, d는 w-d~w-1열까지를 차지하게 된다.
    // 4. num번 상자를 꺼내야 한다면, num번 상자가 몇 행에 있는지 구해야 한다. 따라서, 3-1번 과정을 num에 대하여 한 번 더 수행한다. 3-1 과정의 'n'이 num이 된다.
    // 5. num / w를 한 값이 numH이고, 나머지가 numD라면, num번 상자가 몇 행(r) 몇 열(c)에 있는지 구할 수 있다. 3번에서 언급된 규칙을 바탕으로, 3-1번의 나머지 상자 배치 열에 c가 포함되는지 확인하여 h-r을 연산한 값이 답이 된다. 
    
    static class Idx {
        int r, c;
        Idx(int r, int c){
            this.r = r;
            this.c = c;
        }
        
        void printOut(){
            System.out.printf("[%d][%d]\n", r, c);
        }
    }
    
    static int h, d; // height of boxes (n/w, n%w)
    
    public int solution(int n, int w, int num) {
        h = n / w;
        d = n % w;
        
        Idx idx = where(num, w);
        
        // 네 가지 케이스가 나올 수 있다.
        // 1. h가 홀수이고 d가 0이 아닌 경우
        // 2. h가 홀수이고 d가 0인 경우
        // 3. h가 짝수이고 d가 0이 아닌 경우
        // 4. h가 짝수이고 d가 0인 경우
        // 이 중에서, d가 0이면 어떤 형태로든 행을 완성하게 되므로 무조건 답이 h - idx.r이다. 
        // 또한, 나올 수 있는 결과의 최솟값도 h - idx.r이다. 따라서
        int result = h - idx.r;
        if(d == 0) return result;
        
        // 이 스코프에서 걸러내는 경우는 idx.c가 나머지 상자에 해당하는 열인 경우다.
        if(h % 2 == 0){
            // h가 짝수라면, d는 정방향 순회한다.
            if(idx.c <= d) return result+1;
        } else {
            // h가 홀수라면, d는 역방향 순회한다.
            if(idx.c >= w-d && idx.c <= w-1) return result+1;
        }
        
        return result;
    }
    
    public Idx where(int num, int w){
        int r = num / w;
        int c = 0;
        if(r % 2 == 0){
            if(num % w == 0){
                r--;
                c = 0;
            } else {
                c = num % w - 1;
            }
        } else {
            if(num % w == 0){
                r--;
                c = w - 1;
            } else {
                c = w - (num % w);
            }
        }
        return new Idx(r, c);
    }
}