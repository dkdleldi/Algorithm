package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_ATM_11399 {

	static int N;
	static int[] min;
	static int minimum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		min = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			min[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(min);
		for (int i = 1; i < N; i++) {
			min[i] = min[i-1] + min[i];
		}
		for (int i = 0; i < N; i++) {
			minimum += min[i];
		}
		System.out.println(minimum);
	}
}
