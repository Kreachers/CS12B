/* Write a Java function with the heading void sortWords(String[] W) that sorts is array argument W
in alphabetical order. Do this by implementing the Insertion Sort algorithm discussed in class. */

class problem5 {
  public static void main(String[] args) {
    String[] W = {"G", "F", "D", "B", "C", "E", "A"};
    sortWords(W);
    for(int i = 0; i < W.length; i++) {
      System.out.println(W[i] + " ");
    }
  }

  static void sortWords(String[] W) {
    int i, j;
    String temp="";
    for(j=1; j < W.length; j++) {
      temp = W[j];
      i = j-1;
      while(i >= 0 && temp.compareTo(W[i]) < 0) {
        W[i+1] = W[i];
        i--;
      }
      W[i+1] = temp;
    }
  }
}