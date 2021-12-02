package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_도영이가만든맛있는음식 {
	static int N, min;
	static int[][] ing;
	static boolean[] select;
	static int sour, bitter;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		ing = new int[N][2];
		select = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ing[i][0] = Integer.parseInt(st.nextToken());
			ing[i][1] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		subset(0);
		System.out.println(min);
	}
	
	static void subset(int srcIdx) {
		if( srcIdx == N ) {
			sour = 1;
			bitter = 0;
			int dif = 0;
			for (int i = 0; i < N; i++) {				
				if( select[i] ) {
					sour *= ing[i][0];
					bitter += ing[i][1];
					dif = Math.abs(sour - bitter);
					min = Math.min(dif, min);
				}
			}
			return;
		}
		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);
	}

}
