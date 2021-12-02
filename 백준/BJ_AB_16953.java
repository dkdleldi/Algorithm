package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_AB_16953 {

	static long A, B;
	static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		min = Integer.MAX_VALUE;
		calc(A, 1);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void calc(long a, int num) {
		if(num > min) return;
		if(a == B) {
			min = Math.min(min, num);
		}
		if(a > B) return;
		calc(a*2, num+1);
		String aString = Long.toString(a);
		calc(Long.parseLong(aString + "1"), num+1);
	}
}
