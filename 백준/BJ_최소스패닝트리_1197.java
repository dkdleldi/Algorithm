package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_최소스패닝트리_1197 {

	static int V, E, ans;
	static int[] parent;
	static PriorityQueue<Edge> pqueue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parent = new int[V+1];
		pqueue = new PriorityQueue<Edge>((v1, v2) -> v1.d - v2.d);
		makeSet();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			pqueue.offer(new Edge(A, B, C));
		}
		
		int cnt = 0;
		while( !pqueue.isEmpty() ) {
			if(cnt == V-1) break;
			Edge e = pqueue.poll();
			if(findSet(e.v1) == findSet(e.v2)) continue;
			union(e.v1, e.v2);
			ans += e.d;
			cnt++;			
		}
		
		System.out.println(ans);
	}
	
	static void makeSet() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int n) {
		if(n == parent[n]) return parent[n];
		else return parent[n] = findSet(parent[n]);
	}
	
	static void union(int x, int y) {
		int px = parent[x];
		int py = parent[y];
		if(py > px) parent[py] = px;
		else parent[px] = py;
	}
	
	static class Edge {
		int v1;
		int v2;
		int d;
		public Edge(int v1, int v2, int d) {
			this.v1 = v1;
			this.v2 = v2;
			this.d = d;
		}
	}
}
