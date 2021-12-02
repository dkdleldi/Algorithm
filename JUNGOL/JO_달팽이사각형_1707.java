package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO_달팽이사각형_1707 {

	static int n;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int ny = 0;
		int nx = 0;
		int num = 1;
		int[][] square = new int[n][n];
		square[ny][nx] = num++;
		int idx = 0;
		while(true) {
			if(num > n*n) break;
			while(true) {
				int tempY = ny + dy[idx];
				int tempX = nx + dx[idx];
				if(tempY < 0 || tempX < 0 || tempY >= n || tempX >= n || square[tempY][tempX] != 0) break;
				ny += dy[idx];
				nx += dx[idx];
				square[ny][nx] = num++;
			}
			if(idx == 3) idx = 0;
			else idx++;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(square[i][j] + " ");
			}
			System.out.println();
		}
	}
}
