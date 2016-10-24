import java.util.*;
import java.io.*;

class FirstReverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print(FirstReverse(sc.nextLine()));
	}

	public static String FirstReverse(String str) {
		return FirstReverse(str.substring(1) + str.charAt(0));
	}
}