package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_Sum_1209 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1209_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			int max = Integer.MIN_VALUE;
			int sum = 0;
			int[][] num = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					num[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					sum += num[i][j];
				}
				max = Math.max(max, sum);
				sum = 0;
			}
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					sum += num[j][i];
				}
				max = Math.max(max, sum);
				sum = 0;
			}
			int y = 0;
			int x = 0;
			for (int i = 0; i < 100; i++) {
				sum += num[y++][x++];
			}
			max = Math.max(max, sum);
			y = 0;
			x = 99;
			sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += num[y++][x--];
			}
			max = Math.max(max, sum);
			System.out.println("#" + t + " " + max);
		}

	}

}
