package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_동전2_2294 {

	static int n, k;
	static int[] coin;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coin = new int[n];
		dp = new int[k+1];
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		Arrays.fill(dp, 100000);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j-coin[i]] + 1, dp[j]);
			}
		}
//		for (int i = 1; i <= k; i++) {
//			for (int j = 0; j < n; j++) {
//				if(i >= coin[j]) dp[i] = Math.min(dp[i-coin[j]] + 1, dp[i]);
//			}
//		}
		System.out.println(dp[k] == 100000 ? -1 : dp[k]);
	}
}
