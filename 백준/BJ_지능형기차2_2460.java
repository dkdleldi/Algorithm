package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_지능형기차2_2460 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int in = 0;
		int out = 0;
		int people = 0;
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			out = Integer.parseInt(st.nextToken());
			in = Integer.parseInt(st.nextToken());
			people = people - out + in;
			if(people > max) max = people;
		}
		System.out.println(max);
	}
}
