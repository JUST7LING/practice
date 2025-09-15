import java.util.*;

class Solution {
    static public int[] findKey;

    public int[] solution(String[] keymap, String[] targets) {
        findKey = new int[91];
        setKeys(keymap); // findKey setting
        int[] answer = new int[targets.length];
        for(int i = 0; i<targets.length; i++){
            answer[i] = calc(targets[i]);
        }
        return answer;
    }
    
    static void setKeys(String[] keymap) {
        for(int i = 0; i<keymap.length; i++){
            for(int j = 0; j<keymap[i].length(); j++){
                char thisChar = keymap[i].charAt(j);
                if(findKey[thisChar] == 0) { // 아직 등록되지 않은 문자
                    findKey[thisChar] = j + 1;
                } else { // 이미 등록된 문자
                    if(findKey[thisChar] > j) { // 새롭게 등록할 필요가 있다.
                        findKey[thisChar] = j + 1; // 갱신
                    }
                }
            }
        }
    }
    
    static int calc(String line){
        int result = 0;
        for(int i = 0; i<line.length(); i++){
            char thisChar = line.charAt(i);
            if(findKey[thisChar] == 0) return -1;
            result += findKey[thisChar];
        }
        return result;
    }
    
}