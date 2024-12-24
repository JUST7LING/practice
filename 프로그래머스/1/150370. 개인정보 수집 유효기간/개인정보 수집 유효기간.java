import java.util.*;

class Solution {
    static HashMap<String, Integer> termMap;
    
    static class TermDate implements Comparable<TermDate> { 
        // 비교, month연산 가능한 날짜 클래스
        int year, month, date;
        TermDate(String date) {
            String[] splited = date.split("\\.");
            try {
                this.year = Integer.parseInt(splited[0]);
                this.month = Integer.parseInt(splited[1]);
                this.date = Integer.parseInt(splited[2]);
            }catch(Exception e){
                this.year = this.month = this.date = 0;
            }
        }
        
        public TermDate dueDate(int months) { // 유통기한(?) 날짜 리턴
            TermDate result = this;
            if(result.month + months > 12) {
                result.year += (result.month + months) / 12;
                result.month = (result.month + months) % 12;
                if(result.month == 0) {
                	result.year--;
                	result.month = 12;
                }
            } else {
                result.month = result.month + months;
            }
            return result;
        }
        
        @Override
        public int compareTo(TermDate other) {
            if(this.year == other.year){
                if(this.month == other.month){
                    if(this.date == other.date){
                        return 0; // 같은 날짜임
                    }
                    return Integer.compare(this.date, other.date);
                }
                return Integer.compare(this.month, other.month);
            }
            return Integer.compare(this.year, other.year);
        }
    }
    
    public void mapSetter (String[] termsList) { // static HashMap terms를 초기화
        termMap = new HashMap<>();
        for(String term : termsList) {
            String[] splited = term.split(" ");
            try {
                termMap.put(splited[0], Integer.parseInt(splited[1]));
            } catch(Exception e){
                termMap.put(splited[0], 0);
            }
        }
    }
    
    public int[] parser (Object[] array) {
        int[] result = new int[array.length];
        for(int i = 0; i<array.length; i++) {
            try {
                result[i] = (int) array[i];
            } catch(Exception e){
                result[i] = 0;
            }
        }
        return result;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        TermDate td = new TermDate(today);
        mapSetter(terms);
        
        for(int i = 0; i<privacies.length; i++){
            TermDate dueDate = new TermDate(privacies[i].split(" ")[0]).dueDate(termMap.get(privacies[i].split(" ")[1]));
            if(td.compareTo(dueDate) >= 0) answer.add(i+1);
        }
        
        return parser(answer.toArray());
    }
}