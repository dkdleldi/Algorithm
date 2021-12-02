package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_달이차오른다가자 {

	static int N, M, min;
	static char[][] maze;
	static boolean[][][] visit;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};	
	static Queue<Move> queue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new char[N][];
		visit = new boolean[N][M][1 << 6];
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			maze[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(maze[i][j] == '0') {
					queue.offer(new Move(i, j, 0, 0));
					visit[i][j][0] = true;
				}
			}
		}
		min = Integer.MAX_VALUE;
		bfs();
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Move m = queue.poll();
			if(maze[m.y][m.x] == '1') {
				min = Math.min(min, m.n);
				//break;
			}
			for (int i = 0; i < 4; i++) {
				int ny = m.y + dy[i];
				int nx = m.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || maze[ny][nx] == '#') continue;
				if(m.n+1 >= min) break;
				int K = m.key;
				if('a' <= maze[ny][nx] && maze[ny][nx] <= 'f') {
					K |= 1 << (maze[ny][nx]-'a');
				}
				if('A' <= maze[ny][nx] && maze[ny][nx] <= 'F') {
					if((K & (1 << (maze[ny][nx]-'A'))) == 0) continue;				
				}
				if(visit[ny][nx][K]) continue;
				visit[ny][nx][K] = true;
				queue.offer(new Move(ny, nx, m.n+1, K));
			}
		}
	}
	
	static class Move {
		int y;
		int x;
		int n;
		int key;
		public Move(int y, int x, int n, int key) {
			this.y = y;
			this.x = x;
			this.n = n;
			this.key = key;
		}
	}
}
