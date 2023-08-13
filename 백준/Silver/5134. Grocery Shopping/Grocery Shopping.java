import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt(); 
		int stockLoop;
		int listLoop;
		
		// for stockLoop
		HashMap<String, Double> price;
		HashMap<String, Integer> quantity;
		double priceVal;
		int quantVal; 
		String name;
		String token;
		String text;
		StringTokenizer st;
		
		// for listLoop
		String temp;
		String toBuy;
		String temq;
		int q;
		StringTokenizer li;
		
		// for print
		double print = 0;
		int set;
		
		sc.nextLine(); // flush
		
		for(int i = 0; i<loop; i++) {
			
			price = new HashMap<>();
			quantity = new HashMap<>();
			stockLoop = sc.nextInt();
			listLoop = sc.nextInt();
			sc.nextLine(); // flush
			
			for(int j = 0; j<stockLoop; j++) {
				text = sc.nextLine();
				st = new StringTokenizer(text, " ");
				token = st.nextToken();
				name = text.substring(token.length()+1);
				quantVal = Integer.parseInt(token);
				
				token = st.nextToken();
				name = name.substring(token.length()+1);
				token = token.substring(1); // remove '$'
				priceVal = Double.parseDouble(token);
				
				token = st.nextToken();
				name = name.substring(token.length()+1);
				token = token.substring(1);
				priceVal -= Double.parseDouble(token);
				
				name = name.toLowerCase();
				price.put(name, priceVal);
				quantity.put(name, quantVal);
				
			}
			
			for(int j = 0; j<listLoop; j++) {
				temp = sc.nextLine();
				li = new StringTokenizer(temp, " ");
				temq = li.nextToken();
				q = Integer.parseInt(temq);
				toBuy = temp.substring(temq.length()+1).toLowerCase();
				
				if(price.containsKey(toBuy)) {
					
					if(q<quantity.get(toBuy)) {
						print+=price.get(toBuy)*q;
					}else{
						print += price.get(toBuy)*quantity.get(toBuy);
					}
					
				}else {
					continue;
				}
				
			}
			
			set =i+1;
			System.out.println("Data Set "+set+":");
			System.out.println("$"+String.format("%.2f", print));
			System.out.println();
			print = 0;
		}
    	
    }// static void main
}// class main