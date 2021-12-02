package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_일곱난쟁이_2309 {

	static int[] tgt;
	static int[] src;
	static int[] ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tgt = new int[7];
		src = new int[9];
		ans = new int[7];
		for (int i = 0; i < 9; i++) {
			src[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(src);
		comb(0, 0);
		for (int i = 0; i < 7; i++) {
			System.out.println(ans[i]);
		}
	}
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += tgt[i];
			}
			if(sum == 100) {
				for (int i = 0; i < 7; i++) {
					ans[i] = tgt[i];
				}
			}
			return;
		}
		if(srcIdx == 9) return;
		
		tgt[tgtIdx] = src[srcIdx];
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
}
