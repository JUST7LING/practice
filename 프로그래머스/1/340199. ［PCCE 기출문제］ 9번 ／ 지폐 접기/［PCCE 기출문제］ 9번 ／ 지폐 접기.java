class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(needFold(wallet, bill)){
            answer++;
            if(bill[0] > bill[1]) bill[0] /= 2;
            else bill[1] /= 2;
        }
        return answer;
    }
    
    boolean needFold(int[] wallet, int[] bill) { // 접어야 한다 = true, 접지 않아도 된다 = false
        int walletLongIndex = wallet[0] > wallet[1] ? 0 : 1;
        int billLongIndex = bill[0] > bill[1] ? 0 : 1;
        int walletShortIndex = walletLongIndex == 1 ? 0 : 1;
        int billShortIndex = billLongIndex == 1 ? 0 : 1;
        
        if(wallet[walletLongIndex] >= bill[billLongIndex] && wallet[walletShortIndex] >= bill[billShortIndex]) return false;
        return true;
    }
}