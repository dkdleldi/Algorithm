package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_최소스패닝트리_P {

	static int T, V, E;
	static long W;
	static boolean[] visit;
	static ArrayList<ArrayList<Edge>> edge;
	static PriorityQueue<Edge> queue = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			W = 0;
			edge = new ArrayList<>();
			visit = new boolean[V+1];
			for (int i = 0; i <= V; i++) {
				edge.add(new ArrayList<Edge>());
			}
						
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				edge.get(v1).add(new Edge(v2, weight));
				edge.get(v2).add(new Edge(v1, weight));
			}
			queue.clear();
			int cnt = 1;
			visit[1] = true;
			queue.addAll(edge.get(1));
			while(true) {
				Edge e = queue.poll();
				if(visit[e.vertex]) continue;
				visit[e.vertex] = true;
				queue.addAll(edge.get(e.vertex));
				W += e.weight;
				cnt++;
				if(cnt == V) break;
			}
			System.out.println("#" + t + " " + W);
		}
		

	}
	static class Edge implements Comparable<Edge>{
		int vertex, weight;

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}	
	}
}
