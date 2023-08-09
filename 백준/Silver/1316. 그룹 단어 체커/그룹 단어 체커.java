
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
     public static void main(String[] args)
    {
      	Scanner s = new Scanner(System.in);
      	
      	int loop = s.nextInt(); // 반복 횟수
      	int wordBit = 0; //그룹 단어인가 아닌가?
      	// 그룹 단어가 아니면 1
      	int count = 0;
      	int newCharBit = 0;
      	
      	/*
      	  그룹 단어 체킹에서 유의하여 걸러내야 할 것은
      	  '이전에 등장한 적이 있지만 연속되지 않고 등장한 글자'
      	  의 유무이다.
      	*/
      	String word;
      	ArrayList<Character> search = new ArrayList<>();
      	s.nextLine();
      	for(int i = 0; i<loop; i++) {
      		word = s.nextLine();
      		/**/
      		for(int j = 0; j<word.length(); j++) {
      		//	if(j == 0){
      		//		search.add(word.charAt(j));
      		//	} // 첫 글자는 무조건 리스트에 들어감
      			
      			if(!search.contains(word.charAt(j))) {
      				search.add(word.charAt(j));
      				newCharBit++;
      				
      				if(newCharBit==word.length()) {
      					count++;
      				}
      				else if(j+1==word.length()&&wordBit==0){
      					count++;
      				}
      				
      			}
      			else {
      				if(word.charAt(j-1)!=word.charAt(j)) {
      				
      					wordBit = 1;
      				}
      				else if(newCharBit==1&&j+1==word.length()) {
      					count++;
      				}
//      				else if(j-word.indexOf(word.charAt(j))>1) {
//      					wordBit = 1;
//      				}
      				
      				else {
      					if(j+1==word.length() && wordBit==0) {
      					count++;
      					}
      				}
      			}
      			
      		}
      		
      		search.clear();
      		newCharBit=0;
      		wordBit=0;
      		
      	}
      	System.out.println(count);
      	
    	
    }// static void main
}// class main