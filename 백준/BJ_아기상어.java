package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_아기상어 {

	static int N, sx, sy, sSize, sEatCnt, ans;
	static int[][] map;
	static boolean[][] visit;	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static Queue<Node> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sx = j;
					sy = i;
				}
			}
		}
		
		sSize = 2;
		queue = new LinkedList<>();
		while(true) {
			int temp = bfs();
			if(temp == Integer.MAX_VALUE) break;
			ans += temp;
		}
		
		System.out.println(ans);
	}
	
	static int bfs() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visit[i][j] = false;
			}
		}
		queue.offer(new Node(sy, sx, 0));
		visit[sy][sx] = true;		
		int minY = Integer.MAX_VALUE;
		int minX = Integer.MAX_VALUE;
		int minD = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
					
			if(map[n.y][n.x] != 0 && map[n.y][n.x] < sSize && n.d <= minD) {
				if(n.d == minD) {
					if(n.y == minY) {
						if(n.x < minX) {
							minY = n.y;
							minX = n.x;
							minD = n.d;
						}
					}
					else if(n.y < minY) {
						minY = n.y;
						minX = n.x;
						minD = n.d;
					}
				}
				else if(n.d < minD) {
					minY = n.y;
					minX = n.x;
					minD = n.d;
				}
			}
			if(n.d+1 > minD) continue;
			
			for (int i = 0; i < 4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] > sSize) continue;
				
				visit[ny][nx] = true;
				queue.offer(new Node(ny, nx, n.d+1));
			}
		}
		
		if(minD != Integer.MAX_VALUE) {
			sEatCnt++;
			if(sEatCnt == sSize) {
				sSize++;
				sEatCnt = 0;
			}
			map[sy][sx] = 0;
			sy = minY;
			sx = minX;
			map[sy][sx] = 0;
		}
		return minD;
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
