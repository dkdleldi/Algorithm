package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_전쟁_전투_1303 {

	static int N, M, white, blue, num;
	static char[][] map;
	static boolean[][] visit;
	static Queue<Soldier> queue;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][];
		visit = new boolean[M][N];
		queue = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					queue.offer(new Soldier(i, j, map[i][j]));
					visit[i][j] = true;
					bfs();
					if(map[i][j] =='W') white += Math.pow(num, 2);
					else blue += Math.pow(num, 2);
				}
			}
		}
		
		System.out.println(white + " " + blue);
	}

	static void bfs() {
		num = 1;
		while(!queue.isEmpty()) {
			Soldier s = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = s.y + dy[i];
				int nx = s.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= M || nx >= N || visit[ny][nx] || map[ny][nx] != s.c) continue;
				queue.offer(new Soldier(ny, nx, map[ny][nx]));
				visit[ny][nx] = true;
				num++;
			}
		}
	}
	
	static class Soldier {
		int y;
		int x;
		char c;
		public Soldier(int y, int x, char c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}
	}
}
