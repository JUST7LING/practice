import java.util.*;

class Solution {

    static HashSet<Integer> checker;
    static int[] line;
    static PriorityQueue<Element> queue; 
    static class Element implements Comparable{
        int size;
        ArrayList<Integer> list;
        Element(){
            list = new ArrayList<>();
        }
        void add(String i){
            list.add(Integer.parseInt(i));
            size++;
        }
        int[] spit(){
            int[] result = new int[size];
            Object[] temp = list.toArray();
            for(int i = 0; i<temp.length; i++){
                result[i] = (int) temp[i];
            }
            
            return result;
        }
        @Override
        public int compareTo(Object o){
            Element newElement = (Element) o;
            return Integer.compare(this.size, newElement.size);
        }
    }
    
    public int[] solution(String s) {
        checker = new HashSet<>();
        queue = new PriorityQueue<>();
        setter(s);
        listUp();
        
        return line;
    }
    
    static void setter(String s){
        Element element = new Element();
        String chunk = "";
        for(int i = 1; i<s.length()-1; i++){ // 마지막 중괄호 두 개 }}를 빼줍니다
            char thisChar = s.charAt(i);
            switch(thisChar) {
                case '{' : 
                    element = new Element(); 
                    break;// 여는 괄호가 나오면 새 요소를 만들고
                case '}' : 
                    queue.add(element); 
                    break; // 닫는 괄호가 나오면 요소를 큐에 집어넣습니다.
                case ',' :
                    if(!chunk.isBlank()) element.add(chunk);
                    chunk = "";
                    break; // ,가 나오면 숫자 덩어리를 현재 요소에 집어넣습니다.
                default : 
                    chunk += thisChar;
            }
        }
        element.add(chunk);
    }
    
    static void listUp(){
        line = new int[queue.size()];
        int index = 0;
        while(!queue.isEmpty()){
            Element e = queue.poll();
            int[] spitted = e.spit();
            for(int i : spitted){
                if(checker.contains(i)) continue;
                else { // 새로운 요소를 찾아 추가
                    checker.add(i);
                    line[index] = i;
                    index++;
                }
            }
        }
    }
}