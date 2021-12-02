package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_N번째큰수_2693 {

	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int[] num = new int[10];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			int i = 1;
			while(true) {
				if(i == 10) break;
				if(num[i] < num[i-1]) {
					int temp = num[i];
					num[i] = num[i-1];
					num[i-1] = temp;
					if(i > 1) i--;
				}
				else i++;
			}
			System.out.println(num[7]);
		}
	}
}
