class SelectionSortTest {
  public static void main(String[] args) {
    int[] a = {7, 3, 66, 3, -5, 22, -77, 2};
    sort(a);
    for (int d : a){
      System.out.println(d);
    }
  }
  // sort using the selection sort algorithm
  static void sort(int[] data) {
    int next, indexOfNext;
    for (next = 0; next < data.length - 1; next++) {
      indexOfNext = min(data,next,data.length - 1);
      swap(data, indexOfNext, next);
    }
  }
  // find the index of the smallest element in
  // a specified range of indices in an array
  static int min(int[] data, int start, int end) {
    int indexOfMin = start; // initial guess
    for (int i = start+1; i <= end; i++)
      if (data[i] < data[indexOfMin])
        indexOfMin = i; // found a smaller value
    return indexOfMin;
  }
  // swap two entries in an array
  static void swap(int[] data, int first, int second){
    int temp;
    temp = data[first];
    data[first] = data[second];
    data[second] = temp;
  }
}