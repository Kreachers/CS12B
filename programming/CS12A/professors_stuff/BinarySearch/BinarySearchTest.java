// BinarySearch.java - use bisection search to find
// a selected value in an ordered array
class BinarySearchTest {
  public static void main(String[] args) {
    int[] data = {100, 110, 120, 130, 140, 150};
    int index = binarySearch(data, 120);
    System.out.println(index);
  }
  // find the index of element v in array keys
  // return -1 if it is not found
  static int binarySearch(int[] keys, int v) {
    int guess;
    int begin = 0, end = keys.length - 1;
    while (end >= begin) {
      guess = (begin + end) / 2;
      if (keys[guess] < v) // too small
        begin = guess + 1;
      else if (keys[guess] > v) // too big
        end = guess - 1;
      else return guess; // just right
    }
    return -1;
  }
}
