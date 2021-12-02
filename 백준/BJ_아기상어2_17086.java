package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_아기상어2_17086 {

	static int N, M, max;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Node> queue;
	static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					queue.offer(new Node(i, j, 0));
					visit[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			if(max < n.d) {
				max = n.d;
			}
			for (int i = 0; i < 8; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) continue;
				visit[ny][nx] = true;
				queue.offer(new Node(ny, nx, n.d+1));
			}
		}
		
		System.out.println(max);
	}

	static class Node {
		int y, x, d;
		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}
