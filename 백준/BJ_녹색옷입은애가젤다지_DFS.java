package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_녹색옷입은애가젤다지_DFS {

	static int N, min;
	static int[][] cave;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean[][] visit;
	static int callCnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			cave = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			visit[0][0] = true;
			callCnt = 0;
			dfs(0, 0, cave[0][0]);
			System.out.println("Problem " + t + ": " + min);
			//System.out.println("callCnt " + t + ": " + callCnt);
			t++;
		}
	}
	
	static void dfs(int y, int x, int c) {
		callCnt++;
		if(c >= min) return;
		if(y == N-1 && x == N-1) {
			min = c;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) continue;
			visit[ny][nx] = true;
			dfs(ny, nx, c+cave[ny][nx]);
			visit[ny][nx] = false;
		}
	}
}
