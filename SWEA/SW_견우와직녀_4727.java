package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_견우와직녀_4727 {

	static int T, N, M, min;
	static int[][] map;
	static int[] dy = {0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, -1, 1};
	static Queue<Place> queue;
	static boolean[][][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			queue = new LinkedList<Place>();
			visit = new boolean[N][N][];
			min = Integer.MAX_VALUE;
			bfs();
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void bfs() {
		queue.offer(new Place(0, 0, 0));
		//visit[0][0][] = true;
		while(!queue.isEmpty()) {
			Place p = queue.poll();
			if(p.y == N-1 && p.x == N-1) {
				min = Math.min(min, p.t);
			}
		}
	}

	static class Place {
		int y;
		int x;
		int t;
		public Place(int y, int x, int t) {
			this.y = y;
			this.x = x;
			this.t = t;
		}
	}
}
