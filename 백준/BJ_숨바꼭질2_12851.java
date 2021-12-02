package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_숨바꼭질2_12851 {

	static int N, K, min, cnt;
	static Queue<Node> queue;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		queue = new LinkedList<Node>();
		visit = new boolean[100001];
		min = Integer.MAX_VALUE;
		cnt = 1;
		queue.offer(new Node(N, 0));
		bfs();
		System.out.println(min);
		System.out.println(cnt);
	}

	static void bfs() {
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			visit[n.n] = true;
			if(n.s > min) continue;
			if(n.n == K) {
				if(min > n.s) {
					min = n.s;
					cnt = 1;
				}
				else if(min == n.s) {
					cnt++;
				}
				continue;
			}
			if(n.n+1 <= 100000 && !visit[n.n+1]) {
				queue.offer(new Node(n.n+1, n.s+1));
			}
			if(n.n-1 >= 0 && !visit[n.n-1]) {
				queue.offer(new Node(n.n-1, n.s+1));
			}
			if(n.n*2 <= 100000 && !visit[n.n*2]) {
				queue.offer(new Node(n.n*2, n.s+1));
			}
		}
	}
	
	static class Node {
		int n;
		int s;
		public Node(int n, int s) {
			this.n = n;
			this.s = s;
		}
	}
}
