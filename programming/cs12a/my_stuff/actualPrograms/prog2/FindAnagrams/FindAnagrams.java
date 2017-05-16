import java.util.*;
import java.io.*;

/*
  the purpose of this program is to take an input and search though a
  text file and look for anagrams of the input word
  Author: Devin Siems
*/

class FindAnagrams{
    public static void main(String[] args) throws FileNotFoundException {
	//takes the file input as an argument
	Scanner in = new Scanner(new FileInputStream(args[0]));
	//new String Array for the text file
	String[] dictionary = new String[in.nextInt()];
	//array to hold the hash codes for the dictionary
	int[] dictionaryHash = new int[dictionary.length];

	boolean run = true;
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	//string consisting of the alphabet
	int SEED = 1234;
	Random rng = new Random(SEED);
	int[] hashValues = new int[26];
	//array that hold the codes for each alphabetical letter

	for(int i = 0; i < dictionary.length; i++){
	    // loop to take a word from the text file and 
	    dictionary[i] = in.next(); //add to the dictionary array
	}

	for( int i = 0; i < hashValues.length; i++){
	    //generates the hash values for each letter of the alphabet
	    hashValues[i] = rng.nextInt(); 
	    //System.out.println(alphabet.charAt(i)+" "+hashValues[i]);
	}

	//nested for loops that will look through each letter of each words in
	//the dictionary array and then take the hash values for that letter
	//and add to the previous value. creating the unique hash value for
	//each word in the dictionary array
	for(int k = 0; k < dictionary.length; k++){		
	    for(int j = 0; j < dictionary[k].length(); j++){		
		for(int i = 0; i < alphabet.length(); i++){		
		    if(dictionary[k].charAt(j) == alphabet.charAt(i)){
			dictionaryHash[k] = dictionaryHash[k] + hashValues[i];
			//System.out.print(alphabet.charAt(i));
			i = alphabet.length();
		    }
		}
	    }
	    //System.out.println("");
	}

	//System.out.println(wordHash);
	//System.out.println( dictionaryHash[0] + " " + dictionary[0]);
	//System.out.println("");
	while(run == true){
	    Scanner scan = new Scanner(System.in); 
	    System.out.println("type a string of letters");
	    String word = scan.next(); // takes input from user 
	    int wordHash = 0;
	    // this will hold the hash values for the users word

	    //nested for loop to generate a unique hash value for the uses word
	    for(int j = 0; j < word.length(); j++){
		for(int i = 0; i < alphabet.length(); i++){		
		    if(word.charAt(j) == alphabet.charAt(i)){
			wordHash = wordHash + hashValues[i];
			i = alphabet.length();
			//System.out.println(word.charAt(j)+" "+hashValues[i]);
		    }
		}
	    }
	    //a loop to check the users words unique hash value against all 
	    //the hash values in the dictionary hashs
	    for(int i = 0; i < dictionary.length; i++){
		if(word.length() == dictionary[i].length()){
		    if(wordHash == dictionaryHash[i]){
			System.out.println(dictionary[i]);	
		    }
		}
	    }
	    System.out.println("do you want to do another (y/n)");
	    scan = new Scanner(System.in); 
	    //word = scan.next(); // takes input from user 
	    boolean test = true;

	    while(test == true){
		word = scan.next(); // takes input from user 
		if(word.charAt(0) != alphabet.charAt(13) && word.charAt(0) != alphabet.charAt(24)){
		    System.out.print("Please type either \"y\" to search for another anagram or \"n\" to close the program\r\n");
		    //System.out.println("Please type either y to search for another anagram or n to close the program");
		}
		if(word.charAt(0) == alphabet.charAt(13) || word.charAt(0) == alphabet.charAt(24)){
		    if( word.charAt(0) == alphabet.charAt(13)){
			run = false;
			test = false;
		    }else if(word.charAt(0) == alphabet.charAt(24)){
			run = true;
			test = false;
		    }
     		}
	    }
	}
    }
}
