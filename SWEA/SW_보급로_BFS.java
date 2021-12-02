package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW_보급로_BFS {

	static int T, N, min;
	static int[][] map;
	static boolean[][] visit;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static Queue<Node> queue = new LinkedList<Node>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[j] - '0';
				}
			}
			min = Integer.MAX_VALUE;
			bfs();
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void bfs() {
		queue.offer(new Node(0, 0, 0));
		visit[0][0] = true;
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			visit[n.y][n.x] = true;
			if(n.d > min) continue;
			if(n.y == N-1 && n.x == N-1) {
				min = Math.min(min, n.d);
			}
			for (int i = 0; i < 4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) continue;
				if(n.d + map[ny][nx] > min) continue;
				queue.offer(new Node(ny, nx, n.d + map[ny][nx]));
			}
		}
	}

	static class Node {
		int y;
		int x;
		int d;
		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}
