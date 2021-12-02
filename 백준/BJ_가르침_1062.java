package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_가르침_1062 {

	static int N, K, max;
	static char[][] word;
	static char[] src;
	static char[] tgt;
	static boolean[] idx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		word = new char[N][];
		idx = new boolean[26];
		for (int i = 0; i < N; i++) {
			word[i] = br.readLine().toCharArray();
		}
		
		if(K < 5) {
			System.out.println(0);
			return;
		}
		if(K == 26) {
			System.out.println(N);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 4; j < word[i].length-4; j++) {
				if(word[i][j] == 'a' || word[i][j] == 'c' || word[i][j] == 'i' || word[i][j] == 'n' || word[i][j] == 't') continue;
				idx[word[i][j]-'a'] = true;
			}
		}
		
		int length = 0;
		for (int i = 0; i < 26; i++) {
			if(idx[i]) length++;
		}
		if(length == 0 || K-5 >= length) {
			System.out.println(N);
			return;
		}
		
		src = new char[length];
		int index = 0;
		for (int i = 0; i < 26; i++) {
			if(idx[i]) {
				src[index++] = (char)('a' + i);
			}
		}
		tgt = new char[K-5];
		comb(0, 0);
		System.out.println(max);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == K-5) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				boolean valid = false;
				for (int j = 0; j < word[i].length; j++) {
					valid = false;
					if(word[i][j] == 'a' || word[i][j] == 'c' || word[i][j] == 'i' || word[i][j] == 'n' || word[i][j] == 't') {
						valid = true;
						continue;
					}
					for (int k = 0; k < K-5; k++) {
						if(word[i][j] == tgt[k]) {
							valid = true;
							break;							
						}
						valid = false;
					}
					if(!valid) break;
				}
				if(valid) cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}
		if(srcIdx == src.length) return;
		
		tgt[tgtIdx] = src[srcIdx];
		comb(srcIdx+1, tgtIdx+1);
		comb(srcIdx+1, tgtIdx);
	}
}
