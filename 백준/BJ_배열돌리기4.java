package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_배열돌리기4 {
	static int N, M, K;
	static int r, c, s;
	static int[][] array, backup;
	static int[][] rotate;
	static int ans, dx, dy;
	static int[] tgt;
 	static boolean[] select;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		backup = new int[N][M];		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				array[i][j] = num;
				backup[i][j] = num;
			}
		}
		
		rotate = new int[K][3];
		select = new boolean[K];
		tgt = new int[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rotate[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE;
		perm(0);
		System.out.println(ans);
	}
	static void original() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				array[i][j] = backup[i][j];
			}
		}
	}
	static void min() {
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += array[i][j];
			}
			ans = Math.min(ans, sum);
		}
	}
	static void perm(int tgtIdx) {
		if(tgtIdx == K) {
			for (int i = 0; i < K; i++) {
				int idx = tgt[i];
				int r = rotate[idx][0];
				int c = rotate[idx][1];
				int s = rotate[idx][2];
				rotate(c-s-1, c+s-1, r-s-1, r+s-1);	
			}
			min();
			original();
			return;
		}
		for (int i = 0; i < K; i++) {
			if(select[i]) continue;
			tgt[tgtIdx] = i;
			select[i] = true;
			perm(tgtIdx + 1);
			select[i] = false;
		}
		
	}

	static void rotate(int x_min, int x_max, int y_min, int y_max) {
		if( x_min >= x_max || y_min >= y_max ) return;
		dy = y_min;
		dx = x_min;
		int temp = array[dy][dx];
		while(true) {
			array[dy][dx] = array[dy+1][dx];
			dy++;
			if(dy == y_max) break;
		}
		while(true) {
			array[dy][dx] = array[dy][dx+1];
			dx++;
			if(dx == x_max) break;
		}
		while(true) {
			array[dy][dx] = array[dy-1][dx];
			dy--;
			if(dy == y_min) break;
		}
		while(true) {
			array[dy][dx] = array[dy][dx-1];
			dx--;
			if(dx == x_min) break;
		}
		
		array[y_min][x_min+1] = temp;
		rotate(x_min+1, x_max-1, y_min+1, y_max-1);		
	}
}
