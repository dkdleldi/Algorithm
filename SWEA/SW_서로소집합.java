package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_서로소집합 {

	static int T, n, m;
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			make();
			System.out.print("#" + t + " ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int cal = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(cal == 0) union(a, b);
				else {
					if(find(a) == find(b)) System.out.print(1);
					else System.out.print(0);
				}
			}
			System.out.println();
		}
	}
	
	static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int num) {
		if(parents[num] == num) return num;
		return parents[num] = find(parents[num]);
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if( aRoot < bRoot ) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
	}
}
