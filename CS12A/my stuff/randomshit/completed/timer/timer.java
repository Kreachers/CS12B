/*
  test javaprogramm to make a timer
  by Devin
*/

import java.util.*;
import java.util.concurrent.TimeUnit;

class timer{
    public static void main(String[] args){
        int millisecond = 0, second = 0, minute = 0, hour = 0;
        while(1==1){
            millisecond = millisecond + 1;
            if(millisecond >= 1000){
                second = second + 1;
                millisecond = 0;
            } else if(second >= 60){
                minute = minute + 1;
                second = 0;
            }else if(minute >= 60){
                hour = hour + 1;
                minute = 0;
            }
            System.out.print("\r"+hour+":"+minute+":"+second+"."+millisecond);
            try{
                TimeUnit.MILLISECONDS.sleep(1);
            }catch (InterruptedException e) {
                //Handle exception
            }
        }
    }
}



