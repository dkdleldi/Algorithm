package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_스타트와링크_14889 {

	static int N, min;
	static int[][] S;
	static boolean[] tgt;
	static int[] plus;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		tgt = new boolean[N];
		plus = new int[2];
		comb(0, 0);
		System.out.println(min);
	}
	
	static void comb(int tgtIdx, int num) {
		if(num == N/2) {
			int[] start = new int[N/2];
			int[] link = new int[N/2];
			int startIdx = 0;
			int linkIdx = 0;
			for (int i = 0; i < N; i++) {
				if(tgt[i]) start[startIdx++] = i;
				else link[linkIdx++] = i;
			}
			int startSum = combStatus(start, 0, 0);
			int linkSum = combStatus(link, 0, 0);
			int minus = Math.abs(startSum - linkSum);
			if(minus < min) min = minus;
			return;
		}
		if(tgtIdx == N) return;
		tgt[tgtIdx] = true;
		comb(tgtIdx+1, num+1);
		tgt[tgtIdx] = false;
		comb(tgtIdx+1, num);
	}
	
	static int combStatus(int[] array, int tgtIdx, int srcIdx) {
		if(tgtIdx == 2) {
			int a = plus[0];
			int b = plus[1];
			return S[a][b] + S[b][a];
		}
		if(srcIdx == N/2) return 0;
		plus[tgtIdx] = array[srcIdx];
		return combStatus(array, tgtIdx+1, srcIdx+1) + combStatus(array, tgtIdx, srcIdx+1);
	}
}
