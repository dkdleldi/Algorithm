package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_동철이의일분배_1865 {

	static int T, N;
	static double[][] P;
	static double max;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			P = new double[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					P[i][j] = Double.parseDouble(st.nextToken())/100;
				}
			}
			visit = new boolean[N];
			max = 0;
			perm(0, 100);
			System.out.print("#" + t + " ");
			System.out.printf("%6f", max);
			System.out.println();
		}
	}

	static void perm(int tgtIdx, double p) {
		if(p < max) return;
		if(tgtIdx == N) {
			max = p;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visit[i] && P[tgtIdx][i] != 0) {
				visit[i] = true;
				perm(tgtIdx+1, p*P[tgtIdx][i]);
				visit[i] = false;
			}
		}
	}
}
