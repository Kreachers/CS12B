import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.*;

public class Fibonacci {

	/*
	 * attempt at writing out the Fibonacci sequence
	 */
	public static void main(String[] args) {
		int first = 0, second = 1, output1;
		System.out.println("0");
		//while(1==1){
		for(int i = 1; i < 15; i++){
			output1 = first + second;
			System.out.println(output1);
			second = first;
			first = output1;
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				//Handle exception
			}
		}
	}

}
