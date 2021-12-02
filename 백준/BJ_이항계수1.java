package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_이항계수1 {

	static int N, K;
	static int[][] pascal;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		pascal = new int[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				if(i==0 || j==0 || j==i) pascal[i][j] = 1;
				else pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
			}
		}
		System.out.println(pascal[N][K]);
	}
}
