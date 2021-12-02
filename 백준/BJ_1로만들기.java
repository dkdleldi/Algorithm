package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1로만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N+1];
		num[1] = 0;
		for (int i = 2; i <= N; i++) {
			int num1 = Integer.MAX_VALUE;
			int num2 = Integer.MAX_VALUE;
			int num3 = Integer.MAX_VALUE;
			int min = Integer.MAX_VALUE;
			if(i % 3 == 0) num1 = num[i/3] + 1;
			if(i % 2 == 0) num2 = num[i/2] + 1;
			num3 = num[i-1] + 1;
			min = Math.min(num1, num2);
			min = Math.min(num3, min);
			num[i] = min;
		}
		System.out.println(num[N]);
	}
}
