package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SW_보급로_Dijkstra {

	static int T, N;
	static int[][] map;
	static int[][] min;
	static boolean[][] visit;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static PriorityQueue<Node> pqueue = new PriorityQueue<>((n1, n2) -> n1.d - n2.d);
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			min = new int[N][N];
			char[][] temp = new char[N][];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				temp[i] = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[i][j] - '0';
					min[i][j] = 100 * 100 * 10;
				}
			}
			pqueue.clear();
			dijkstra();
			System.out.println("#" + t + " " + min[N-1][N-1]);
		}
	}
	
	static void dijkstra() {
		pqueue.offer(new Node(0, 0, 0));
		min[0][0] = 0;
		visit[0][0] = true;
		while(!pqueue.isEmpty()) {
			Node n = pqueue.poll();
			if(n.y == N-1 && n.x == N-1) break;
			for (int i = 0; i < 4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx]) continue;
				if(min[ny][nx] > n.d + map[ny][nx]) {
					visit[ny][nx] = true;
					min[ny][nx] = n.d + map[ny][nx];
					pqueue.offer(new Node(ny, nx, min[ny][nx]));
				}
				
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
