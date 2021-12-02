package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_햄버거다이어트 {
	static int T, N, L;
	static int[][] ing;
	static int calsum, tastesum, max;
	static int[][] tgt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			ing = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ing[i][0] = Integer.parseInt(st.nextToken());
				ing[i][1] = Integer.parseInt(st.nextToken());
			}
			
			max = 0;
			for (int i = 1; i <= N; i++) {
				calsum = 0;
				tastesum = 0;
				tgt = new int[i][2];
				comb(0, 0);
			}
			
			System.out.println("#" + t + " " + max);
		}

	}
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {
			for (int i = 0; i < tgt.length; i++) {
				calsum += tgt[i][1];
				tastesum += tgt[i][0];
			}
			if(calsum <= L) {
				max = Math.max(max, tastesum);				
			}
			calsum = 0;
			tastesum = 0;
			return;
		}
		
		if( srcIdx == N ) return;
								
		tgt[tgtIdx][0] = ing[srcIdx][0];
		tgt[tgtIdx][1] = ing[srcIdx][1];
		comb(srcIdx+1, tgtIdx+1);
		comb(srcIdx+1, tgtIdx);	
	}
}
