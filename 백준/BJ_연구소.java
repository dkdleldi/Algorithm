package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_연구소 {

	static int N, M, count, max;
	static int[][] map, backup;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean[][] visit;
	static Queue<Node> first;
	static Queue<Node> queue;
	static ArrayList<Node> list;
	static Node[] tgt;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		backup = new int[N][M];
		visit = new boolean[N][M];
		first = new LinkedList<>();
		queue = new LinkedList<>();
		list = new ArrayList<>();
		tgt = new Node[3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				backup[i][j] = map[i][j];
				if(map[i][j] == 0) list.add(new Node(i, j));
				else if(map[i][j] == 2) {
					visit[i][j] = true;
					first.offer(new Node(i, j));
					queue.offer(new Node(i, j));
				}
			}
		}
		comb(0, 0, map);
		System.out.println(max);
	}

	static void comb(int srcIdx, int tgtIdx, int[][] map) {
		int[][] temp = drawMap(map);
		if(tgtIdx == 3) {
			bfs(map);
			reset();
			return;
		}
		if(srcIdx == list.size()) return;
		
		tgt[tgtIdx] = list.get(srcIdx);
		temp[tgt[tgtIdx].y][tgt[tgtIdx].x] = 1;
		comb(srcIdx+1, tgtIdx+1, temp);
		comb(srcIdx+1, tgtIdx, map);
		
	}
	
	static void bfs(int[][] map) {
		while( !queue.isEmpty() ) {
			Node n = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] || map[ny][nx] == 1) continue;
				visit[ny][nx] = true;
				queue.offer(new Node(ny, nx));
				map[ny][nx] = 2;
			}
		}
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) count++;
			}
		}
		if(max < count) max = count;
	}
	
	static void reset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = false;
			}
		}
		for (int i = 0; i < first.size(); i++) {
			Node n = first.poll();
			queue.offer(n);
			first.offer(n);
			visit[n.y][n.x] = true;
		}		
	}
	
	static int[][] drawMap(int[][] origin) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = origin[i][j];
			}
		}
		return temp;
	}
	
	static class Node {
		int y;
		int x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
