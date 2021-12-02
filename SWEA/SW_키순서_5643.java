import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_키순서_5643 {

	static int T, N, M, ans;
	static ArrayList<ArrayList<Integer>> big;
	static ArrayList<ArrayList<Integer>> small;
	static int[] cnt;
	static boolean[] visit;
	static int bigger, smaller;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			big = new ArrayList<ArrayList<Integer>>();
			small = new ArrayList<ArrayList<Integer>>();
			cnt = new int[N+1];
			visit = new boolean[N+1];
			ans = 0;
			for (int i = 0; i <= N; i++) {
				big.add(new ArrayList<Integer>());
				small.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				big.get(a).add(b);
				small.get(b).add(a);
			}
			for (int i = 1; i <= N; i++) {
				Arrays.fill(visit, false);
				visit[i] = true;
				bigger = smaller = 0;
				bigDfs(i);
				smallDfs(i);
				cnt[i] = bigger + smaller;
				if(cnt[i] == N-1) ans++;
			}		
			System.out.println("#" + t + " " + ans);
		}
	}

	static void bigDfs(int v) {
		if(big.get(v).size() == 0) return;
		else {
			for (int i = 0; i < big.get(v).size(); i++) {
				int n = big.get(v).get(i);
				if(visit[n]) continue;
				visit[n] = true;
				bigger++;
				bigDfs(n);
			}
		}	
	}
	
	static void smallDfs(int v) {
		if(small.get(v).size() == 0) return;
		else {
			for (int i = 0; i < small.get(v).size(); i++) {
				int n = small.get(v).get(i);
				if(visit[n]) continue;
				visit[n] = true;
				smaller++;
				smallDfs(n);
			}
		}
	}
}
