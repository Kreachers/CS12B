import java.util.Scanner;

class Palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		if (isPal(s))
			System.out.println("palindrome");
		else
			System.out.println("not a palindrome");

	}

	public static boolean isP(String s) {
		if (s.length == 0 || s.length == 1)
			return true;
		if (s.charAt(0) == s.charAt(s.length()-1))
			return isPal(s.substring(1, s.length()-1));
		return false;
	}
}