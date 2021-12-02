package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_재미있는오셀로게임_4615 {

	static int T, N, M;
	static int[][] othello;
	static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};
	static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			othello = new int[N+1][N+1];
			int half = N/2;
			othello[half][half] = 2;
			othello[half][half+1] = 1;
			othello[half+1][half] = 1;
			othello[half+1][half+1] = 2;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int bw = Integer.parseInt(st.nextToken());
				othello[y][x] = bw;
				stone(y, x, bw);
			}
			int blackCnt = 0;
			int whiteCnt = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(othello[i][j] == 1) blackCnt++;
					else if(othello[i][j] == 2) whiteCnt++;
				}
			}
			System.out.println("#" + t + " " + blackCnt + " " + whiteCnt);
		}
	}
	static void stone(int y, int x, int bw) {
		for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			while(true) {
				if(ny <= 0 || ny > N || nx <= 0 || nx > N) break;
				if(othello[ny][nx] == 0) break;
				if(othello[ny][nx] == bw) {
					loop(y, x, ny, nx, dy[i], dx[i], bw);
					break;
				}
				ny += dy[i];
				nx += dx[i];
			}
		}
	}
	static void loop(int y, int x, int ny, int nx, int dy, int dx, int bw) {
		int ty = y + dy;
		int tx = x + dx;
		while(true) {
			if(ty == ny && tx == nx) break;
			othello[ty][tx] = bw;
			ty += dy;
			tx += dx;
		}
	}
}
