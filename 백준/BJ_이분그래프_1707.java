package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_이분그래프_1707 {

	static int T, V, E;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] vertex;
	static boolean[] visit;
	static boolean p;
	static Queue<Vertex> queue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			visit = new boolean[V+1];
			vertex = new boolean[V+1];
			list = new ArrayList<ArrayList<Integer>>();
			queue = new LinkedList<>();
			for (int i = 0; i <= V; i++) {
				list.add(new ArrayList<Integer>());
			}
			p = true;
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				list.get(v1).add(v2);
				list.get(v2).add(v1);
			}
			for (int i = 1; i <= V; i++) {
				if(visit[i]) continue;
				bfs(i);
				if(!p) break;
			}
			if(p) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	static void bfs(int num) {
		queue.offer(new Vertex(num, true));
		visit[num] = true;
		vertex[num] = true;
		while(!queue.isEmpty()) {
			Vertex v = queue.poll();
			for (int i = 0; i < list.get(v.v).size(); i++) {
				int n = list.get(v.v).get(i);
				if(!visit[n]) {
					queue.offer(new Vertex(n, !v.c));
					visit[n] = true;
					vertex[n] = !v.c;
				}
				else {
					if(vertex[n] == v.c) {
						p = false;
						return;
					}
				}
			}
		}
	}
	static class Vertex {
		int v;
		boolean c;
		public Vertex(int v, boolean c) {
			this.v = v;
			this.c = c;
		}
	}
}