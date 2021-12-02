package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SW_하나로_K {

	static int T, N;
	static long min;
	static int[][] island;
	static ArrayList<Cost> cost;
	static int[] parent;
	static double E, costSum;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1251_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			island = new int[N][2];
			parent = new int[N];
			cost = new ArrayList<Cost>();
			min = 0;
			costSum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				island[i][0] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				island[i][1] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					if(i == j) continue;
					double c = E * ((long)Math.pow(island[i][0] - island[j][0], 2) + (long)Math.pow(island[i][1] - island[j][1], 2));
					cost.add(new Cost(i, j, c));
				}
			}
			
			makeSet();
			Collections.sort(cost);
			int cnt = 0;
			int index = 0;
			while(true) {
				Cost c = cost.get(index++);
				if(findSet(c.n1) != findSet(c.n2)) {
					union(c.n1, c.n2);
					costSum += c.length;
					cnt++;
				}
				if(cnt == N-1) break;
			}
			min = Math.round(costSum);
			System.out.println("#" + t + " " + min);

		}

	}
	static class Cost implements Comparable<Cost> {
		int n1;
		int n2;
		double length;
		public Cost(int n1, int n2, double length) {
			this.n1 = n1;
			this.n2 = n2;
			this.length = length;
		}
		@Override
		public int compareTo(Cost o) {
			if(this.length < o.length) return -1;
			else if(this.length > o.length) return 1;
			else return 0;
		}		
	}
	
	static void makeSet() {
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int num) {
		if(parent[num] == num) return num;
		else return parent[num] = findSet(parent[num]);
	}
	
	static void union(int a, int b) {
		int pa = parent[a];
		int pb = parent[b];
		if(pa < pb) parent[pb] = pa;
		else parent[pa] = pb;
	}

}
