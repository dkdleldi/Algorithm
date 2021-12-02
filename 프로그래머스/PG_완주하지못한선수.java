package pg;

public class PG_완주하지못한선수 {

	public static void main(String[] args) throws Exception {
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(participant, completion));

	}

	static String solution(String[] participant, String[] completion) {
        String answer = "";
        boolean[] visit = new boolean[completion.length];
        boolean com = false;
        for (int i = 0; i < participant.length; i++) {
        	com = false;
			for (int j = 0; j < completion.length; j++) {
				if(!visit[j] && participant[i].equals(completion[j])) {
					visit[j] = true;
					com = true;
					break;
				}
			}
			if(!com) {
				answer = participant[i];
				break;
			}
		}
        return answer;
    }
}
