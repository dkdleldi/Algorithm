package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_다리만들기2 {

	static int N, M, ans;
	static int[][] map;
	static int cnt;
	static boolean[][] visit;
	static Queue<Island> queue;
	static int[][] dist;
	static boolean[] visitV;
	static int[] parent;
	static PriorityQueue<Edge> pqueue;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
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
			}
		}
		cnt = 1;
		vertex();
		dist = new int[cnt][cnt];
		for (int i = 1; i < cnt; i++) {
			Arrays.fill(dist[i], 200);
			dist[i][i] = 0;
		}
		edge();
		pqueue = new PriorityQueue<>((e1, e2) -> e1.d - e2.d);
		parent = new int[cnt];
		makeSet();
		for (int i = 1; i < cnt; i++) {
			for (int j = i; j < cnt; j++) {
				if(i == j) continue;
				if(dist[i][j] != 200) pqueue.offer(new Edge(i, j, dist[i][j]));
			}
		}
		int edgeNum = 0;
		while( !pqueue.isEmpty() ) {
			Edge e = pqueue.poll();
			if(findSet(e.v1) == findSet(e.v2)) continue;
			union(e.v1, e.v2);
			edgeNum++;
			ans += e.d;
			if(edgeNum == cnt - 2) break;
		}
		if(ans == 0 || edgeNum != cnt-2) System.out.println(-1);
		else System.out.println(ans);
	}
	static void makeSet() {
		for (int i = 1; i < cnt; i++) {
			parent[i] = i;
		}
	}
	static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	static void union(int x, int y) {
		int px = parent[x];
		int py = parent[y];
		if(px < py) parent[py] = px;
		else parent[px] = py;
	}
	
	static void edge() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(map[y][x] != 0) {
					for (int i = 0; i < 4; i++) {
						int ny = y + dy[i];
						int nx = x + dx[i];
						int dis = 0;
						while(true) {
							if(ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == map[y][x]) break;
							dis++;
							if(dis-1 >= 2 && map[ny][nx] != 0) {
								int d = dist[map[y][x]][map[ny][nx]];
								dist[map[y][x]][map[ny][nx]] = Math.min(d, dis-1);
								break;
							}
							else if(dis-1 < 2 && map[ny][nx] != 0) break;
							ny += dy[i];
							nx += dx[i];
						}
					}
				}
			}
		}
	}
	
	static void vertex() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(map[y][x] == 0) continue;
				if(!visit[y][x]) {
					queue.offer(new Island(y, x, cnt));
					map[y][x] = cnt++;
				}
				
				while( !queue.isEmpty() ) {
					Island n = queue.poll();
					
					for (int i = 0; i < 4; i++) {
						int ny = n.y + dy[i];
						int nx = n.x + dx[i];
						if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
						if(map[ny][nx] == 1 && !visit[ny][nx]) {
							map[ny][nx] = n.n;
							visit[ny][nx] = true;
							queue.offer(new Island(ny, nx, n.n));
						}
					}
				}				
			}
		}
	}

	static class Edge {
		int v1;
		int v2;
		int d;
		public Edge(int v1, int v2, int d) {
			this.v1 = v1;
			this.v2 = v2;
			this.d = d;
		}
	}
	
	static class Island {
		int y;
		int x;
		int n;
		public Island(int y, int x, int n) {
			this.y = y;
			this.x = x;
			this.n = n;
		}
	}
}
