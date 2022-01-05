package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_시험감독_13458 {

	static int N, B, C;
	static long min;
	static int[] A;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		min = N;
		for (int i = 0; i < N; i++) {
			if(A[i]-B > 0) {
				if((A[i]-B)%C == 0) min += (A[i]-B)/C;
				else min += (A[i]-B)/C + 1;
			}
		}
		System.out.println(min);
	}
}
