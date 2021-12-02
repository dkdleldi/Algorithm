package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_OX퀴즈_8958 {

	static int T;
	static int sum, score;
	static char[] OX;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			OX = br.readLine().toCharArray();
			sum = 0;
			score = 0;
			for (int i = 0; i < OX.length; i++) {
				if(OX[i] == 'O') {
					score++;
					sum += score;
				}
				else {
					score = 0;
				}
			}
			System.out.println(sum);
		}
	}
}
