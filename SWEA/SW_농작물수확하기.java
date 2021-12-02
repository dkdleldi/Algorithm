package sw;

import java.io.FileInputStream;
import java.util.Scanner;

public class SW_농작물수확하기 {
	static int T, N, rev;
	static int[][] farm;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_2805_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				String num = sc.next();
				for (int j = 0; j < N; j++) {
					farm[i][j] = num.charAt(j) - '0';
				}
			}
			int line = 0;
			for (int i = 0; i < N; i++) {
				rev += farm[i][N/2];
				if (line >= 1) {
					for (int j = 1; j <= line; j++) {
						rev += farm[i][N/2 + j] + farm[i][N/2 - j];
					}
				}
				if ( i < (N/2) ) line++;
				else line--;
			}
			
			System.out.println("#" + t + " " + rev);
			rev = 0;
		}

	}

}
