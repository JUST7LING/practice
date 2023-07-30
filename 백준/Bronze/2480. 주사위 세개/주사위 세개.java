
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int x, y, z;
		Scanner s = new Scanner(System.in);
		
		x = s.nextInt();
		y = s.nextInt();
		z = s.nextInt();
		
		int sameCount = 0;
		int reward = 0;
		int noon =0;;
		
		if(x==y) {
			sameCount++;
			noon = x;
		}
		if(y==z) {
			sameCount++;
			noon = y;
		}
		if(x==z) {
			sameCount++;
			noon = z;
		}
		
		
		
		switch(sameCount) {
		
		case 0:{
			int[] noons  = new int[3];
			noons[0] = x;
			noons[1] = y;
			noons[2] = z;
			
			reward = 100*compare(noons);
			break;
		}
		
		case 1: {
			reward = 1000+noon*100;
			break;
		}
		
		case 3: {
			reward = 10000+noon*1000;
			break;
		}
		
		// x, y, z를 삼각형의 꼭짓점으로 생각했을 때,
		// sameCount는 일치하는 값끼리 모두 이은 선이라고 생각하면
		// 왜 case 2는 없고 1과 뿐인지 이해 가능
		
		// 세 수가 모두 같다면 선분도 세 개 생기지만
		// 두 수만 같고 하나는 다르다면
		// 선분은 두 개가 아닌 하나만 생길 것이다. 
		
		} // switch
		
		System.out.println(reward);
		
		
	}
	public static int compare(int[] noons) {
		int supernoon = noons[0];
		
		for(int i = 1; i<noons.length; i++) {
			if(noons[i]>supernoon) {
				supernoon = noons[i];
			}
		}
		
		return supernoon;
	}
}