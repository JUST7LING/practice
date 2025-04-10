import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	static HashSet<String> hi;
	static String[] logs;
	static int result;
	
	static void setter() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		logs = new String[Integer.parseInt(br.readLine())];
		
		for(int i = 0; i<logs.length; i++) {
			logs[i] = br.readLine();
		}
	}
	
	static void greeting() {
		hi = new HashSet<>();
		for(int i = 0; i<logs.length; i++) {
			if(logs[i].equals("ENTER")) {
				result += hi.size();
				hi.clear();
				continue;
			}
			hi.add(logs[i]);
		}
		result += hi.size();
	}
	
	public static void main(String[] args) throws Exception {
		setter();
		greeting();
		System.out.println(result);
	}
}
