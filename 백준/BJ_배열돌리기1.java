package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_배열돌리기1 {
	static int N, M, R;
	static int[][] array;
	static int dx, dy;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rotate(0, M-1, 0, N-1);		
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void rotate(int x_min, int x_max, int y_min, int y_max) {
		if( x_min >= x_max || y_min >= y_max ) return;
		
		for (int i = 0; i < R; i++) {
			dy = y_min;
			dx = x_min;
			int temp = array[dy][dx];
			while(true) {
				array[dy][dx] = array[dy][dx+1];
				dx++;
				if(dx == x_max) break;
			}
			while(true) {
				array[dy][dx] = array[dy+1][dx];
				dy++;
				if(dy == y_max) break;
			}
			while(true) {
				array[dy][dx] = array[dy][dx-1];
				dx--;
				if(dx == x_min) break;
			}
			while(true) {
				array[dy][dx] = array[dy-1][dx];
				dy--;
				if(dy == y_min) break;
			}
			array[y_min+1][x_min] = temp;
		}
		rotate(x_min+1, x_max-1, y_min+1, y_max-1);		
	}
}
