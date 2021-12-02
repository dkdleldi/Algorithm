package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_정사각형방 {

	static int T, N;
	static int[][] room;
	static int roomCount;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1861_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int maxRoom = 0;		
			int roomNum = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					roomCount = 1;
					search(i, j);
					if(maxRoom < roomCount) roomNum = room[i][j];
					else if(maxRoom == roomCount) roomNum = Math.min(room[i][j], roomNum);
					maxRoom = Math.max(maxRoom, roomCount);
				}
			}
			System.out.println("#" + t + " "+ roomNum + " " + maxRoom);
			
		}

	}
	static void search(int y, int x) {
		// 상
		if(y-1 >= 0 && room[y-1][x] - room[y][x] == 1) {
			search(y-1, x);
			roomCount++;
		}
		// 하
		else if(y+1 < N && room[y+1][x] - room[y][x] == 1) {
			search(y+1, x);
			roomCount++;
		}
		// 좌
		else if(x-1 >= 0 && room[y][x-1] - room[y][x] == 1) {
			search(y, x-1);
			roomCount++;
		}
		// 우
		else if(x+1 < N && room[y][x+1] - room[y][x] == 1) {
			search(y, x+1);
			roomCount++;
		}
		else return;
	}

}
