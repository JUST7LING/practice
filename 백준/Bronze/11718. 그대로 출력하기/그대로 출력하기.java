
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
     public static void main(String[] args)
    {
      	 Scanner s = new Scanner(System.in);
      	 String in;
      	 StringTokenizer tk;
      	 /* */
      	 while(s.hasNextLine()) { // 명목상 .... 왜 붙이는지 모르겠음
      		 try {
      		 in = s.nextLine();
      		 tk = new StringTokenizer(in);
      		 if(tk.nextToken().isEmpty()) {// 여기서 예외 발생될 예정
      			 
      			 break; // 회수되지 않는 떡밥 뿌리기
      		 }
      		 System.out.println(in);
      			
      		 }catch(NoSuchElementException e) {
      			 break;
      		 }
      		
      	 }
      	
      	 /*
      	 while(s.hasNextLine()) {
      	 String tem = s.nextLine();
      	 tk = new StringTokenizer(tem);
      	 while(tk.hasMoreTokens()) {
      		 
      		 System.out.println(tk.nextToken());
      		 try {
      		 if(tk.nextToken()==null)
      			 break;}
      		 catch(Exception e) {
      			 break;
      		 }
      	 }}
      	 */
    }// static void main
}// class main