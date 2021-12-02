package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_상호의배틀필드 {
	static int T, H, W, N, x, y;
	static char[][] field;
	static char input;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1873_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			field = new char[H][W];
			
			for (int i = 0; i < H; i++) {
				String temp = br.readLine();
				for (int j = 0; j < W; j++) {
					field[i][j] = temp.charAt(j);
					if(field[i][j] == '^' || field[i][j] == 'v' || field[i][j] == '<' || field[i][j] == '>') {
						y = i;
						x = j;
					}
				}
			}
			N = Integer.parseInt(br.readLine());
			String temp = br.readLine();
			for (int i = 0; i < N; i++) {
				input = temp.charAt(i);
				if(input == 'U') {
					if(y-1 >= 0 && field[y-1][x] == '.') {
						field[y-1][x] = '^';
						field[y][x] = '.';
						y = y-1;
					}
					else field[y][x] = '^';
					
				}
				else if(input == 'D') {
					if(y+1 < H && field[y+1][x] == '.') {
						field[y+1][x] = 'v';
						field[y][x] = '.';
						y = y+1;
					}
					else field[y][x] = 'v';
				}
				else if(input == 'L') {
					if(x-1 >= 0 && field[y][x-1] == '.') {
						field[y][x-1] = '<';
						field[y][x] = '.';
						x = x-1;
					}
					else field[y][x] = '<';
				}
				else if(input == 'R') {
					if(x+1 < W && field[y][x+1] == '.') {
						field[y][x+1] = '>';
						field[y][x] = '.';
						x = x+1;
					}
					else field[y][x] = '>';
				}
				else if(input == 'S') {
					shoot(y, x);
				}
			}
						
			System.out.print("#" + t + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}

	}
	static void shoot(int dy, int dx) {
		if(dy >= H || dy < 0 || dx >= W || dx < 0 || field[dy][dx] == '#') return;
		else if(field[dy][dx] == '*') {
			field[dy][dx] = '.';
			return;
		}
		if(field[y][x] == '^') {
			shoot(dy-1, dx);
		}
		else if(field[y][x] == 'v') {
			shoot(dy+1, dx);
		}
		else if(field[y][x] == '<') {
			shoot(dy, dx-1);
		}
		else if(field[y][x] == '>') {
			shoot(dy, dx+1);
		}
	}

}
