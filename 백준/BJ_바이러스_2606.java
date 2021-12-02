package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_바이러스_2606 {

	static int cNum, eNum, num;
	static ArrayList<ArrayList<Integer>> computer;
	static boolean[] visit;
	static Queue<Integer> queue;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cNum = Integer.parseInt(br.readLine());
		eNum = Integer.parseInt(br.readLine());
		computer = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= cNum; i++) {
			computer.add(new ArrayList<Integer>());
		}
		queue = new LinkedList<Integer>();
		visit = new boolean[cNum+1];
		StringTokenizer st = null;
		for (int i = 0; i < eNum; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			computer.get(n1).add(n2);
			computer.get(n2).add(n1);
		}
		bfs();
		System.out.println(num);
	}

	static void bfs() {
		queue.offer(1);
		visit[1] = true;
		while(!queue.isEmpty()) {
			int n = queue.poll();
			for (int i = 0; i < computer.get(n).size(); i++) {
				int idx = computer.get(n).get(i);
				if(visit[idx]) continue;
				queue.offer(idx);
				visit[idx] = true;
				num++;
			}
		}
	}
}
