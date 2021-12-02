package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_설탕배달 {
	static int N, min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int five = N / 5;
		
		min = Integer.MAX_VALUE;
		while(true) {
			int num = N - five*5;
			int sum = 0;			
			if(num % 3 == 0) {
				sum = five + num / 3;
				min = Math.min(sum, min);
			}
			five--;
			if(five < 0) {
				if(min == Integer.MAX_VALUE) min = -1;
				break;
			}
		}
		System.out.println(min);
	}
}
