package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_줄세우기_2252 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> student;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N+1];
		student = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= N; i++) {
			student.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int taller = Integer.parseInt(st.nextToken());
			int smaller = Integer.parseInt(st.nextToken());
			student.get(smaller).add(taller);
		}
		for (int i = 1; i <= N; i++) {
			if(visit[i] || student.get(i).isEmpty()) continue;			
			dfs(i);
		}
		for (int i = 1; i < N; i++) {
			if(!visit[i]) System.out.print(i + " ");
		}
	}
	
	static void dfs(int num) {
		visit[num] = true;
		if(student.get(num).isEmpty()) {
			System.out.print(num + " ");
			return;
		}
		for (int i = 0; i < student.get(num).size(); i++) {
			int n = student.get(num).get(i);
			if(!visit[n]) dfs(n);
		}
		System.out.print(num + " ");
	}
}
