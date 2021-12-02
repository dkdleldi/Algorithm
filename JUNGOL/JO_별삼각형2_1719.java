package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_별삼각형2_1719 {

	static int n, m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		if(n > 100 || n % 2 == 0 || m < 1 || m > 4) System.out.println("INPUT ERROR!");
		else if(m == 1) type1(n);
		else if(m == 2) type2(n);
		else if(m == 3) type3(n);
		else if(m == 4) type4(n);
	}
	static void type1(int n) {
		int num = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < num; j++) {
				System.out.print("*");
			}
			if(i >= n / 2) num--;
			else num++;
			System.out.println();
		}
	}
	static void type2(int n) {
		int blankNum = n / 2;
		int starNum = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < blankNum; j++) {
				System.out.print(" ");
			}
			if(i >= n / 2) blankNum++;
			else blankNum--;
			for (int j = 0; j < starNum; j++) {
				System.out.print("*");
			}
			if(i >= n / 2) starNum--;
			else starNum++;
			System.out.println();
		}
	}
	static void type3(int n) {
		int blankNum = 0;
		int starNum = n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < blankNum; j++) {
				System.out.print(" ");
			}
			if(i >= n / 2) blankNum--;
			else blankNum++;
			for (int j = 0; j < starNum; j++) {
				System.out.print("*");
			}
			if(i >= n / 2) starNum += 2;
			else starNum -= 2;
			System.out.println();
		}
	}
	static void type4(int n) {
		int blankNum = 0;
		int starNum = n / 2 + 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < blankNum; j++) {
				System.out.print(" ");
			}
			if(i < n / 2) blankNum++;
			for (int j = 0; j < starNum; j++) {
				System.out.print("*");
			}
			if(i >= n / 2) starNum++;
			else starNum--;
			System.out.println();
		}
	}
}
