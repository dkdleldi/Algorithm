package pg;

public class PG_HIndex {

	public static void main(String[] args) throws Exception{
		int[] citations = {3, 0, 6, 1, 5};
//		int[] citations = {1, 1, 5, 7, 6};
		System.out.println(solution(citations));
	}

	static int solution(int[] citations) {
        int answer = 0;
        int ok = 0;
        for (int i = citations.length; i >= 0; i--) {
			ok = 0;
			for (int j = 0; j < citations.length; j++) {
        		if(citations[j] >= i) ok++;
        	}
        	if(i <= ok) {
        		answer = i;
        		break;
        	}
		}
        return answer;
    }
}
