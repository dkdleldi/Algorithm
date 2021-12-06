package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_미생물격리_2382 {

	static int T, N, M, K, ans;
	static int[] dy = {0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, -1, 1};
	static micro[][] map;
	static micro[][] after;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new micro[N][N];
			after = new micro[N][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[y][x] = new micro(num, dir, num);
			}
			for (int i = 0; i < M; i++) {
				move();
			}
			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] != null) ans += map[i][j].num;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	static void move() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != null) {
					int num = map[i][j].num;
					int dir = map[i][j].dir;
					int max = map[i][j].max;
					int y = i + dy[dir];
					int x = j + dx[dir];
					if(y == 0 || x == 0 || y == N-1 || x == N-1) {
						num = num/2;
						max = max/2;
						if(dir == 1) dir = 2;
						else if(dir == 2) dir = 1;
						else if(dir == 3) dir = 4;
						else if(dir == 4) dir = 3;
					}
					if(after[y][x] != null) {
						if(max > after[y][x].max) {
							after[y][x].max = max;
							after[y][x].dir = dir;
						}
						after[y][x].num += num;
					} else {
						after[y][x] = new micro(num, dir, max);
					}
				}
			}
		}
		copy();
		reset();
	}
	
	static void copy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(after[i][j] != null) after[i][j].max = after[i][j].num;
				map[i][j] = after[i][j];
			}
		}
	}
	
	static void reset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				after[i][j] = null;
			}
		}
	}
	
	static class micro {
		int num, dir, max;
		public micro(int num, int dir, int max) {
			this.num = num;
			this.dir = dir;
			this.max = max;
		}
	}
}
