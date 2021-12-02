package hwalgo19_부울경_3반_전양희;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_아기상어_16236 {

	static int N;
	static int[][] map;
	static boolean[][] visit;
	static PriorityQueue<Node> fish;
	static Node shark;
	static int sharkSize, fishCnt, time;
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		fish = new PriorityQueue<>();
		fishCnt = 0;
		time = 0;
		sharkSize = 2;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Node(i, j, 0);
					map[i][j] = 0;
					visit[i][j] = true;
				}
			}
		}
		bfs();
		System.out.println(time);
	}
	static void bfs() {
		fish.offer(shark);
		while( !fish.isEmpty() ) {
			if(fishCnt == sharkSize) {
				sharkSize++;
				fishCnt = 0;
			}
			//System.out.println(fish.toString());
			Node f = fish.poll();
			for (int i = 0; i < 4; i++) {
				int ny = f.y + dy[i];
				int nx = f.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] > sharkSize || visit[ny][nx]) continue;
				if(map[ny][nx] > 0 && map[ny][nx] < sharkSize) {
					fishCnt++;
					map[ny][nx] = 0;
					visit = new boolean[N][N];
					fish.clear();
					time = f.d + 1;
					visit[ny][nx] = true;				
					fish.offer(new Node(ny, nx, f.d+1));
					break;
				}
				visit[ny][nx] = true;				
				fish.offer(new Node(ny, nx, f.d+1));
			}
		}
	}
	static class Node implements Comparable<Node>{
		int y;
		int x;
		int d;
		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
		@Override
		public int compareTo(Node o) {
			if(this.d == o.d) {
				if(this.y == o.y) {
					return this.x - o.x;
				}
				else return this.y - o.y;
			}
			else return this.d - o.d;
		}
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", d=" + d + "]";
		}	
		
	}
}
