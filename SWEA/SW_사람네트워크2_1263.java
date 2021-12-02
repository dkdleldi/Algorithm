package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_사람네트워크2_1263 {

	static int T, N, min;
	static int[][] net;
	static int[] dist;
	static PriorityQueue<Node> queue;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1263_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			net = new int[N][N];
			dist = new int[N];
			min = Integer.MAX_VALUE;
			queue = new PriorityQueue<>((n1, n2) -> n1.d - n2.d);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					net[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				reset(i);
				search(i);
			}
			
			System.out.println("#" + t + " " + min);
		}	
	}
	static void reset(int num) {
		for (int i = 0; i < N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[num] = 0;
	}
	static void search(int num) {
		int sum = 0;
		queue.add(new Node(num, 0));
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			for (int i = 0; i < N; i++) {
				if(sum > min) break;
				if(net[n.idx][i] == 1) {
					if(dist[i] > n.d + 1) {
						dist[i] = n.d + 1;
						queue.add(new Node(i, dist[i]));
						sum += dist[i];
					}
				}
			}
		}	
		min = Math.min(min, sum);
	}
	static class Node {
		int idx;
		int d;
		public Node(int idx, int d) {
			this.idx = idx;
			this.d = d;
		}
	}
}
