package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_색종이2_2567 {

	static int N, ans;
	static boolean[][] paper;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new boolean[102][102];
		for (int t = 0; t < N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i = y; i < y+10; i++) {
				for (int j = x; j < x+10; j++) {
					paper[i][j] = true;
				}
			}
		}
		for (int y = 1; y <= 100; y++) {			
			for (int x = 1; x <= 100; x++) {
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if(!paper[ny][nx] && paper[y][x]) ans++;
				}				
			}
		}
		System.out.println(ans);		
	}
}
