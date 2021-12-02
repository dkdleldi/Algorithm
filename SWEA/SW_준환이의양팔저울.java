package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_준환이의양팔저울 {

	static int T, N, count;
	static int[] weight;
	static int[][] memoi;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			count = 0;	
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				sum += weight[i];
			}
			memoi = new int[sum+1][1 << N];
			count = perm(0, 0, 0, 0);
			System.out.println("#" + t + " " + count);			
		}
	}
	static int perm(int tgtIdx, int leftsum, int rightsum, int mask) {
		if(tgtIdx == N) return 1;
		
		int sum = 0;
		
		if(memoi[leftsum][mask] != 0) return memoi[leftsum][mask];

		for (int i = 0; i < N; i++) {
			if((mask & (1 << i)) > 0) continue;
			
			sum += perm(tgtIdx + 1, leftsum + weight[i], rightsum, mask | 1<<i);
			if(leftsum >= rightsum + weight[i]) sum += perm(tgtIdx + 1, leftsum, rightsum + weight[i], mask | 1<<i);	
		}
		memoi[leftsum][mask] = sum;
		return sum;
	}
}
