class Solution {
    /*
        NOTE
        section에 있는 요소를 차례로 검토
        맨 처음 요소는 무조건 시작점이 됨
        * m = 1이면 무조건 n을 리턴함
        * O(n)으로 순회 한 번 하고 끝내는 알고리즘
        예외를 찾는 게 중요할 것 같고(무조건 0 ~ n 방향으로 순회하는 게 모든 예외 케어 가능한지?, 거꾸로 순회했을 때 차수가 줄어드는 경우는 없는지?)   
    */
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int range = section[0] + m - 1;
        for(int i = 0; i<section.length; i++){
            int index = section[i];
            if(index > range) { // no hits
                answer++;
                range = index + m - 1;
            } else continue;
        }
        return answer;
    }
}