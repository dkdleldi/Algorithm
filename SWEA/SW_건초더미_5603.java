package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_건초더미_5603 {
	static int T,N;
	static int[] dummy;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			dummy = new int[N];
			int count = 0;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				dummy[i] = Integer.parseInt(br.readLine());
				sum += dummy[i];
			}
			int num = sum / N;
			for (int i = 0; i < N; i++) {
				if(dummy[i] > num) count += dummy[i] - num;
			}
			System.out.println("#" + t + " " + count);
		}
	}
}
