package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_소수찾기_1978 {

	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		for (int i = 0; i < N; i++) {
			boolean prime = true;
			int n = Integer.parseInt(st.nextToken());
			if(n == 1) continue;
			for (int j = 2; j < n; j++) {
				if(n % j == 0) {
					prime = false;
					break;
				}
			}
			if(prime) ans++;
		}
		System.out.println(ans);
	}
}
