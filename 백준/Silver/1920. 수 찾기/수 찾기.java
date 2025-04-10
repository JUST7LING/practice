import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] TC, wanted;
	
	static void setter() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size;
		size = Integer.parseInt(br.readLine());
		TC = new int[size];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<size; i++) {
			TC[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(TC); // 오름차순으로 나온다.
		
		size = Integer.parseInt(br.readLine());
		wanted = new int[size];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<size; i++) {
			wanted[i] = Integer.parseInt(st.nextToken());
		}
		
	}
	
	static int search(int N) {
		int start = 0;
		int end = TC.length - 1;
		while(start <= end) {
			int middle = (start + end)/2;
			if(TC[middle] == N) return 1;
			if(TC[middle] > N) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		setter();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i<wanted.length; i++) {
			bw.write(search(wanted[i])+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}
