package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_단지번호붙이기_2667 {

	static int N;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Node> queue;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static ArrayList<Integer> house;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp[j] - '0';
			}
		}
		queue = new LinkedList<Node>();
		house = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					queue.offer(new Node(i, j));
					visit[i][j] = true;
					bfs();
				}
			}
		}
		Collections.sort(house);
		System.out.println(house.size());
		for (int i = 0; i < house.size(); i++) {
			System.out.println(house.get(i));
		}
	}
	
	static void bfs() {
		int hNum = 1;
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] == 0) continue;
				visit[ny][nx] = true;
				queue.offer(new Node(ny, nx));
				hNum++;
			}
		}
		house.add(hNum);
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
