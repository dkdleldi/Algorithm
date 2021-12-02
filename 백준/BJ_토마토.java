package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_토마토 {

	static int M, N, min;
	static int[][] box;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static Queue<Node> tomato;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		tomato = new LinkedList<>();
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) {
					tomato.offer(new Node(i, j, 0));
					visit[i][j] = true;
				}
			}
		}
		min = 0;
		bfs();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 0 && !visit[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(min);		
	}
	
	static void bfs() {
		while(!tomato.isEmpty()) {
			Node n = tomato.poll();
			min = Math.max(min, n.d);
			for (int i = 0; i < 4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || box[ny][nx] == -1) continue;
				visit[ny][nx] = true;
				tomato.offer(new Node(ny, nx, n.d+1));
				box[ny][nx] = 1;
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
