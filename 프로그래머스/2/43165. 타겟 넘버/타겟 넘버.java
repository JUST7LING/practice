class Solution {
    static int answer, target;
    static int[] numbers;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        recursive(0, 0);
        return answer;
    }
    
    //recursive 
    // 종료 조건 -> 배열의 숫자만큼만 연산 -> 포인터가 배열을 벗어나면 return
    static void recursive(int index, int calc){ // 지금 탐색할 배열의 인덱스 / 지금까지의 계산값
        if(index == numbers.length) {
            if(calc == target) answer++;
            return;
        }
       
        recursive(index+1, calc + numbers[index]);
        recursive(index+1, calc - numbers[index]);
    }
        
}