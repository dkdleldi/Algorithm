package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_DFS와BFS {

	static int N, M, V;
	static boolean[] visit;
	static Queue<Integer> bfsQueue = new LinkedList<>();
	static List<int[]> vertex = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			vertex.add(new int[] {v1, v2});
			vertex.add(new int[] {v2, v1});
		}
		Collections.sort(vertex, (v1, v2) -> v1[1] - v2[1]);
		dfs(V);
		System.out.println();
		Arrays.fill(visit, false);
		visit[V] = true;
		bfs();		
	}

	static void dfs(int num) {
		if(visit[num]) return;
		
		visit[num] = true;
		System.out.print(num + " ");
		for (int i = 0; i < M*2; i++) {
			if(vertex.get(i)[0] == num) dfs(vertex.get(i)[1]);
		}
	}
	
	static void bfs() {
		bfsQueue.add(V);
		while(!bfsQueue.isEmpty()) {
			int num = bfsQueue.poll();
			System.out.print(num + " ");
			for (int i = 0; i < M*2; i++) {
				if(vertex.get(i)[0] == num && !visit[vertex.get(i)[1]]) {
					bfsQueue.add(vertex.get(i)[1]);
					visit[vertex.get(i)[1]] = true;
				}
			}
		}
	}
}
