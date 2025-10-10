class Solution {
   public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliRemain = 0; // 남은 배달 상자 수
        int pickRemain = 0; // 남은 수거 상자 수

        for (int i = n - 1; i >= 0; i--) {
            deliRemain += deliveries[i];
            pickRemain += pickups[i];

            // 이 위치까지 몇 번 왕복해야 하는지 계산
            while (deliRemain > 0 || pickRemain > 0) {
                deliRemain -= cap;
                pickRemain -= cap;
                answer += (i + 1) * 2L;
            }
        }

        return answer;
    }

}