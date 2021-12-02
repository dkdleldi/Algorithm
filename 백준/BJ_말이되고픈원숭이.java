package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_말이되고픈원숭이 {

	static int K, W, H;
	static int[][] map;
	static int[] horseY = {-2, -1, 1, 2, -2, -1, 1, 2};
	static int[] horseX = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] monY = {-1, 1, 0, 0};
	static int[] monX = {0, 0, -1, 1};
	static boolean[][][] visit;	
	static Queue<Node> queue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visit = new boolean[H][W][K+1];
		queue = new LinkedList<>();
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean b = false;
		queue.offer(new Node(0, 0, K, 0));
		while( !queue.isEmpty() ) {
			Node n = queue.poll();
			
			if(n.y == H-1 && n.x == W-1) {
				System.out.println(n.d);
				b = true;
				break;
			}
			
			for (int i = 0; i < 8; i++) {
				int ny = n.y + horseY[i];
				int nx = n.x + horseX[i];
				if(ny < 0 || nx < 0 || ny >= H || nx >= W || n.k-1 < 0 || visit[ny][nx][n.k-1]) continue;
				if(map[ny][nx] == 0) {
					visit[ny][nx][n.k-1] = true;
					queue.offer(new Node(ny, nx, n.k-1, n.d+1));
				}
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = n.y + monY[i];
				int nx = n.x + monX[i];
				if(ny < 0 || nx < 0 || ny >= H || nx >= W || visit[ny][nx][n.k]) continue;
				if(map[ny][nx] == 0) {
					visit[ny][nx][n.k] = true;
					queue.offer(new Node(ny, nx, n.k, n.d+1));
				}
			}
		}
		if(!b) System.out.println(-1);
	}
	static class Node {
		int y, x, k, d;
		public Node(int y, int x, int k, int d) {
			this.y = y;
			this.x = x;
			this.k = k;
			this.d = d;
		}
	}
}
