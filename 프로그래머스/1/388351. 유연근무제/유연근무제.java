import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int result = 0;
        nextMember: for(int i = 0; i<schedules.length; i++){
            int due = schedules[i]/100*60 + schedules[i]%100 + 10;
            
            nextDay: for(int j = 0; j<timelogs[i].length; j++){
                if((startday+j) % 7 == 0 || (startday+j) % 7 == 6) continue nextDay;
                int came = timelogs[i][j]/100*60 + timelogs[i][j]%100;
                if(due < came) continue nextMember;
            }
            result++;
        }
        return result;
    }
}

