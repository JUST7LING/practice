import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Main {
	static class Part implements Comparable<Part>{
		char body;
		int time;
		
		public Part(char body) {
			
			this.body = body >= 'a' ? (char) ((int) body - 32) : body;
			this.time = 1;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Part) {
				Part p = (Part) obj;
				if(p.body == this.body || (int) p.body+32 == this.body || (int) p.body-32 == this.body) return true;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return Objects.hash(body);
		}
		
		@Override
		public int compareTo(Part p) {
			return Integer.compare(p.time, this.time);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] line = sc.nextLine().toCharArray();
		
		ArrayList<Part> parts = new ArrayList<>();
		for(int i = 0; i<line.length; i++) {
			int idx = parts.indexOf(new Part(line[i]));
			if(idx<0) parts.add(new Part(line[i]));
			else {
				parts.get(idx).time++;
			}
		}
		
		Collections.sort(parts);
		if(parts.size() > 1 && parts.get(0).time == parts.get(1).time) System.out.println("?");
		else System.out.println(parts.get(0).body);
		
	}
	
}
