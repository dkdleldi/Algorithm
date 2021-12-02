package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_최적경로 {
	static int T, N, min;
	static int[] company = new int[2];
	static int[] home = new int[2];
	static int[][] customer;
	static int[] idx;
	static boolean[] select;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1247_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			customer = new int[N][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
			}

			select = new boolean[N];
			idx = new int[N];
			min = Integer.MAX_VALUE;
			perm(0);
			System.out.println("#" + t + " " + min);
		}
	}
	static void perm(int tgtIdx) {
		if(tgtIdx == N) {
			visit();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(select[i]) continue;
			
			select[i] = true;
			idx[tgtIdx] = i;
			perm(tgtIdx + 1);
			select[i] = false;
		}
	}
	static void visit() {
		int dist = Math.abs(company[0] - customer[idx[0]][0]) + Math.abs(company[1] - customer[idx[0]][1]);
		for (int i = 1; i <= N-1; i++) {
			dist += Math.abs(customer[idx[i-1]][0] - customer[idx[i]][0]) + Math.abs(customer[idx[i-1]][1] - customer[idx[i]][1]);
			if(dist > min) return;
		}
		dist += Math.abs(home[0] - customer[idx[N-1]][0]) + Math.abs(home[1] - customer[idx[N-1]][1]);
		min = Math.min(min, dist);
	}
}
