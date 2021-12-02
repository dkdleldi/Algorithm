import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_탈주범검거_1953 {

	static int T, N, M, R, C, L, ans;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Node> queue = new LinkedList<Node>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new boolean[N][M];
			queue.clear();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			bfs();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visit[i][j]) ans++;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	static void bfs() {
		queue.offer(new Node(R, C, 1));
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			int r = n.y;
			int c = n.x;
			int l = n.l;
			visit[r][c] = true;
			if(l == L) continue;	
			int[] dy;
			int[] dx;
			if(map[r][c] == 1) {
				dy = new int[] {-1, 1, 0, 0};
				dx = new int[] {0, 0, -1, 1};
				for (int i = 0; i < 4; i++) {
					int ny = r + dy[i];
					int nx = c + dx[i];
					if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 0) continue;
					if(i == 0 && (map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7)) continue;
					if(i == 1 && (map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6)) continue;
					if(i == 2 && (map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7)) continue;
					if(i == 3 && (map[ny][nx] == 2 || map[ny][nx] == 4 || map[ny][nx] == 5)) continue;
					queue.offer(new Node(ny, nx, l+1));
				}
			}
			else if(map[r][c] == 2) {
				dy = new int[] {-1, 1};
				dx = new int[] {0, 0};
				for (int i = 0; i < 2; i++) {
					int ny = r + dy[i];
					int nx = c + dx[i];
					if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 0) continue;
					if(map[ny][nx] == 3) continue;
					if(i == 0 && (map[ny][nx] == 4 || map[ny][nx] == 7)) continue;
					if(i == 1 && (map[ny][nx] == 5 || map[ny][nx] == 6)) continue;
					queue.offer(new Node(ny, nx, l+1));
				}
			}
			else if(map[r][c] == 3) {
				dy = new int[] {0, 0};
				dx = new int[] {-1, 1};
				for (int i = 0; i < 2; i++) {
					int ny = r + dy[i];
					int nx = c + dx[i];
					if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 0) continue;
					if(map[ny][nx] == 2) continue;
					if(i == 0 && (map[ny][nx] == 6 || map[ny][nx] == 7)) continue;
					if(i == 1 && (map[ny][nx] == 4 || map[ny][nx] == 5)) continue;
					queue.offer(new Node(ny, nx, l+1));
				}
			}
			else if(map[r][c] == 4) {
				dy = new int[] {-1, 0};
				dx = new int[] {0, 1};
				for (int i = 0; i < 2; i++) {
					int ny = r + dy[i];
					int nx = c + dx[i];
					if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 0) continue;
					if(i == 0 && (map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7)) continue;
					if(i == 1 && (map[ny][nx] == 2 || map[ny][nx] == 4 || map[ny][nx] == 5)) continue;
					queue.offer(new Node(ny, nx, l+1));
				}
			}
			else if(map[r][c] == 5) {
				dy = new int[] {1, 0};
				dx = new int[] {0, 1};
				for (int i = 0; i < 2; i++) {
					int ny = r + dy[i];
					int nx = c + dx[i];
					if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 0) continue;
					if(i == 0 && (map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6)) continue;
					if(i == 1 && (map[ny][nx] == 2 || map[ny][nx] == 4 || map[ny][nx] == 5)) continue;
					queue.offer(new Node(ny, nx, l+1));
				}
			}
			else if(map[r][c] == 6) {
				dy = new int[] {1, 0};
				dx = new int[] {0, -1};
				for (int i = 0; i < 2; i++) {
					int ny = r + dy[i];
					int nx = c + dx[i];
					if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 0) continue;
					if(i == 0 && (map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6)) continue;
					if(i == 1 && (map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7)) continue;
					queue.offer(new Node(ny, nx, l+1));
				}
			}
			else if(map[r][c] == 7) {
				dy = new int[] {-1, 0};
				dx = new int[] {0, -1};
				for (int i = 0; i < 2; i++) {
					int ny = r + dy[i];
					int nx = c + dx[i];
					if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 0) continue;
					if(i == 0 && (map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7)) continue;
					if(i == 1 && (map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7)) continue;
					queue.offer(new Node(ny, nx, l+1));
				}
			}
		}
	}
	
	static class Node {
		int y;
		int x;
		int l;
		public Node(int y, int x, int l) {
			this.y = y;
			this.x = x;
			this.l = l;
		}
	}
}
