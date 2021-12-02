package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_최소스패닝트리_K {

	static int T, V, E;
	static long W;
	static int[] parent;
	static Edge[] edge;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parent = new int[V+1];
			edge = new Edge[E];
			W = 0;
			make();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edge[i] = new Edge(start, end, weight);
			}
			Arrays.sort(edge);
			int cnt = 0;
			for (int i = 0; i < E; i++) {
				if(find(edge[i].start) == find(edge[i].end)) continue;
				union(edge[i].start, edge[i].end);
				W += edge[i].weight;
				cnt++;
				if(cnt == V-1) break;
			}
			System.out.println("#" + t + " " + W);
		}
		

	}
	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	static void make() {
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}
	static int find(int num) {
		if(parent[num] == num) return num;
		return parent[num] = find(parent[num]);
	}
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px < py) parent[py] = px;
		else parent[px] = py;
	}
 
}
