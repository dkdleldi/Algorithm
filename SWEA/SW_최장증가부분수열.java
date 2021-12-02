package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_최장증가부분수열 {

	static int T, N;
	static int[] num;
	static int[] LIS;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			LIS = new int[N];
			num = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if(num[j] < num[i] && LIS[i] < LIS[j] + 1) {
						LIS[i] = LIS[j] + 1;
					}
				}
				if(max < LIS[i]) max = LIS[i];
			}
			System.out.println("#" + t + " " + max);
		}
	}
}
