package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_약수구하기_2501 {

	static int N, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int ans = 0;
		ArrayList<Integer> num = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			if(N % i == 0) num.add(i);
		}
		if(K <= num.size()) ans = num.get(K-1);
		System.out.println(ans);
	}
}
