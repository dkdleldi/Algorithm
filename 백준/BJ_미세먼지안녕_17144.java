package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_미세먼지안녕_17144 {

	static int R, C, T, ans;
	static int[][] room;
	static int[] pur;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {-1, 0, 1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		ans = 0;
		room = new int[R][C];
		pur = new int[2];
		int[][] temp;
		int n = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j] == -1) pur[n++] = i;
			}
		}
		for (int i = 0; i < T; i++) {
			temp = new int[R][C];
			temp[pur[0]][0] = -1;
			temp[pur[1]][0] = -1;
			for (int y = 0; y < R; y++) {
				for (int x = 0; x < C; x++) {
					if(room[y][x] != 0 && room[y][x] != -1) {
						int cnt = 0;
						for (int j = 0; j < 4; j++) {
							int ny = y + dy[j];
							int nx = x + dx[j];
							if(ny < 0 || nx < 0 || ny >= R || nx >= C || room[ny][nx] == -1) continue;
							cnt++;
							temp[ny][nx] += room[y][x] / 5;
						}
						temp[y][x] += room[y][x] - (room[y][x] / 5) * cnt;
					}
					
				}
			}
			room = copy(temp);
			purifier();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(room[i][j] != 0 && room[i][j] != -1) ans += room[i][j];
			}
		}
		System.out.println(ans);
	}
	
	static int[][] copy(int[][] origin) {
		int[][] ret = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				ret[i][j] = origin[i][j];
			}
		}
		return ret;
	}
	
	static void purifier() {
		int y = pur[0];
		int x = 0;
		for (int i = 3; i >= 0; i--) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			while(true) {
				if(ny < 0 || nx < 0 || ny > pur[0] || nx >= C) break;
				if(room[y][x] == -1) room[ny][nx] = 0;
				else if(room[ny][nx] == -1) room[y][x] = 0;
				else room[y][x] = room[ny][nx];
				y = ny;
				x = nx;
				ny += dy[i];
				nx += dx[i];
			}
		}
		
		y = pur[1];
		x = 0;
		for (int i = 3; i >= 0; i--) {
			int ny = y - dy[i];
			int nx = x + dx[i];
			while(true) {
				if(ny >= R || nx < 0 || ny < pur[1] || nx >= C) break;
				if(room[y][x] == -1) room[ny][nx] = 0;
				else if(room[ny][nx] == -1) room[y][x] = 0;
				else room[y][x] = room[ny][nx];
				y = ny;
				x = nx;
				ny -= dy[i];
				nx += dx[i];
			}
		}
	}
}
