package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_부분합_1806 {

	static int N, S, min, sum, cnt, idx;
	static int[] num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			plus(i);
		}
		if(min == Integer.MAX_VALUE) {
			System.out.println(0);
			return;
		}
		System.out.println(min);
	}
	
	static void plus(int index) {
		int s = 0;
		int c = 0;
		int i = 0;
		if(index < idx) {
			s = sum - num[index-1];
			c = cnt-1;
			i = idx+1;
		}
		else {
			s = num[index];
			c = 1;
			i = index+1;
		}
		while(true) {
			if(s >= S) {
				min = Math.min(min, c);
				break;
			}
			if(i >= N || c > min) break;
			s += num[i++];
			c++;
		}
		sum = s;
		cnt = c;
		idx = i-1;
	}
}
