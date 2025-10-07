import java.util.*;
import java.text.*;

class Solution {
    static SimpleDateFormat beforeFormat = new SimpleDateFormat("HH:mm:ss.SSS");
    static ArrayList<Log> logs;
    
    static class Log {
        Date before, after;
        Double duration; 
        Log(Date after, Double duration){
            this.after = after;
            this.duration = duration; 
            long afterMilli = after.getTime();
            long durationMilli = (long)(duration * 1000);
            this.before = new Date(afterMilli - durationMilli + 1);
        }
    }
    
    public int solution(String[] lines) throws Exception {
        logs = new ArrayList<>();
        
        for(int i = 0; i<lines.length; i++){
            String[] line = lines[i].split(" ");
            Log log = new Log(beforeFormat.parse(line[1]), Double.parseDouble(line[2].substring(0, line[2].length()-1)));
            logs.add(log);
        }
        
        int answer = 0;
        for(Log l : logs){
            long start = l.after.getTime();
            long end = start + 1000;
            
            int count = 0;
            for(Log l2 : logs){
                if(l2.before.getTime() < end && l2.after.getTime() >= start){
                    count++;
                }
            }
            if(count > answer) answer = count;
        }
        
        return answer;
    }
}