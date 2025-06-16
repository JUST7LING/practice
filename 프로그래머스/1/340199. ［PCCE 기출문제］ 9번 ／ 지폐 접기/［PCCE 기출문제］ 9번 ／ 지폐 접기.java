class Solution {
    static int[] wallet;
    
    public void fold(int[] bill){
        if(bill[0] > bill[1]) bill[0] /= 2;
        else bill[1] /= 2;
    }
    
    public boolean check(int[] bill){
        if(wallet[0] >= bill[0] && wallet[1] >= bill[1]) return true;
        if(wallet[0] >= bill[1] && wallet[1] >= bill[0]) return true;
        return false;
    }
    
    public int solution(int[] wallet, int[] bill) {
        this.wallet = wallet;
        int answer = 0;
        
        while(!check(bill)){
            fold(bill);
            answer++;
        }
        return answer;
    }
}