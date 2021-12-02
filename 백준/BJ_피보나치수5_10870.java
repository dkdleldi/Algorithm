package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_피보나치수5_10870 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = fibonacci(n);
		System.out.println(ans);
	}
	static int fibonacci(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
}
