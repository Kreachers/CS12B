import java.util.*;
import java.io.*;

/*
   This is intended as a starter for a word scrambler (anagram generator)
   that scrambles a randomly selected word from a word file specified on the
   command line.

   This program simply echos the entire contents of the file to the console.
   It assumes that the first line of the input contains the number of words in the file
   (not including the count if you think of it as a word). 
   For this program, a word is any white space delimited sequence of characters.
   @author Charlie McDowell (minor mods Dean Bailey 08/23/07)

   Edited by Devin Siems with help from Augustine Stav.

 */
class AnagramPuzzleGenerator {
    public static void main(String[] args) throws FileNotFoundException {
	//allows you to input a file of words
        Scanner in = new Scanner(new FileInputStream(args[0]));
        
	//first item is the number of words in the file
        int size = in.nextInt();
	//initializes an array of strings and  
	//makes the size of the array the int "size"
        String[] wordsArray = new String[size]; 
        
        //a while loop to add the words in the file to wordArray
        int i = 0;
        while ( i < size ) {
	    //takes the words from the text file and puts them in the wordsArray
	    wordsArray[i] = in.next();
	    //increments to the next words untill its at the bottom of the file
        i++;
        }
	
        Random randomGenerator = new Random(); // creates a new random type
        //stores the random number index
        int randomInt = randomGenerator.nextInt(size);
	//creates string buffers the first for the randomly chosen word
	//and the second for the scrambled word
        StringBuffer sb1 = new StringBuffer(wordsArray[randomInt]);
        StringBuffer sb2 = new StringBuffer("");
	
        //takes a randomly chosen letter from the first string buffer and adds
	//it to the second string buffer until the first string buffer is empty
        while (sb1.length()>0){
                randomInt = randomGenerator.nextInt(sb1.length());
                sb2.append(sb1.charAt(randomInt));
                sb1.deleteCharAt(randomInt);
        }
	//prints out the newly scrambled word
        System.out.println(sb2);
    }
}

