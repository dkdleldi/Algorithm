package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_숫자를정렬하자_1966 {

	static int T, N;
	static int[] num;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1966_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			int index = 0;
			while(true) {
				if(index+1 >= N) break;
				if(num[index] > num[index+1]) {
					int temp = num[index];
					num[index] = num[index+1];
					num[index+1] = temp;
					if(index-1 < 0) index = 0;
					else index--;
				}
				else index++;
			}
			
			System.out.print("#" + t + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
		}
	}
}
