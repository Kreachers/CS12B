// ArrayTest.java - minimum and maximum of an array
import java.util.*;
class ArrayTest {
  public static void main(String[] args) {
    int[] data;
    int n;
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter size of data[]:");
    n = scan.nextInt();
    data = new int[n];
    System.out.println("Enter " + n + " integers:");
    readArray(data, scan);
    printArray(data, "My Data");
    System.out.println("minimum is " + minimum(data) +
                       " maximum is " + maximum(data));
  }
  // fill an array by reading values from the console
  static void readArray(int[] a, Scanner scan) {
    for ( int i = 0; i < a.length; i++) {
      a[i] = scan.nextInt();
    }
  }
  // find the maximum value in an array
  static int maximum(int[] a) {
    int max = a[0]; //initial max value
    for (int d : a)
      if (d > max)
        max = d;
    return max;
  }
  // find the minimum value in an array
  static int minimum(int[] a) {
    int min = a[0]; //initial min value
    for (int d : a)
      if (d < min)
        min = d;
    return min;
  }
  // print the elements of an array to the console
  static void printArray(int[] a, String arrayName) {
    System.out.println(arrayName );
    for (int d : a)
      System.out.print(d + " ");
    System.out.println();
  }
}
