package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_녹색옷입은애가젤다지_Dijkstra {

	static int N;
	static int[][] cave;
	static int[][] min;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static PriorityQueue<Edge> pqueue;
	static int callCnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			cave = new int[N][N];
			min = new int[N][N];
			pqueue = new PriorityQueue<>((e1, e2) -> e1.c - e2.c);
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
					min[i][j] = N*N*20;
				}
			}
			pqueue.offer(new Edge(0, 0, cave[0][0]));
			min[0][0] = cave[0][0];
			callCnt = 0;
			while(!pqueue.isEmpty()) {
				callCnt++;
				Edge e = pqueue.poll();
				for (int i = 0; i < 4; i++) {
					int ny = e.y + dy[i];
					int nx = e.x + dx[i];
					if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
					if(min[ny][nx] > min[e.y][e.x] + cave[ny][nx]) {
						min[ny][nx] = min[e.y][e.x] + cave[ny][nx];
						pqueue.offer(new Edge(ny, nx, min[ny][nx]));
					}
				}
			}
			System.out.println("Problem " + t + ": " + min[N-1][N-1]);
			System.out.println("callCnt " + t + ": " + callCnt);
			t++;
		}
	}
	
	static class Edge {
		int y;
		int x;
		int c;
		public Edge(int y, int x, int c) {
			this.y = y;
			this.x = x;
			this.c = c;
		}
	}
}
