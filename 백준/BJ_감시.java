package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_감시 {

	static int N, M, min;
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static ArrayList<int[]> cctv = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 3 || map[i][j] == 4 || map[i][j] == 5) cctv.add(new int[]{i, j, map[i][j]});
			}
		}
		min = Integer.MAX_VALUE;
		cctv(0, map);
		System.out.println(min);
	}
	// cctv가 하나도 없을 때에 처리를 잘못해주어서 오류가 났다!!
	static void cctv(int idx, int[][] arr) {
		if(idx == cctv.size()) {
			calMin(arr);
			return;
		}
		int num = cctv.get(idx)[2];
		int y = cctv.get(idx)[0];
		int x = cctv.get(idx)[1];
		switch (num) {
		case 1:
			for (int j = 0; j < 4; j++) {
				int[][] temp = copy(arr);
				temp = range(y, x, j, temp);
				cctv(idx+1, temp);
			}
			break;
		case 2:
			for (int j = 0; j < 2; j ++) {
				int[][] temp = copy(arr);
				temp = range(y, x, j, temp);
				temp = range(y, x, j+2, temp);
				cctv(idx+1, temp);
			}
			break;
		case 3:
			for (int j = 0; j < 4; j++) { 
				int[][] temp = copy(arr);
				temp = range(y, x, j, temp);
				temp = range(y, x, (j+1)%4, temp);
				cctv(idx+1, temp);
			}
			break;
		case 4:
			for (int j = 0; j < 4; j++) {
				int[][] temp = copy(arr);
				temp = range(y, x, j, temp);
				temp = range(y, x, (j+1)%4, temp);
				temp = range(y, x, (j+3)%4, temp);
				cctv(idx+1, temp);
			}
			break;
		case 5:
			int[][] temp = copy(arr);
			temp = range(y, x, 0, temp);
			temp = range(y, x, 1, temp);
			temp = range(y, x, 2, temp);
			temp = range(y, x, 3, temp);
			cctv(idx+1, temp);
			break;
		}
	}
	
	static int[][] range(int y, int x, int dir, int[][] arr) {
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		while(true) {
			if(ny < 0 || nx < 0 || ny >= N || nx >= M || arr[ny][nx] == 6) break;
			arr[ny][nx] = 9;
			ny += dy[dir];
			nx += dx[dir];
		}
		return arr;
	}
	
	static void calMin(int[][] arr) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) cnt++;
			}
		}
		min = Math.min(min, cnt);
	}
	
	static int[][] copy(int[][] origin) {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = origin[i][j];
			}
		}
		return temp;
	}
}
