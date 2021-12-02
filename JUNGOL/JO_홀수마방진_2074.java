package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO_홀수마방진_2074 {

	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int num = 1;
		int dy = -1;
		int dx = -1;
		int[][] square = new int[n][n];
		int ny = 0;
		int nx = n/2;
		square[ny][nx] = num;		
		while(true) {
			if(num >= n*n) break;
			if(num % n == 0) {
				ny += 1;
				if(ny >= n) ny = 0;
			}
			else {
				ny += dy;
				nx += dx;
				if(ny < 0) ny = n-1;
				if(nx < 0) nx = n-1;
			}
			square[ny][nx] = ++num;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(square[i][j] + " ");
			}
			System.out.println();
		}
	}
}
