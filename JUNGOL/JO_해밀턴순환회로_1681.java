import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_해밀턴순환회로_1681 {

	static int N, min;
	static int[][] cost;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		visit = new boolean[N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);		
		System.out.println(min);
	}
	
	static void dfs(int cnt, int dest, int c) {
		if(cnt != 0 && cnt < N && dest == 0) return;
		if(c > min) return;
		if(cnt == N) {
			min = c;
			return;
		}
		for (int i = 0; i < N; i++) {
			if(i == dest || visit[i] || cost[dest][i] == 0) continue;
			visit[i] = true;
			dfs(cnt+1, i, c+cost[dest][i]);
			visit[i] = false;
		}
	}
}
