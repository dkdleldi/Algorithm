package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_특이한자석 {

	static int T, K, ans;
	static int[][] magnet;
	static Queue<Magnet> queue = new LinkedList<Magnet>();
	static Queue<Magnet> queueR = new LinkedList<Magnet>();
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			magnet = new int[5][8];
			StringTokenizer st;
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visit = new boolean[5];
			for (int i = 0; i < K; i++) {
				Arrays.fill(visit, false);
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				queue.offer(new Magnet(n, d));
				queueR.offer(new Magnet(n, d));
				rotate();
			}
			ans = 0;
			for (int i = 1; i <= 4; i++) {
				if(magnet[i][0] == 1) ans += (int)Math.pow(2, i-1);
			}		
			System.out.println("#" + t + " " + ans);
		}
	}
	
	static void rotate() {
		while(!queue.isEmpty()) {
			Magnet m = queue.poll();
			visit[m.n] = true;
			if(m.n <= 3 && !visit[m.n+1] && magnet[m.n][2] != magnet[m.n+1][6]) {
				queue.offer(new Magnet(m.n+1, -m.d));
				queueR.offer(new Magnet(m.n+1, -m.d));
			}
			if(m.n >= 2 && !visit[m.n-1] && magnet[m.n][6] != magnet[m.n-1][2]) {
				queue.offer(new Magnet(m.n-1, -m.d));
				queueR.offer(new Magnet(m.n-1, -m.d));
			}
		}
		while(!queueR.isEmpty()) {
			Magnet m = queueR.poll();
			magnet[m.n] = copy(magnet[m.n], m.d);
		}
	}

	static int[] copy(int[] origin, int dir) {
		int[] temp = new int[8];
		for (int i = 1; i < 7; i++) {
			temp[i+dir] = origin[i];
		}
		if(dir == 1) {
			temp[0] = origin[7];
			temp[1] = origin[0];
		}
		else {
			temp[6] = origin[7];
			temp[7] = origin[0];
		}
		return temp;
	}
	
	static class Magnet {
		int n;
		int d;
		public Magnet(int n, int d) {
			this.n = n;
			this.d = d;
		}
	}
}
