import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_회전초밥_2577 {

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
		for (int i = 1; i <= d; i++) {
			if(eat[i] > 0) num++;
		}
		max = num;
		for (int i = 0; i < N-1; i++) {
			if(max <= num) {
				if(eat[c] == 0) max = num+1;
				else max = num;
			}
			int idx = i+k;
			if(idx >= N) {
				idx -= N;
			}
			eat[sushi[i]]--;
			if(eat[sushi[i]] == 0) num--;
			
			if(eat[sushi[idx]] == 0) num++;
			eat[sushi[idx]]++;
		}
		System.out.println(max);
	}
}
