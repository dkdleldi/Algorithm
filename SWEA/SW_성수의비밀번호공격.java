package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_성수의비밀번호공격 {

	static int T, N, M;
	static long ans;
	static long[][] num = new long[101][101];
	static long p = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		num[0][0] = 1;
		for (int i = 1; i < 101; i++) {
			for (int j = 0; j <= i; j++) {
				if(j == 0 || j == i) num[i][j] = 1;
				else num[i][j] = (num[i-1][j-1] + num[i-1][j]) % p;
			}
		}
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			ans = 0;
			long even = 1;
			if(M % 2 == 0) even = -1;
			for (int i = 0; i <= N; i++) {
				if(i%2 == 0) ans += ((pow(i, N) % p * num[M][i]) % p) * -even;
				else ans += ((pow(i, N) % p * num[M][i]) % p) * even;
				ans = (ans + p) % p;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static long pow(long base, long expo) {
		long num = 1;
		while(expo > 0) {
			if(expo % 2 == 1) {
				num *= base;
				num %= p;
			}
			base = (base * base) % p;
			expo /= 2;
		}
		return num;
	}
}
