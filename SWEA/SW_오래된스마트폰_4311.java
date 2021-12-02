package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_오래된스마트폰_4311 {

	static int T, N, O, M, W, min;
	static boolean[] num;
	static boolean[] op;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			O = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			num = new boolean[10];
			op = new boolean[5];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int n = Integer.parseInt(st.nextToken());
				num[n] = true;
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < O; i++) {
				int o = Integer.parseInt(st.nextToken());
				op[o] = true;
			}
			W = Integer.parseInt(br.readLine());
			min = -1;
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(!num[srcIdx]) return;
		if(tgtIdx == 0) {
			return;
		}
		if(srcIdx == -1) return;
	}

}
