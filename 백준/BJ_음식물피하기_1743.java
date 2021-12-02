package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_음식물피하기_1743 {

	static int N, M, K, max;
	static boolean[][] map;
	static Queue<Node> queue;
	static boolean[][] visit;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[N+1][M+1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[y][x] = true;
		}
		queue = new LinkedList<Node>();
		visit = new boolean[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(map[i][j]) {
					queue.offer(new Node(i, j));
					visit[i][j] = true;
					bfs();
				}
			}
		}
		System.out.println(max);
	}
	
	static void bfs() {
		int num = 1;
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny < 1 || nx < 1 || ny > N || nx > M || visit[ny][nx] || !map[ny][nx]) continue;
				queue.offer(new Node(ny, nx));
				visit[ny][nx] = true;
				num++;
			}
		}
		max = Math.max(max, num);
	}

	static class Node {
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
