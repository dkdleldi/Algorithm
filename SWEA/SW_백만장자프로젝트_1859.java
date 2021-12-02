package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_백만장자프로젝트_1859 {

	static int T, N;
	static long ans;
	static int[] price;
	static int[] maxArr;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1859_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			price = new int[N];
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());		
			}
			int max = price[N-1];
			for (int i = N-2; i >= 0; i--) {
				if(price[i] < max) {
					ans += max - price[i];
				}
				else max = price[i];
			}

			System.out.println("#" + t + " " + ans);
		}
	}
}
