import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

/*
  I dunno what im doing with my life
  99 bottle of beer on the wall

*/

class Beer{
    public static void main(String[] args){
	int bottle = 99;
	while(bottle >=1){
	    System.out.println(bottle + " bottles of beer on the wall");
	    try {	 
		TimeUnit.SECONDS.sleep(1);
	    } catch (InterruptedException e) {
		//Handle exception
	    }
	    
	    System.out.println(bottle + " bottles of beer on the wall");
	    try {
		TimeUnit.SECONDS.sleep(1);		 
	    } catch (InterruptedException e) {
		//Handle exception
	    }
	    System.out.println("take one down, pass it around");
	    try {		 
		TimeUnit.SECONDS.sleep(1);		 
	    } catch (InterruptedException e) {
		//Handle exception
	    }
	    System.out.println(bottle - 1 + " bottles of beer on the wall");
	    try {
		TimeUnit.SECONDS.sleep(1);
	    } catch (InterruptedException e) {
		//Handle exception
	    }
	    bottle--;
	    System.out.println();
	}
	System.out.println("No more bottles of beer on the wall");
	try {
	    TimeUnit.SECONDS.sleep(1);
	} catch (InterruptedException e) {
	    //Handle exception
	}
	System.out.println("no more bottles of beer.");
	try {
	    TimeUnit.SECONDS.sleep(1);
	} catch (InterruptedException e) {
	    //Handle exception
	}
	System.out.println("Go to the store and buy some more");
	try {
	    TimeUnit.SECONDS.sleep(1);
	} catch (InterruptedException e) {
	    //Handle exception
	}
	System.out.println("99 bottles of beer on the wall.");
    }
}

