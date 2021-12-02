package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SW_Magnetic_1220 {

	static int N, count;
	static int[][] table;
	static ArrayList<Magnet> nLocation;
	static ArrayList<Magnet> sLocation;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1220_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			table = new int[N][N];
			nLocation = new ArrayList<Magnet>();
			sLocation = new ArrayList<Magnet>();
			count = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
					if(table[i][j] == 1) nLocation.add(new Magnet(i, j));
					else if(table[i][j] == 2) sLocation.add(new Magnet(i, j));
				}
			}
			Collections.sort(nLocation, (n1, n2) -> n2.y - n1.y);
			Collections.sort(sLocation, (n1, n2) -> n1.y - n2.y);
			for (int i = 0; i < nLocation.size(); i++) {
				int y = nLocation.get(i).y;
				int x = nLocation.get(i).x;
				moveN(y, x);
			}
			for (int i = 0; i < sLocation.size(); i++) {
				int y = sLocation.get(i).y;
				int x = sLocation.get(i).x;
				moveS(y, x);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N-1; j++) {
					if(table[j][i] == 1 && table[j+1][i] == 2) count++;
				}
			}
			
			System.out.println("#" + t + " " + count);
			
		}

	}
	static class Magnet {
		int y;
		int x;
		public Magnet(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static void moveN(int y, int x) {
		for (int i = y; i < N; i++) {
			if(i+1 < N && table[i][x] == 1 && table[i+1][x] == 0) {
				table[i+1][x] = 1;
			}
			else if(i == N-1 && table[i][x] == 1) {}
			else continue;
			table[i][x] = 0;
		}
	}
	static void moveS(int y, int x) {
		for (int i = 0; i < N; i++) {
			if(i-1 >= 0 && table[i][x] == 2 && table[i-1][x] == 0) {					
				table[i-1][x] = 2;
			}
			else if(i == 0 && table[i][x] == 2) {}
			else continue;
			table[i][x] = 0;
		}
	}

}
