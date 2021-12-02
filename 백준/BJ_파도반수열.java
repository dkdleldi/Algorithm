package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_파도반수열 {

	static int T, N;
	static long[] P;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			P = new long[N+1];
			if(N >= 1) P[1] = 1;
			if(N >= 2) P[2] = 1;
			if(N >= 3) P[3] = 1;
			if(N >= 4) P[4] = 2;
			if(N >= 5) P[5] = 2;
			for (int i = 6; i <= N; i++) {
				P[i] = P[i-1] + P[i-5];
			}
			System.out.println(P[N]);
		}
	}
}
