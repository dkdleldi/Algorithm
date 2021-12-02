package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_미로탐색_2178 {

	static int N, M, min;
	static int[][] maze;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static Queue<Node> queue;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				maze[i][j] = temp[j] - '0';
			}
		}
		min = Integer.MAX_VALUE;
		queue = new LinkedList<Node>();
		visit = new boolean[N][M];
		queue.offer(new Node(0, 0, 1));
		visit[0][0] = true;
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			if(n.y == N-1 && n.x == M-1) {
				min = Math.min(min, n.d);
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || maze[ny][nx] == 0) continue;
				queue.offer(new Node(ny, nx, n.d+1));
				visit[ny][nx] = true;
			}
		}
		
		System.out.println(min);
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
