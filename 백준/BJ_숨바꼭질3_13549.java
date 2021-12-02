package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_숨바꼭질3_13549 {

	static int N, K, min;
	static Queue<Node> queue;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		queue = new LinkedList<>();
		visit = new boolean[100001];
		min = Integer.MAX_VALUE;
		queue.offer(new Node(N, 0));
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			visit[n.n] = true;
			if(n.s > min) continue;
			if(n.n == K) {
				if(n.s < min) min = n.s;
				continue;
			}
			if(n.n+1 <= 100000 && !visit[n.n+1]) {
				queue.offer(new Node(n.n+1, n.s+1));
			}
			if(n.n-1 >= 0 && !visit[n.n-1]) {
				queue.offer(new Node(n.n-1, n.s+1));
			}
			if(n.n*2 <= 100000 && !visit[n.n*2]) {
				queue.offer(new Node(n.n*2, n.s));
			}
		}
		System.out.println(min);
	}

	static class Node {
		int n, s;
		public Node(int n, int s) {
			this.n = n;
			this.s = s;
		}
	}
}
