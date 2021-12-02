package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_암호생성기 {
	static Queue<Integer> code = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1225_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				code.offer(Integer.parseInt(st.nextToken()));
			}
			while(true) {
				int num = 0;
				for (int i = 1; i <= 5; i++) {
					num = code.poll() - i;
					if(num <= 0) {
						code.offer(0);
						break;
					}
					code.offer(num);
				}
				if(num <= 0) break;
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(code.poll() + " ");
			}
			System.out.println();
			code.clear();
		}

	}

}
