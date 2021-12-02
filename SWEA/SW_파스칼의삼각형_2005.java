package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_파스칼의삼각형_2005 {

	static int T, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int[][] pascal = new int[N][N];
			pascal[0][0] = 1;
			for (int i = 1; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if(j == 0 || j == i) pascal[i][j] = 1;
					else pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
				}		
			}
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(pascal[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
