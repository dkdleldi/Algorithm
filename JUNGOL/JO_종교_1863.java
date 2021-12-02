import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_종교_1863 {

	static int n, m, ans;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		makeSet();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(findSet(x) != findSet(y)) union(x, y);
		}	
		for (int i = 1; i <= n; i++) {
			if(parent[i] == i) ans++;
		}
		System.out.println(ans);
	}
	static void makeSet() {
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	static int findSet(int num) {
		if(parent[num] == num) return num;
		return parent[num] = findSet(parent[num]);
	}
	static void union(int x, int y) {
		int px = parent[x];
		int py = parent[y];
		if(px < py) parent[py] = px;
		else parent[px] = py;
	}

}
