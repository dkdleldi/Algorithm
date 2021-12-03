package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_덩치_7568 {

	static int N;
	static int[][] p;
	static int[] ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		p = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p[i][0] = Integer.parseInt(st.nextToken());
			p[i][1] = Integer.parseInt(st.nextToken());
		}
		ans = new int[N];
		Arrays.fill(ans, 1);
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if(p[j][0] > p[i][0] && p[j][1] > p[i][1]) ans[i]++;
				else if(p[j][0] < p[i][0] && p[j][1] < p[i][1]) ans[j]++;
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
