

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String grade;
		StringTokenizer st;
		double sum = 0;
		double avr = 0;
		int sumG = 0;
		int[] intGrade = new int[20];
		double[] douGrade = new double[20];
		
		for(int i = 0; i<20; i++) {
			grade = sc.nextLine();
			st = new StringTokenizer(grade, " ");
			
			String gar = st.nextToken();
			
			intGrade[i] = (int) Double.parseDouble(st.nextToken());
			// 등급별 double 변환 필요
			
			switch(st.nextToken()) {
			
			case("A+"):{
				douGrade[i] = 4.5;
				break;
			}
			case("A0"):{
				douGrade[i] = 4.0;
				break;
			}
			case("B+"):{
				douGrade[i] = 3.5;
				break;
			}
			case("B0"):{
				douGrade[i] = 3.0;
				break;
			}
			case("C+"):{
				douGrade[i] = 2.5;
				break;
			}
			case("C0"):{
				douGrade[i] = 2.0;
				break;
			}
			case("D+"):{
				douGrade[i] = 1.5;
				break;
			}
			case("D0"):{
				douGrade[i] = 1.0;
				break;
			}
			case("P"):{
				douGrade[i] = 0.0;
				intGrade[i] = 0;
				break;
			}
			default:
				douGrade[i] = 0; break;
			}
			
			sum += intGrade[i]*douGrade[i];
			sumG+= intGrade[i];
			
			
			
		}
		avr = (double)sum/sumG;
		
		System.out.println(avr);
	


    	
    }// static void main
}// class main