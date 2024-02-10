import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static int loop = 10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Character, Integer> calPri = new HashMap<>();
		// Calculation Priorities (in stack)

		calPri.put('*', 2);
		calPri.put('/', 2);
		calPri.put('+', 1);
		calPri.put('-', 1); // ASCII 45
		calPri.put('–', 1); // ASCII 8211 ?
		calPri.put('(', 0);

		for (int i = 0; i < loop; i++) {
			sc.nextInt(); // 길이 날리기
			sc.nextLine(); // 버퍼 비우기
			String tc = sc.nextLine();
			char[] tcArr = tc.toCharArray();
			String postfix = ""; // 완성될 후위 표기식
			Stack<Character> operators = new Stack<>(); // 연산자 스택
			for (char c : tcArr) {
				if (c >= '0' && c <= '9') { // 피연산자인 경우
					postfix += c;
				} else { // 피연산자가 아님
					// 1. 일반 사칙연산 연산자인 경우
					// 2. 여는 괄호인 경우
					// 3. 닫는 괄호인 경우
					if (c == '(') {
						operators.push(c);
					} else if (calPri.keySet().contains(c)) {
						// calPri.keySet()에는 '('도 포함되어 있지만,
						// 선행조건에서 걸리기 때문에 이 구역에 내려오지 않음
						if (operators.isEmpty()) {
							operators.push(c);
						} else { // 스택에 누가 있다
							try {
								while (calPri.get(operators.peek()) >= calPri.get(c)) {
									postfix += operators.pop();
								}
							} catch (java.util.EmptyStackException e) {
								// pop을 하고 나서 스택이 비어 있을 때
								// while 조건문의 peek()을 수행하며 생기는 Exception.
								// do nothing.
							}
							operators.push(c); // top보다 높아지면 삽입
						}
					} else if (c == ')') {
						while (operators.peek() != '(') {
							postfix += operators.pop();
						}
						operators.pop(); // 남아있는 여는 괄호를 삭제
					} 
				}
			}
			
			if (!operators.isEmpty()) {
				while (!operators.isEmpty()) {
					if (operators.peek() == '(')
						operators.pop();
					else
						postfix += operators.pop();
				}
			}
		//	System.out.println(postfix);

			// 후위 표기식 만들기
			// 1. 피연산자의 경우 그대로 출력한다.
			// 2. 연산자의 경우
			// 1) stack이 비어 있거나
			// 2) top에 위치한 연산자보다 우선순위가 높을 때까지 pop하고
			// 3) 집어넣는다.
			// 3. 닫는 괄호의 경우 여는 괄호가 나올 때까지 pop() 한다.
			// 4. 스택 안의 여는 괄호는 무시한다
			
			// ============= 
			// 스택 이용한 연산 진행하기 
			char[] toCalc = postfix.toCharArray();
			Stack<Integer> nums = new Stack<>();
			
			for(char c : toCalc) {
				if(c>='0' && c<='9') {
					nums.add(c-48);
				}else { // 연산자
					nums.add(calc(c, nums.pop(), nums.pop()));
				}
			}
			System.out.println("#"+(i+1)+" "+nums.pop());
		}

	}
	
	public static int calc(char op, int num1, int num2) {
		switch(op){
		case '+' : 
			return num1+num2;
		case '-' : 
			return num1-num2;
		case '–' : 
			return num1-num2;
		case '*' :
			return num1*num2;
		case '/' : 
			return num1/num2;
		default:
			return -181818;
		}
	}
}