/* FileReverse.java
 *
 *	FileReverse <input text file> <output text file>
 *
 * This is supposed to take in a text file and tokenenize each line of text and reverse
 * the individual text block. It should then output a file with the reversed tokens on
 * its own independent line.
 *
 * inputting a file called Test.txt containing the following
 *
 *	abc defg
 *	hi
 *	jkl mnop q
 *	rstu v
 *	wxyz
 *
 * should output a text file containing:
 *
 *	cba
 *	gfed
 *	ih
 *	lkj
 *	ponm
 *	q
 * 	utsr
 *	v
 *	zyxw
 */

import java.io.*;
import java.util.Scanner;

class FileReverse{
	public static void main(String[] args) throws IOException{
		// check number of command line arguments is at least 2
		if(args.length < 2){
			System.out.println("Usage: FileReverse <input file> <output file>");
			System.exit(1);
		}
		// open file Scanner and PrintWriter from the input arguments
		Scanner in = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));
		// read lines from in, extract and reverse them. Then output them to a text file
		while( in.hasNextLine() ){
			// trim leading and trailing spaces, then add one trailing space so
			// split works on blank lines
			String line = in.nextLine().trim() + " ";
			// split line around white space
			String[] token = line.split("\\s+");
			// print out tokens
			int n = token.length;
			for(int i=0; i<n; i++){
				out.println(" "+stringReverse(token[i], token[i].length()-1));
			}
		}
		// closes the Scanner and PrintWriter to save resources
		in.close();
		out.close();
	}
	//stringReverse take in a string and reverse the string then return the string
	public static String stringReverse(String s, int n){
		// if n==0 do nothing and return the single char string
		if(n > 0) {
			// return the last char in the first position then recursivly
			// run stringReverse on the remaining substring
			return  s.charAt(n) + stringReverse(s.substring(0,n), n-1);
		}
		return s;
	}
}

