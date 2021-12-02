package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_Contact {

	static int L, S, max, maxDepth;
	static boolean[][] con;
	static boolean[] visit;
	static PriorityQueue<Node> queue = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1238_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			con = new boolean[101][101];
			visit = new boolean[101];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < L/2; i++) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				con[s][e] = true;
			}			
			queue.clear();
			max = 0;
			maxDepth = 0;
			bfs();
			System.out.println("#" + t + " " + max);
		}

	}

	static void bfs() {
		visit[S] = true;
		queue.add(new Node(S, 0));
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			int num = n.node;
			int d = n.depth;

			for (int i = 1; i <= 100; i++) {
				if(con[num][i] && !visit[i]) {
					visit[i] = true;
					queue.add(new Node(i, d+1));
				}
			}
			if(maxDepth < d) {
				maxDepth = d;
				max = num;
			}
			else if(maxDepth == d) max = Math.max(max, num);
		}

	}
	
	static class Node implements Comparable<Node> {
		int node;
		int depth;
		public Node(int node, int depth) {
			this.node = node;
			this.depth = depth;
		}
		@Override
		public int compareTo(Node o) {
			return this.depth - o.depth;
		}
	}
}
