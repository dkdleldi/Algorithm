package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_프로세서연결하기_1767 {

	static int T, N, max, min;
	static int[][] con;
	static int[] dy = {0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, -1, 1};
	static ArrayList<Core> core;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			core = new ArrayList<>();
			con = new int[N][N];
			max = 0;
			min = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					con[i][j] = Integer.parseInt(st.nextToken());
					if(con[i][j] == 1) core.add(new Core(i, j, 0, Integer.MAX_VALUE));
				}
			}
			install(0, 0, 0, con);
			System.out.println("#" + t + " " + min);
		}
	}
	static void install(int index, int coreNum, int len, int[][] map) {
		if(index == core.size()) {
			if(coreNum > max) {
				max = coreNum;
				min = len;
			}
			else if(coreNum == max) {
				if(len < min) min = len;
			}
			return;
		}
		Core c = core.get(index);
		if(c.y == 0 || c.x == 0 || c.y == N-1 || c.x == N-1) {
			c.len = 0;
			install(index+1, coreNum+1, len, map);
			return;
		}
		
		for (int j = 1; j <= 4; j++) {
			int ny = c.y + dy[j];
			int nx = c.x + dx[j];
			int l = 1;
			while(true) {
				if(map[ny][nx] == 1 || map[ny][nx] == 2) break;
				if(ny == 0 || nx == 0 || ny == N-1 || nx == N-1) {	
					c.dir = j;
					c.len = l;					
					int[][] temp = copy(map);
					temp = draw(index, temp);
					install(index+1, coreNum+1, len+l, temp);
					break;
				}
				l++;
				ny += dy[j];
				nx += dx[j];				
			}
		}
		install(index+1, coreNum, len, map);
	}
	static int[][] draw(int index, int[][] map) {
		Core c = core.get(index);
		int ny = c.y + dy[c.dir];
		int nx = c.x + dx[c.dir];
		while(true) {
			if(ny < 0 || nx < 0 || ny >= N || nx >= N) break;
			map[ny][nx] = 2;
			ny += dy[c.dir];
			nx += dx[c.dir];
		}
		return map;
	}
	static int[][] copy(int[][] origin) {
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = origin[i][j];
			}
		}
		return map;
	}
	static class Core {
		int y;
		int x;
		int dir;
		int len;
		public Core(int y, int x, int dir, int len) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.len = len;
		}
	}
}
