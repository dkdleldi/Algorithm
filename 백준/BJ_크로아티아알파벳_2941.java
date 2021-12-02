package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_크로아티아알파벳_2941 {

	static char[] s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine().toCharArray();
		int index = 0;
		int len = s.length;
		int count = 0;
		while(index < len) {
			boolean plusone = (index+1) < len;
			boolean plustwo = (index+2) < len;
			if(plusone && s[index] == 'c' && s[index+1] == '=') index += 1;
			else if(plusone && s[index] == 'c' && s[index+1] == '-') index += 1;
			else if(plusone && plustwo && s[index] == 'd' && s[index+1] == 'z' && s[index+2] == '=') index += 2;
			else if(plusone && s[index] == 'd' && s[index+1] == '-') index += 1;
			else if(plusone && s[index] == 'l' && s[index+1] == 'j') index += 1;
			else if(plusone && s[index] == 'n' && s[index+1] == 'j') index += 1;
			else if(plusone && s[index] == 's' && s[index+1] == '=') index += 1;
			else if(plusone && s[index] == 'z' && s[index+1] == '=') index += 1;
			count++;
			index++;
		}
		System.out.println(count);
	}
}
