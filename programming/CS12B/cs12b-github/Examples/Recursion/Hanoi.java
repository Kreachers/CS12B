//-----------------------------------------------------------------------------
// Hanoi.java
//-----------------------------------------------------------------------------

public class Hanoi {

   // hanoi()
   // Prints instructions for moving n discs from rod i to rod j.
   // Pre: n>=1, i,j in {1,2,3}, i!=j   
   public static void hanoi(int n, int i, int j) {
      int k;
      if(n==1)
         System.out.println(i+"-->"+j);
      else {         // n > 1
         k = 6-i-j;  // calculate the 'other' rod number
         hanoi(n-1, i, k);
         System.out.println(i+"-->"+j);
         hanoi(n-1, k, j);
      }
   }

   public static void main(String[] args) {
      hanoi(13, 1, 3);
   }
}

