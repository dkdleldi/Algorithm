package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_낚시왕2 {

	static int R, C, M, ans;
	static Shark[][] map;
	static int[] dy = {0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, 1, -1};
	static int king;
	static Stack<Shark> stack = new Stack<Shark>();
	static Shark sh;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R+1][C+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(r, c, s, d, z);
		}
		king = 0;
		while(true) {			
			king++;
			if(king > C) break;
			for (int i = 1; i <= R; i++) {
				if(map[i][king] != null) {
					ans += map[i][king].z;
					map[i][king] = null;
					break;
				}
			}
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if(map[i][j] != null) {
						move(map[i][j]);
						stack.add(map[i][j]);
					}
				}
			}
			Shark[][] temp = new Shark[R+1][C+1];
			int size = stack.size();
			for (int i = 0; i < size; i++) {
				Shark s = stack.pop();
				if(temp[s.r][s.c] != null) {
					if(temp[s.r][s.c].z < s.z) temp[s.r][s.c] = s;
				}
				else temp[s.r][s.c] = s;
			}
			copy(temp);			
		}	
		System.out.println(ans);
	}
	
	static void move(Shark s) {
		int ny = s.r;
		int nx = s.c;
		int sp = s.s;
		if(s.d == 1 || s.d == 2) sp = sp % (2*R-2);
		else if(s.d == 3 || s.d == 4) sp = sp % (2*C-2);
		for (int i = 0; i < sp; i++) {
			if(s.d == 1 && ny == 1) s.d = 2;
			if(s.d == 2 && ny == R) s.d = 1;
			if(s.d == 3 && nx == C) s.d = 4;
			if(s.d == 4 && nx == 1) s.d = 3;
			ny = ny + dy[s.d];
			nx = nx + dx[s.d];
		}
		s.r = ny;
		s.c = nx;
	}
	
	static void copy(Shark[][] origin) {
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = origin[i][j];
			}
		}
	}
	
	static class Shark {
		int r, c, s, d, z;
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
