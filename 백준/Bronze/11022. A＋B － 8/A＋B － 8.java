
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		String temp;
		int size;
		String result;
		int[] num = new int[2];
		int sum = 0;
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			
			temp = br.readLine();
			size = Integer.parseInt(temp);
			
			for(int i =0; i<size; i++) {
				temp = br.readLine();
				num = parsing(temp);
				for(int j : num) {
					sum +=j;
				}
				result = sum+"";
				sum = 0;
				bw.write("Case #"+(i+1)+": "+num[0]+" + "+num[1]+" = "+result+"\n");
				
			}
			
			bw.flush();
			bw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static int[] parsing(String a) {
		int[] num = new int[2];
		String temp;
		StringTokenizer st = new StringTokenizer(a, " ");
		temp = st.nextToken();
		num[0] = Integer.parseInt(temp);
		temp = st.nextToken();
		num[1] = Integer.parseInt(temp);
		return num;
	}

}
