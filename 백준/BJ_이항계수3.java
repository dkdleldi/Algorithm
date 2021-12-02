package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_이항계수3 {

	static int N, K;
	static long MOD = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		long top = fac(N);
		long bottom = fac(K) * fac(N-K) % MOD;
		System.out.println(top * pow(bottom, MOD-2) % MOD);
	}
	
	private static long pow(long bottom, long l) {
		long num = 1;
		while(l > 0) {
			if(l % 2 == 1) {
				num *= bottom;
				num = num % MOD;
			}
			bottom = bottom * bottom % MOD;
			l /= 2;
		}
		return num;
	}

	static long fac(int n) {
		long num = 1;
		while(n >= 1) {
			num = (num * n) % MOD;
			n--;
		}
		return num;
	}
}
