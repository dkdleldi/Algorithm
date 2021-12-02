package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_암호문1 {
	static int N, M, x, y;
	static LinkedList<String> code = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1228_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				code.add(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				st.nextToken();
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				for (int j = 0; j < y; j++) {
					code.add(x+j, st.nextToken());
				}
			}
			
			System.out.println("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(code.get(i) + " ");
			}
			System.out.println();
			code.clear();
		}

	}

}
