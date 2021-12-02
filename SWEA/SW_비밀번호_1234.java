package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW_비밀번호_1234 {

	static int L, pw;
	static LinkedList<Integer> before;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("SW_1234_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			before = new LinkedList<Integer>();
			char[] temp = st.nextToken().toCharArray();
			for (int i = 0; i < L; i++) {
				before.add(temp[i] - '0');
			}
			int index = 0;
			while(true) {
				if(index >= before.size()) break;
				if(index >= 0 && index+1 < before.size() && before.get(index) == before.get(index+1)) {
					before.remove(index);
					before.remove(index);
					index--;
				}
				else {
					index++;
				}
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < before.size(); i++) {
				System.out.print(before.get(i));
			}
			System.out.println();
			
		}
	}
}
