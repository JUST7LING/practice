
import java.util.Scanner;

public class Main {
	static int found = 0; // 크로아티아 알파벳을 찾은 횟수이다.
	static int ordinary = 0; // 일반 알파벳으로 판별한 횟수이다.
     public static void main(String[] args)
    {
      	 Scanner s = new Scanner(System.in);
      	 
      	 String test = s.nextLine();
      	 
      	 /*
      	  	크로아티아 알파벳에 사용된 문자의 종류는
      	  	c, =, -, d, z, l, j, n, s의 아홉 개이고
      	  	각 (int) char 값은
      	  	99, 61, 45, 100, 122, 108, 106, 110, 115이다.
      	  	
      	  	첫째로, 입력된 문자열을 검토하면서
      	  	c, d, l, n, s, z가 있는지 살펴볼 것이다.
      	  	이것은 switch로 작성한다.
      	  	아무 것도 해당되지 않으면 콘솔은 단순히 문자열의 길이만을 반환한다.
      	  	
      	  	둘째로, c, d, l, n, s, z가 있는 경우
      	  	다음 글자를 검토하여 크로아티아 알파벳에 해당하는지 따져야 한다.
      	  	c와 d로 시작하는 크로아티아 알파벳은 두 개이므로
      	  	switch 안에서 두 가지 경우로 다시 나뉘고,
      	  	dz=의 경우 세 글자이므로 반복을 한 번 더 수행해야 한다.
      	  	
      	  	이 과정에서 탈락하면 c, d, l, n, s, z가 포함되어 있더라도
      	  	일반 알파벳으로 취급되어 length가 반환된다.
      	  	
      	  */
      	 int comp = 0;
      	 int dzbit = 0;
      	 
      	 for(int i =0 ; i<test.length(); i++) {
      		 
      		 if(i==test.length()-1) {
      			 ordinary++;
      			 break;
      			 /*
      			  제시문이 한 글자인 경우와
      			  검토가 진행되는 c, d, l, n, s, z가
      			  마지막 글자에 있을 경우
      			  Exception 방지를 위해 삽입된 구문임.
      			  이 부분은 마지막 글자일 때(i가 마지막 인덱스일 때)에만 수행된다.
      			  어차피 마지막 글자이기 때문에 길이가 2 이상인 크로아티아 알파벳이 나올 수 없다.
      			  즉 ordinary++을 수행하고 빠져나온다.
      			 */
      			 
      		 }
      		 comp = (int)test.charAt(i);
      		 // 변수 comp에는 입력된 구문의 문자가 인덱스 순서에 따라 차례로 한 자씩 담긴다.
      		 // ASCII value이다.
      		 
      		 switch(comp) {
      		 case(99):{ 
      			 if((int)test.charAt(i+1)==61) {
      				 found++;
         			 
      				 i += 1;
      			} 
      			 else if((int)test.charAt(i+1)==45) {
      				 found++;
          			i += 1;
      				 }
      			 else {
      			 	ordinary++;
      			 	// c이긴 하지만 뒤쪽 문자가 -나 =가 아니라면 크로아티아 알파벳이 아니다.
      			 	// 따라서 c는 ordinary로 판정된다.
      			 	}
      			 break;
      		 }//c
      		 case(100):{
      			if((int)test.charAt(i+1)==45) {
     				 found++;
         			 i = i+1;
     				 }
     			 else if((int)test.charAt(i+1)==122) { // d 뒤에 이어지는 알파벳이 z일 경우
     				 try {
     				 if((int)test.charAt(i+2)==61) { // 여기다 ㅅㅂ 
     					 found++;
     					 dzbit++;
     				//	System.out.println("입력된 문자열 길이는 "+test.length());
     					
     						i = i+2;
             			//	System.out.println("current i is "+i);
             				
     					 }
     				
     				 else {
     					ordinary = ordinary+1;
     					// 예상 검토점
     				 }
     			 } catch(Exception e) {
 					 ordinary++;
 				 }
     				 
     			 } // else if
     			 else {
      				ordinary++;
      				}
      			 break;
      		 }//d
      		 case(122):{
      			 if((int)test.charAt(i+1)==61) {
      				 found++;
          			 i += 1;
      				 }
      			 else {
      				ordinary++;
      			 }
      			 break;
      		 }//z
      		 case(108):{
      			 if((int)test.charAt(i+1)==106) {
      				 found++;
          			i += 1;
      				 }
      			 else {
      				ordinary++;
      			 }
      			 break;
      		 }//l
      		 case(110):{
      			 if((int)test.charAt(i+1)==106) {
      				 found++;
          			 i += 1;
      				 }
      			 else {
      				ordinary++;
      			 }
      			 break;
      		 }//n
      		 case(115):{
      			 if((int)test.charAt(i+1)==61) {
      				 found++;
         			  i += 1;
      				}
      			 else {
      				ordinary++;
      			 }
      			 break;
      		 }//s
      		 
      		 default:{
      			 ordinary++;
      			 break;
      		 }
      		 
      		 }// switch
      		 
      		
      		 
      	 }//for
      	 System.out.println(found+ordinary);
      	 
    }
}