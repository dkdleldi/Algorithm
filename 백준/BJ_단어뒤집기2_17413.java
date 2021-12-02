package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_단어뒤집기2_17413 {

	static int start, end;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] string = br.readLine().toCharArray();
		start = 0;
		boolean sw = true;
		for (int i = 0; i < string.length; i++) {
			if(i-1 < 0 && string[i] == '<') sw = false;
			if(i-1 < 0) continue;
			
			if(string[i] == '<') {
				end = i-1;
				swap(string, start, end);
				sw = false;
			}
			else if(string[i] == '>') {
				sw = true;
				start = i+1;
			}
			else if(string[i] == ' ' && sw) {
				end = i-1;
				swap(string, start, end);
				start = i+1;
			}
			else if(i == string.length-1) {
				end = i;
				swap(string, start, end);
			}
			else continue;			
		}
		System.out.println(string);

	}
	static void swap(char[] string, int start, int end) {
		int i = start;
		int j = end;
		while( i < j ) {
			char temp = string[i];
			string[i] = string[j];
			string[j] = temp;
			i++;
			j--;
		}
	}
}
