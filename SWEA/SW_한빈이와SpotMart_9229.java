import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_한빈이와SpotMart_9229 {
	static int T, N, M, max, sum;
	static int[] snack;
	static int[] bought = new int[2];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			snack = new int[N];
			for (int i = 0; i < N; i++) {				
				snack[i] = Integer.parseInt(st.nextToken());
			}
			max = -1;
			sum = 0;
			comb(0, 0);
			System.out.println("#" + t + " " + max);
		}
	}
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == 2) {
			sum = bought[0] + bought[1];
			if(sum <= M) max = Math.max(max, sum);
			return;
		}
		if (srcIdx == snack.length) return;
		
		bought[tgtIdx] = snack[srcIdx];
		comb(srcIdx+1, tgtIdx+1);
		comb(srcIdx+1, tgtIdx);
	}

}
