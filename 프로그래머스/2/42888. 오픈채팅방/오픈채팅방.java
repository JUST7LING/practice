import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> nicknames = new HashMap<>();
        
        String[][] recordArr = new String[record.length][3];
        for(int i = 0; i<record.length; i++){
            String[] line = record[i].split(" ");
            for(int j = 0; j<line.length; j++){
                recordArr[i][j] = line[j];
            }
        }
        
        for(int i = 0; i<record.length; i++){
            switch(recordArr[i][0]){
                case "Leave" : continue;
                default :
                    nicknames.put(recordArr[i][1], recordArr[i][2]);
            }
        }
        
        ArrayList<String> results = new ArrayList<>();
        for(int i = 0; i<record.length; i++){
            String name = nicknames.get(recordArr[i][1]);
            switch(recordArr[i][0]){
                case "Enter" : 
                    results.add(name+"님이 들어왔습니다.");
                    break;
                case "Leave" : 
                    results.add(name+"님이 나갔습니다.");
                    break;
            }
        }
        
        Object[] before = results.toArray();
        String[] after = new String[before.length];
        for(int i = 0; i<before.length; i++){
            after[i] = (String) before[i];
        }
        return after;
    }
}