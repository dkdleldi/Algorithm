import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_냉장고_1828 {
	static int N, ref;
	static Chemicals[] chemicals;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		chemicals = new Chemicals[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			chemicals[i] = new Chemicals(x, y);
		}
		Arrays.sort(chemicals);
		getRef(chemicals);
		System.out.println(ref);
	}
	static class Chemicals implements Comparable<Chemicals>{
		int x;
		int y;
		public Chemicals(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Chemicals o) {
			int value = this.y - o.y;
			if(value != 0) return value;
			return this.x - o.x;
		}
		@Override
		public String toString() {
			return "Chemicals [x=" + x + ", y=" + y + "]";
		}		
	}
	
	static void getRef(Chemicals[] chemicals) {
		int max = chemicals[0].y;
		ref++;
		for (int i = 1; i < chemicals.length; i++) {
			if(max < chemicals[i].x) {
				ref++;
				max = chemicals[i].y;
			}
		}
	}
}
