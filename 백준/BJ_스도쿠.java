package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_스도쿠 {

	static int[][] sudoku;
	static boolean complete;
	static ArrayList<Zero> zero = new ArrayList<Zero>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9];
		for (int i = 0; i < 9; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = temp[j] - '0';
				if(sudoku[i][j] == 0) zero.add(new Zero(i, j));
			}
		}
		complete = false;
		dfs(0);
	}

	static void dfs(int idx) {
		if(complete) return;
		if(idx == zero.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(sudoku[i][j]);
				}
				System.out.println();
			}
			complete = true;
			return;
		}
		Zero z = zero.get(idx);
		int y = z.y;
		int x = z.x;
		boolean[] use = new boolean[10];
		for (int i = 0; i < 9; i++) {
			if(sudoku[y][i] != 0) use[sudoku[y][i]] = true;
			if(sudoku[i][x] != 0) use[sudoku[i][x]] = true;
		}
		for (int i = 3*(y/3); i < 3*(y/3) + 3; i++) {
			for (int j = 3*(x/3); j < 3*(x/3) + 3; j++) {
				if(sudoku[i][j] != 0) use[sudoku[i][j]] = true;
			}
		}
		for (int i = 1; i <= 9; i++) {
			if(use[i]) continue;
			sudoku[y][x] = i;
			dfs(idx+1);
			sudoku[y][x] = 0;
		}
	}
	
	static class Zero {
		int y;
		int x;
		public Zero(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
