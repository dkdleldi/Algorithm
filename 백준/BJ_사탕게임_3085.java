package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_사탕게임_3085 {

	static int N, max;
	static char[][] candy;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		candy = new char[N][];
		for (int i = 0; i < N; i++) {
			candy[i] = br.readLine().toCharArray();
		}
		max = 0;	
		eat();	
		if(max != N) move();
		System.out.println(max);
	}
	
	static void move() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				if(candy[i][j] == candy[i][j+1]) continue;
				rowSwap(i, j);
				eat();
				rowSwap(i, j);
			}
		}
		if(max == N) return;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				if(candy[j][i] == candy[j+1][i]) continue;
				colSwap(i, j);
				eat();
				colSwap(i, j);
			}
		}
		if(max == N) return;
	}
	
	static void eat() {
		for (int i = 0; i < N; i++) {
			char rowC = candy[i][0];
			char colC = candy[0][i];
			int rowCnt = 1;
			int colCnt = 1;
			for (int j = 1; j < N; j++) {
				if(candy[i][j] == rowC) rowCnt++;
				else {
					max = Math.max(max, rowCnt);
					rowC = candy[i][j];
					rowCnt = 1;
				}
				if(candy[j][i] == colC) colCnt++;
				else {
					max = Math.max(max, colCnt);
					colC = candy[j][i];
					colCnt = 1;
				}
			}
			max = Math.max(max, rowCnt);
			max = Math.max(max, colCnt);
			if(max == N) break;
		}
	}
	
	static void rowSwap(int i, int j) {
		char temp = candy[i][j];
		candy[i][j] = candy[i][j+1];
		candy[i][j+1] = temp;
	}
	
	static void colSwap(int i, int j) {
		char temp = candy[j][i];
		candy[j][i] = candy[j+1][i];
		candy[j+1][i] = temp;
	}
}
