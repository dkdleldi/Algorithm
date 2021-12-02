package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_수들의합_1789 {

	static long S;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Long.parseLong(br.readLine());
		long sum = 0;
		int i = 0;
		while(true) {
			if(sum >= S) break;
			sum += ++i;
		}
		if(sum > S) i--;
		System.out.println(i);
	}
}
