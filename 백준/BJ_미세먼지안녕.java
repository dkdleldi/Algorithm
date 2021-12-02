package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_미세먼지안녕 {

	static int R, C, T, purifier, dust;
	static int[][] room;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		room = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j] == -1) purifier = i;
			}
		}
		
		for (int i = 0; i < T; i++) {
			room = diffusion();
			purify();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(room[i][j] == -1) continue;
				dust += room[i][j];
			}
		}
		System.out.println(dust);
	}
	
	static int[][] diffusion() {
		int[][] map = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int cnt = 0;
				if(room[i][j] > 0) {
					for (int k = 0; k < 4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						if(ny < 0 || nx < 0 || ny >= R || nx >= C || room[ny][nx] == -1) continue;
						map[ny][nx] += room[i][j] / 5;
						cnt++;
					}
					map[i][j] += room[i][j] - ((room[i][j] / 5) * cnt);
				}
			}
		}
		map[purifier-1][0] = -1;
		map[purifier][0] = -1;
		return map;
	}
	
	static void purify() {
		int y = purifier-2;
		int x = 0;
		room[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			while(true) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || ny >= purifier || nx >= C) break;
				if(room[ny][nx] == -1) {
					room[y][x] = 0;
					break;
				}
				room[y][x] = room[ny][nx];
				y = ny;
				x = nx;
			}
		}
		
		y = purifier+1;
		x = 0;
		room[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			while(true) {
				int ny = y - dy[i];
				int nx = x + dx[i];
				if(ny < purifier || nx < 0 || ny >= R || nx >= C) break;
				if(room[ny][nx] == -1) {
					room[y][x] = 0;
					break;
				}
				room[y][x] = room[ny][nx];
				y = ny;
				x = nx;
			}
		}
	}
}
