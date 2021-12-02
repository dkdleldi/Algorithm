package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_최소비용구하기_1916 {

	static int N, M, start, end;
	static ArrayList<ArrayList<Edge>> bus;
	static int[] min;
	static boolean[] visit;
	static PriorityQueue<Edge> pqueue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		bus = new ArrayList<ArrayList<Edge>>();
		min = new int[N+1];
		visit = new boolean[N+1];
		for (int i = 0; i <= N; i++) {
			bus.add(new ArrayList<Edge>());
		}
		Arrays.fill(min, 1000*100000*2);
		pqueue = new PriorityQueue<>((v1, v2) -> v1.d - v2.d);
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			bus.get(start).add(new Edge(dest, cost));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		min[start] = 0;
		pqueue.offer(new Edge(start, 0));
		
		while(!pqueue.isEmpty()) {
			Edge e = pqueue.poll();
			if(visit[e.v]) continue;
			for (int i = 0; i < bus.get(e.v).size(); i++) {
				Edge b = bus.get(e.v).get(i);
				if(min[b.v] > min[e.v] + b.d) {
					min[b.v] = min[e.v] + b.d;
					pqueue.offer(new Edge(b.v, min[b.v]));
				}
			}
			visit[e.v] = true;
		}
		System.out.println(min[end]);	
	}
	
	static class Edge {
		int v, d;
		public Edge(int v, int d) {
			this.v = v;
			this.d = d;
		}
	}
}
