package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_감소하는수_1038 {

	static int N, idx;
	static long[] dec;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dec = new long[N+1];
		idx = 0;
		long div = 10;
		while(true) {
			if(idx == N+1) break;
			if(idx < 10) {
				dec[idx] = idx++;
				continue;
			}
			for (int i = 1; i <= 9; i++) {
				decrease(i, div/10, i*div);
			}
			div *= 10;
			if(div >= Long.parseLong("10000000000")) break;
		}
		System.out.println(N != 0 && dec[N] == 0 ? -1 : dec[N]);
	}
	static void decrease(int num, long div, long sum) {
		if(idx == N+1) return;
		if(div == 0) {
			dec[idx++] = sum;
			return;
		}
		for (int i = 0; i < num; i++) {
			if(i == 0) {
				decrease(i, div/10, sum*div);
				continue;
			}
			decrease(i, div/10, sum+(i*div));
		}
	}
}
