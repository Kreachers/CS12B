// HelloWorld2.java - simple variable declarations
class HelloWorld2 {
    public static void main (String[] args) {
	String word1;
	// declare a String variable
	String word2, sentence; // declare two more
	word1 = "Hello, ";
	word2 = "world!";
	sentence = word1.concat(word2);
	System.out.println(sentence);
    }
}
