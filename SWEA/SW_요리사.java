package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_요리사 {
	static int T, N, min, sum, sum1, sum2;
	static int[][] s;
	static int[] tgt1, tgt2;
	static int[] choose = new int[2];
	static boolean[] select;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_4012_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			s = new int[N][N];
			tgt1 = new int[N/2];
			tgt2 = new int[N/2];
			select = new boolean[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					s[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			comb(0, 0);
			System.out.println("#" + t + " " + min);			
		}
	}
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == N/2) {
			int index = 0;
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < N; j++) {
					if( tgt1[i] == j ) {
						select[j] = true;
						continue;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				if(!select[i]) tgt2[index++] = i;
			}
			Arrays.fill(select, false);
			search();
			return;
		}
		
		if(srcIdx == N) return;
		
		tgt1[tgtIdx] = srcIdx;
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
		
	}
	static void search() {
		sum = 0;
		select(0, 0, tgt1);
		sum1 = sum;
		sum = 0;
		select(0, 0, tgt2);
		sum2 = sum;
		min = Math.min(min, Math.abs(sum1 - sum2));
	}
	static void select(int srcIdx, int tgtIdx, int[] tgt) {
		if(tgtIdx == 2) {
			sum += s[choose[0]][choose[1]] + s[choose[1]][choose[0]];
			return;
		}
		if(srcIdx == N/2) return;
		
		choose[tgtIdx] = tgt[srcIdx];
		select(srcIdx + 1, tgtIdx + 1, tgt);
		select(srcIdx + 1, tgtIdx, tgt);
	}

}
