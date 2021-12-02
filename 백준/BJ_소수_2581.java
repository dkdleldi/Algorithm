package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_소수_2581 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = M; i <= N; i++) {
			boolean prime = true;
			if(i == 1) continue;
			for (int j = 2; j < i; j++) {
				if(i % j == 0) {
					prime = false;
					break;
				}
			}
			if(prime) {
				if(min > i) min = i;
				sum += i;
			}			
		}
		if(sum == 0) System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
