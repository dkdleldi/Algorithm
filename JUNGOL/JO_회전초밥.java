package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_회전초밥 {

	static int N, d, k, c, max;
	static int[] sushi, eat;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[N];
		eat = new int[d+1];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
			if(i < k) eat[sushi[i]]++;
		}
		int num = 0;
		eat[c]++;
		for (int i = 1; i <= d; i++) {
			if(eat[i] > 0) num++;
		}
		max = num;
		for (int i = 0; i < N-1; i++) {
			if(max==k+1) break;
			int idx = i+k;
			if(idx >= N) {
				idx -= N;
			}
			eat[sushi[i]]--;
			if(eat[sushi[i]] == 0) num--;		
			if(eat[sushi[idx]] == 0) num++;
			eat[sushi[idx]]++;
			
//			if(eat[sushi[i]] == 1) num--;		
//			if(eat[sushi[idx]] == 0) num++;
//			eat[sushi[i]]--;
//			eat[sushi[idx]]++;
//			i == idx일 때 문제가 발생한다!!
			
			max = Math.max(max, num);
		}
		System.out.println(max);
	}
}
