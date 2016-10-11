public class Fibonacci {
	public static void main(String[] args) {
		int i = 1;
		int j = 2;
		for (int n = 1; n < 10; n++) {
			j = i + j;
			i = i + j;
			System.out.println(j);
		}
	}
}