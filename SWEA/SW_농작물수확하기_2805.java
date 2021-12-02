package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SW_농작물수확하기_2805 {
	static int T, N;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_2805_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int sum = 0;
			boolean plus = true;
			int start = N/2;
			int end = N/2;
			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();
				if(i >= N/2) plus = false;
				for (int j = start; j <= end; j++) {
					sum += temp[j] - '0';
				}
				if(plus) {
					start--;
					end++;
				}
				else {
					start++;
					end--;
				}			
			}
			System.out.println("#" + t + " " + sum);
		}		
	}
}
