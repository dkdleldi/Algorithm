package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_무선충전 {
	static int T, M, A, ans, sumA, sumB;
	static int[] userA, userB;
	static int aX, aY, bX, bY;
	static BC[] bc;
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_5644_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			bc = new BC[A];
			userA = new int[M];
			userB = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				userA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				userB[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bc[i] = new BC(x, y, c, p);
			}
			aX = 1;
			aY = 1;
			bX = 10;
			bY = 10;
			charge();
			for (int i = 0; i < M; i++) {
				aX += dx[userA[i]];
				aY += dy[userA[i]];
				bX += dx[userB[i]];
				bY += dy[userB[i]];
				charge();
			}
			System.out.println("#" + t + " " + ans);
			ans = 0;
		}

	}
	static void charge() {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < A; i++) {
			int numA = 0;
			if(Math.abs(bc[i].y - aY) + Math.abs(bc[i].x - aX) <= bc[i].c) {
				numA = bc[i].p;
			}
			for (int j = 0; j < A; j++) {
				int numB = 0;
				if(Math.abs(bc[j].y - bY) + Math.abs(bc[j].x - bX) <= bc[j].c) {
					numB = bc[j].p;
				}
				if(i != j) sum = numA + numB;
				else sum = Math.max(numA, numB);
				max = Math.max(sum, max);
			}
		}
		ans += max;
	}
	static class BC {
		int x;
		int y;
		int c;
		int p;
		public BC(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
}
