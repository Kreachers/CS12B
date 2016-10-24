class problem8 {
   public static void main(String[] args) {
      int[] A = {34, 25, 79, 56, 6};
      int n = A.length(); // n = # of keys;
      int m = 11 // # of slots;
      for(int i = 0; i < A.length; i++) {
         System.out.print(probe(A[i])+ " ");
      }
   }

   /* public static probe(int[] key, int n, int m) {
      int[] probeArray = m.length();
      int i = 0; //keys put in order
      int collision = 0;
      int numbersPutIntoArray = 0;
      // While number of current keys is less than total and total keys is less than total slots
      while (numbersPutIntoArray <= n && n <= m) {
         if (key%m != null) {
            key = probeArray[(key%m)];
            i++;
         } else {
            collision++;
            key = (key%m)+collision(1+key%(m-1))%11;
            probe(key, n, m);
         }
      }
      while ()
      return index;
   } */

   // Returns number of collisions
   public collisions() {
      int i = 0;
      if (key%m != null) { //If that spot is full
         i++;
         key = //Need to change key to check if next spot works
      }
   }
}