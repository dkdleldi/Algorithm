package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_세수_10817 {

	static int[] num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[3];
		num[0] = Integer.parseInt(st.nextToken());
		num[1] = Integer.parseInt(st.nextToken());
		num[2] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(num);
		System.out.println(num[1]);
	}
}
