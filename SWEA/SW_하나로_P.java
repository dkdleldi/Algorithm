package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW_하나로_P {

	static int T, N;
	static long min;
	static int[][] island;
	static ArrayList<ArrayList<Cost>> cost;
	static double E, costSum;
	static boolean[] visit;
	static PriorityQueue<Cost> queue = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1251_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			island = new int[N][2];
			visit = new boolean[N];
			cost = new ArrayList<ArrayList<Cost>>();
			for (int i = 0; i < N; i++) {
				cost.add(new ArrayList<Cost>());
			}
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
					cost.get(i).add(new Cost(j, c));
					cost.get(j).add(new Cost(i, c));
				}
			}
			int cnt = 0;
			visit[0] = true;
			queue.addAll(cost.get(0));
			while(!queue.isEmpty()) {
				Cost c = queue.poll();
				if(!visit[c.n]) {
					visit[c.n] = true;
					costSum += c.length;
					cnt++;
					queue.addAll(cost.get(c.n));
				}			
				if(cnt == N) break;
			}
			min = Math.round(costSum);
			System.out.println("#" + t + " " + min);

		}

	}
	static class Cost implements Comparable<Cost> {
		int n;
		double length;
		public Cost(int n, double length) {
			this.n = n;
			this.length = length;
		}
		@Override
		public int compareTo(Cost o) {
			if(this.length < o.length) return -1;
			else if(this.length > o.length) return 1;
			else return 0;
		}		
	}
}
