import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        ArrayList<Integer> result = new ArrayList<>();
        
        HashMap<String, Integer> friends = new HashMap<>();
        for(int i = 0; i<name.length; i++){
            friends.put(name[i], yearning[i]);
        } // HashMap Setting 
        
        for(String[] to : photo){
            int smallResult = 0;
            for(String pho : to) {
                // includes를 쓰지 말고
                try {
                    smallResult += friends.get(pho);
                } catch (Exception e) {
                }
            }
            result.add(smallResult);
        }
        
        int[] answer = new int[photo.length];
        int cursor = 0;
        for(Integer r : result){
            answer[cursor] = r;
            cursor++;
        }
        return answer;
    }
}