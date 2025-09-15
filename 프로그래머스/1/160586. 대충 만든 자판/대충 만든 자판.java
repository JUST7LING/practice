import java.util.*;

class Solution {
    static class Keys {
        char key;
        int index;
        Keys(char key, int index){
            this.key = key;
            this.index = index;
        }
    }
    public static HashMap<Character, Keys> findKey;
    public int[] solution(String[] keymap, String[] targets) {
        findKey = new HashMap<>();
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
                Keys thisKey = findKey.get(thisChar);
                if(thisKey == null) { // 아직 등록되지 않은 문자
                    findKey.put(thisChar, new Keys(thisChar, j));
                } else { // 이미 등록된 문자
                    if(thisKey.index > j) { // 새롭게 등록할 필요가 있다.
                        findKey.put(thisChar, new Keys(thisChar, j)); // 갱신
                    }
                }
            }
        }
    }
    
    static int calc(String line){
        int result = 0;
        for(int i = 0; i<line.length(); i++){
            Keys thisKey = findKey.get(line.charAt(i));
            if(thisKey == null) return -1;
            result += thisKey.index + 1;
        }
        return result;
    }
    
    
}