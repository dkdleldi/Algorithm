package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_연산자끼워넣기_14888 {

	static int N;
	static int[] A;
	static int[] op = new int[4];
	static long min = Integer.MAX_VALUE;
	static long max = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		op[0] = Integer.parseInt(st.nextToken());
		op[1] = Integer.parseInt(st.nextToken());
		op[2] = Integer.parseInt(st.nextToken());
		op[3] = Integer.parseInt(st.nextToken());
		cal(op[0], op[1], op[2], op[3], A[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	static void cal(int plus, int minus, int mul, int div, long num, int cnt) {
		if(cnt == N) {
			min = Math.min(min, num);
			max = Math.max(max, num);
			return;
		}
		if(plus > 0) cal(plus-1, minus, mul, div, num+A[cnt], cnt+1);
		if(minus > 0) cal(plus, minus-1, mul, div, num-A[cnt], cnt+1);
		if(mul > 0) cal(plus, minus, mul-1, div, num*A[cnt], cnt+1);
		if(div > 0) cal(plus, minus, mul, div-1, num/A[cnt], cnt+1);
	}
}
