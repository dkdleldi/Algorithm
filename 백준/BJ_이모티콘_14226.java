package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_이모티콘_14226 {

	static int S;
	static Queue<Node> queue;
	static boolean[] visit;
	static int[] minimum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		queue = new LinkedList<Node>();
		minimum = new int[1001];
		visit = new boolean[1001];
		Arrays.fill(minimum, 1000000);
		queue.offer(new Node(1, 0, 0));
		visit[1] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			if(minimum[n.emo] > n.sec) minimum[n.emo] = n.sec;
			if(n.emo == S) continue;
			if(n.emo != n.clip) {
				visit[n.emo] = true;
				queue.offer(new Node(n.emo, n.emo, n.sec+1));
			}
			// 어떤 점에 최적보다 더 늦게 도착해도 클립보드에 원소가 많다면 실제로는 그게 더 이득일 수도 있다
			if(n.clip != 0 && n.emo+n.clip <= 1000) {
				visit[n.emo+n.clip] = true;
				queue.offer(new Node(n.emo+n.clip, n.clip, n.sec+1));
			} 
			if(n.emo-1 >= 1 && !visit[n.emo-1] && minimum[n.emo-1] > n.sec+1) {
				visit[n.emo-1] = true;
				queue.offer(new Node(n.emo-1, n.clip, n.sec+1));
			}
		}
		System.out.println(minimum[S]);
	}
	
	static class Node {
		int emo;
		int clip;
		int sec;
		public Node(int emo, int clip, int sec) {
			this.emo = emo;
			this.clip = clip;
			this.sec = sec;
		}
	}
}
