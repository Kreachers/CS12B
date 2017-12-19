import java.util.*;
import java.io.*;

class CliAnagramGen{
    public static void main(String[] args){

	StringBuffer[] args2 = new StringBuffer[args.length];
	StringBuffer[] args3 = new StringBuffer[args.length];
	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(args.length);
	
	for(int i = 0; i < args.length; i++){
	    args2[i] = new StringBuffer(args[i]);
	    args3[i] = new StringBuffer("");
	}
		
	for(int i = 0; i < args.length; i++){
	    while (args2[i].length()>0){
		randomInt = randomGenerator.nextInt(args2[i].length());
		args3[i].append(args2[i].charAt(randomInt));
		args2[i].deleteCharAt(randomInt);
	    }
	}
	
	for(int i=0; i < args.length; i++){
	    System.out.println(args3[i]);
	}
	
	//System.out.println(args[]);
    }
}
