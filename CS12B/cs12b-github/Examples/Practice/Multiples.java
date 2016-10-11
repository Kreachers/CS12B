public class Multiples {
	public static void main(String[] args) {
		int temp=0;
		for(int i = 1; i < 1000; i++) {
			if (i%5==0 || i%3==0) {
				temp = temp + i;
				//System.out.println(i);
			}
		}
		System.out.println(temp);
	}
}