package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_빵집 {
	static int R, C, max;
	static char[][] map;
	static int[] dy = {-1, 0, 1};
	static int[] dx = {1, 1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp[j];
			}
		}
		for (int i = 0; i < R; i++) {
			if(install(i, 0)) max++;
		}
		System.out.println(max);
	}
	static boolean install(int y, int x) {
		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(nx == C-1) return true;
			if(ny < 0 || ny >= R || map[ny][nx] == 'x') continue;
			map[ny][nx] = 'x';
			if( install(ny,nx) ) return true;
		}
		return false;
	}
}
