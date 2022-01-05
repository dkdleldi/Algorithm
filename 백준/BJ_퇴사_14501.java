package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_퇴사_14501 {

	static int N, max;
	static int[] T, P;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		profit(0, 0);
		System.out.println(max);
	}

	static void profit(int idx, int sum) {
		if(idx == N) {
			if(sum > max) max = sum;
			return;
		}
		if(idx+T[idx]-1 < N) profit(idx+T[idx], sum+P[idx]);
		profit(idx+1, sum);
	}
}
