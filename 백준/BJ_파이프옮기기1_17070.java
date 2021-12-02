package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_파이프옮기기1_17070 {

	static int N, ans;
	static int[][] house;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		house = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move(0, 1, 1);
		System.out.println(ans);		
	}
	
	static void move(int y, int x, int dir) {
		if(y == N-1 && x == N-1) {
			ans++;
			return;
		}
		int ny = y+1;
		int nx = x+1;
		
		switch (dir) {
		case 1:
			if(nx < N && house[y][nx] != 1) {
				move(y, nx, 1);
			}
			if(ny < N && nx < N && house[ny][nx] != 1 && house[y][nx] != 1 && house[ny][x] != 1) {
				move(ny, nx, 3);
			}
			break;
		case 2:
			if(ny < N && house[ny][x] != 1) {
				move(ny, x, 2);
			}
			if(ny < N && nx < N && house[ny][nx] != 1 && house[y][nx] != 1 && house[ny][x] != 1) {
				move(ny, nx, 3);
			}
			break;
		case 3:
			if(nx < N && house[y][nx] != 1) {
				move(y, nx, 1);
			}
			if(ny < N && house[ny][x] != 1) {
				move(ny, x, 2);
			}
			if(ny < N && nx < N && house[ny][nx] != 1 && house[y][nx] != 1 && house[ny][x] != 1) {
				move(ny, nx, 3);
			}
			break;
		}
	}
}
