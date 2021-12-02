package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW_보급로_DFS {

	static int T, N, min;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[j] - '0';
				}
			}
			min = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void dfs(int y, int x, int d) {
		if(y == N-1 && x == N-1) {
			min = Math.min(min, d);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) continue;
			if(d+map[ny][nx] > min) continue;
			visit[ny][nx] = true;
			dfs(ny, nx, d+map[ny][nx]);
			visit[ny][nx] = false;
		}
	}
}
