package pg;

import java.util.Arrays;

public class PG_전화번호목록 {

	public static void main(String[] args) throws Exception {
		String[] phone_book = {"119", "97674223", "1195524421"};
//		String[] phone_book = {"123", "456", "789"};
//		String[] phone_book = {"12", "123", "1235", "567", "88"};
//		String[] phone_book = {"1234", "1235", "567"};
//		String[] phone_book = {"113333","115555","345555","555555", "345444"};
		System.out.println(solution(phone_book));
	}

	static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length-1; i++) {
        	int ilen = phone_book[i].length();
			int jlen = phone_book[i+1].length();
			if(ilen <= jlen
					&& phone_book[i+1].substring(0, ilen).equals(phone_book[i])) {
				return false;
			}
		}
        return answer;
    }
}
