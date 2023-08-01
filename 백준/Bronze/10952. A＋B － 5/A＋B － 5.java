import java.util.*;

public class Main {
     public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      int a, b, sum;
      
        while(true){
          
             a = s.nextInt();
             b = s.nextInt();
             
             if(a == 0 || b == 0){
                 break;
             }
             sum = a+b;
             System.out.println(sum);

        }

    }
}