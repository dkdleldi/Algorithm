package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_Ladder1 {

	static int[][] ladder = new int[100][100];
	static int ans;
	static boolean[][] visit = new boolean[100][100];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("SW_1210_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			for (int y = 0; y < 100; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < 100; x++) {
					ladder[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			for(int x = 0; x < 100; x++) {
				if(ladder[99][x] == 2) ans = x;
			}
			
			int y = 99;
			int x = ans;
			for (boolean b[] : visit) {
				Arrays.fill(b, false);
			}
			
			visit[y][x] = true;
			while(true) {
				if(x-1 >= 0 && ladder[y][x-1] == 1 && visit[y][x-1] == false) {
					visit[y][x] = true;
					x = x-1;
				}
				else if(x+1 < 100 && ladder[y][x+1] == 1 && visit[y][x+1] == false) {
					visit[y][x] = true;
					x = x+1;
				}
				else if(y-1 >= 0 && ladder[y-1][x] == 1) {
					y = y-1;
				}
				if(y==0) break;
			}			
			ans = x;
			System.out.println("#" + t + " " + ans);
		}

	}

}
