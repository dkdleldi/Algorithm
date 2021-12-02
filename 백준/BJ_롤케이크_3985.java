package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_롤케이크_3985 {

	static int L, N, exp, expMax, real, realMax;
	static int[] num;
	static int[] count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		num = new int[L+1];
		count = new int[N+1];
		expMax = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int small = Integer.parseInt(st.nextToken());
			int big = Integer.parseInt(st.nextToken());
			if(expMax < (big-small)) {
				expMax = Math.max(exp, big-small);
				exp = i;
			}
			for (int j = small; j <= big; j++) {
				if(num[j] == 0) num[j] = i;
			}
		}
		System.out.println(exp);
		for (int i = 1; i <= L; i++) {
			count[num[i]]++;			
		}
		for (int i = 1; i <= N; i++) {
			if(realMax < count[i]) {
				realMax = Math.max(realMax, count[i]);
				real = i;
			}			
		}
		System.out.println(real);
	}
}
