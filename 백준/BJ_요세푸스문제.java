package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_요세푸스문제 {
	static int N, K;
	static Queue<Integer> num = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			num.add(i);
		}		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int temp = 0;
		while(true) {
			if(num.isEmpty()) break;
			for(int i = 1; i < K; i++) {
				temp = num.poll();
				num.add(temp);
			}
			sb.append(num.poll() + ", ");
			
		}		
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}

}
