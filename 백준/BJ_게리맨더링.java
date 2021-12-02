package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_게리맨더링 {

	static int N, min;
	static int[] popul;
	static boolean[][] con;
	static boolean[] include;
	static ArrayList<Integer> dist1 = new ArrayList<Integer>();
	static ArrayList<Integer> dist2 = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		popul = new int[N+1];
		con = new boolean[N+1][N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int idx = Integer.parseInt(st.nextToken());
				con[i][idx] = true;
			}
		}
		include = new boolean[N+1];
		min = Integer.MAX_VALUE;
		subset(1);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	static void subset(int idx) {
		if(idx == N+1) {
			dist1.clear();
			dist2.clear();
			for (int i = 1; i <= N; i++) {
				if(include[i]) dist1.add(i);
				else dist2.add(i);
			}
			if(dist1.isEmpty() || dist2.isEmpty()) return;
			if(bfs()) {
				int dist1Popul = 0;
				int dist2Popul = 0;
				for (int i = 0; i < dist1.size(); i++) {
					dist1Popul += popul[dist1.get(i)];
				}
				for (int i = 0; i < dist2.size(); i++) {
					dist2Popul += popul[dist2.get(i)];
				}
				min = Math.min(Math.abs(dist1Popul - dist2Popul), min);
			}
			return;
		}
		include[idx] = true;
		subset(idx+1);
		include[idx] = false;
		subset(idx+1);
	}

	static boolean bfs() {
		boolean isCon = true;
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[N+1];
		queue.offer(dist1.get(0));
		while(!queue.isEmpty()) {
			int num = queue.poll();
			visit[num] = true;
			for (int i = 1; i <= N; i++) {
				if(!visit[i] && include[i] && con[num][i]) queue.offer(i);
			}
		}
		queue.offer(dist2.get(0));
		while(!queue.isEmpty()) {
			int num = queue.poll();
			visit[num] = true;
			for (int i = 1; i <= N; i++) {
				if(!visit[i] && !include[i] && con[num][i]) queue.offer(i);
			}
		}
		for (int i = 1; i <= N; i++) {
			if(!visit[i]) isCon = false;
		}
		if(!isCon) return false;
		else return true;
	}
}
