import java.util.*;

class Solution {
    void valid(Time curr, Time len){
       if(curr.t > len.t) curr.t = len.t;
       if(curr.t < 0) curr.t = 0;
    }

    void skip(Time curr, Time os, Time od){ // 오프닝 건너뛰기 함수
        if(curr.t >= os.t && curr.t < od.t){
            curr.t = od.t;
        }
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Time len = new Time(video_len); // 비디오의 길이
        Time os = new Time(op_start); // 오프닝 시작 시점
        Time od = new Time(op_end); // 오프닝 끝나는 시점
        Time curr = new Time(pos);
        
        for(String s : commands){
            skip(curr, os, od); // 시작점이 오프닝에 해당되는지 체크하고
            curr.calc(s.equals("next"));
            valid(curr, len);
            skip(curr, os, od);
        }
        
        return curr.formatting();
    }
}

class Time {
    int t;
    Time(String str){
        StringTokenizer st = new StringTokenizer(str, ":");
        t = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }
    
    void calc(boolean isAdd){
        if(isAdd){
            t += 10;
            return;
        }
        t -= 10;
    }
    
    String formatting(){
        return String.format("%02d:%02d", t/60, t%60);
    }
}