import java.util.Scanner;

public class Main {
     public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      int size, loop, startIndex, endIndex, swapSize, swapScope, swap;
      
      size = s.nextInt();
      int[] baskets = new int[size];
      for(int i = 0; i<baskets.length; i++){
        baskets[i] = i+1; // 바구니에 번호 부여 초기화
        
      }
      
      loop = s.nextInt(); // 몇 번 반복?
      for (int i = 0; i<loop; i++){
        startIndex = s.nextInt()-1;
        endIndex = s.nextInt()-1;
        swapSize = endIndex-startIndex+1; // 범위.
        swapScope = swapSize/2;// 중앙값 선정
        
        for(int j = 0; j < swapScope; j++){
          
          swap = baskets[startIndex+j];
          baskets[startIndex+j] = baskets[endIndex-j];
          baskets[endIndex-j] = swap;
          
          swap = 0; // jnjtjalljze
          
        }
        
        
      }
      for (int j: baskets){
          System.out.print(j+ " ");
        }

    }
}