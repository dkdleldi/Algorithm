package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_비밀이메일_2999 {

	static int R, C, N;
	static char[][] ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] pass = br.readLine().toCharArray();
		N = pass.length;
		int r = 1;
		int c = N;
		while(r <= c) {
			if(r*c == N) {
				R = r;
				C = c;
			}
			r++;
			c = N / r;
		}
		ans = new char[R][C];
		int index = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				ans[j][i] = pass[index++];
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(ans[i][j]);
			}
		}
	}
}
