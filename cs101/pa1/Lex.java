import java.io.File;

public class Lex {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Lex requires 2 command line inputs the first an input file and the second an output file");
			}
		File input = new File(args[0]);
		scanner in = new scanner(input);
		while (in.hasnextline()){

		}

	}

