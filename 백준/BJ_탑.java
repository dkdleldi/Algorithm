package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_탑 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static Stack<int[]> top = new Stack<int[]>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = 0;

		for (int i = 1; i <= N; i++) {
			num = Integer.parseInt(st.nextToken());
			
			while( !top.isEmpty() ) {
				if(top.peek()[1] >= num) {
					sb.append(top.peek()[0] + " ");
					break;
				}
				top.pop();
			}
			if( top.isEmpty() ) sb.append(0 + " ");
			top.push(new int[] {i, num});
		}
		
		System.out.println(sb.toString().trim());
	}
}
