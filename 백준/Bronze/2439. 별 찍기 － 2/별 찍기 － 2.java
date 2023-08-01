import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
      
      Scanner s = new Scanner(System.in);
        int loop = s.nextInt();
        
        for(int i =1; i<loop+1; i++){
            for(int j= 0; j< loop-i; j++){
                
                System.out.print(" ");
            }
            for(int j = 0; j< i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
    
}