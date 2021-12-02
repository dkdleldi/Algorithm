package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_쉽게푸는문제_1292 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int last = Integer.parseInt(st.nextToken());
		int[] num = new int[last+1];
		num[0] = 0;
		int idx = 1;
		int n = 0;
		while(true) {
			if(idx > last) break;
			for (int i = 0; i < n; i++) {
				if(idx <= last) num[idx++] = n;
			}
			n++;
		}
		int sum = 0;
		for (int i = first; i <= last; i++) {
			sum += num[i];
		}
		System.out.println(sum);
	}
}
