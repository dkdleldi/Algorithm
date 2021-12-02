package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_최단경로 {

	static int V, E, K;
	static int[] min;
	static ArrayList<ArrayList<Node>> node;
	static boolean[] visit;
	static PriorityQueue<Node> queue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		node = new ArrayList<ArrayList<Node>>();
		queue = new PriorityQueue<Node>((n1, n2) -> n1.c - n2.c);
		min = new int[V+1];
		visit = new boolean[V+1];
		for (int i = 0; i <= V; i++) {
			node.add(new ArrayList<Node>());
			min[i] = Integer.MAX_VALUE;
		}		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			node.get(start).add(new Node(end, weight));
		}
		min[K] = 0;
		road(K);
		for (int i = 1; i <= V; i++) {
			System.out.println(visit[i] ? min[i] : "INF");
		}

	}
	
	static void road(int index) {
		queue.add(new Node(index, 0));		
		while(!queue.isEmpty()) {
			int num = queue.poll().n;
			if(visit[num]) continue;
			for (int i = 0; i < node.get(num).size(); i++) {
				Node n = node.get(num).get(i);		
				if(min[n.n] > min[num] + n.c) {
					min[n.n] = min[num] + n.c;
					queue.add(new Node(n.n, min[n.n]));
				}
			}
			visit[num] = true;
		}
	}
	
	static class Node {
		int n;
		int c;
		public Node(int n, int c) {
			this.n = n;
			this.c = c;
		}
	}
}
