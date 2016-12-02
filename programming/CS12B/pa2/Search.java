import java.io.*;
import java.util.Scanner;

public class Search {

    public static void main(String[] args) throws IOException{
//       check number of command line arguments is at least 2
        if(args.length < 2){
            System.out.println("Usage: Search file target1 [target2 target3 ...]");
            System.exit(1);
        }

//       open file Scanner and PrintWriter from the input arguments
        Scanner in = new Scanner(new File(args[0]));
//       read lines from in, extract and reverse them. Then output them to a text file
        int lineCount = 0;
//       count how many lines there are
        while( in.hasNextLine() ){
            lineCount++;
            in.nextLine();
        }
//      open the file again to start at the top of the file
        in = new Scanner(new File(args[0]));
//      create a new array and add the strings to the array
        String[] word = new String[lineCount];
        int[] lineNumber = new int[lineCount];
        for(int i = 0; i<lineCount; i++){
            word[i] = in.nextLine();
            lineNumber[i] = i;
        }
//       sort the list of words alphabetically aand the print the location of the target word if its been found
        mergeSort(word, lineNumber ,0, lineCount-1);
        for(int i = 1; i < args.length; i++){
            if(binarySearch(word, 0, word.length-1, args[i]) + 1 > 0){
                System.out.println(args[i] + " found on line " + (lineNumber[ binarySearch( word, 0, word.length-1, args[i] ) ] + 1) + ".");
            }else System.out.println(args[i] + " not found.");

        }

//      for(int i = 0; i<lineCount; i++){
//          System.out.println(i + " " + word[i]);
//      }

//       closes the Scanner to save resources
        in.close();
    }

//   mergeSort()
//   sort subarray A[p...r]
    public static void mergeSort(String[] A, int[] B, int p, int r){
        int q;
        if(p < r) {
            q = (p+r)/2;
            // System.out.println(p+" "+q+" "+r);
            mergeSort(A, B, p, q);
            mergeSort(A, B, q+1, r);
            merge(A, B, p, q, r);
        }
    }

//   merge()
//   merges sorted subarrays A[p..q] and A[q+1..r]
    public static void merge(String[] A, int[] B, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        String[] L = new String[n1];
        int[] LN = new int[n1];
        String[] R = new String[n2];
        int[] RN = new int[n2];
        int i, j, k;

        for(i = 0; i < n1; i++){
            L[i] = A[p + i];
            LN[i] = B[p + i];

        }

        for(j = 0; j < n2; j++){
            //System.out.println(q+j+1);
            R[j] = A[q + j + 1];
            RN[j] = B[q + j + 1];
        }

        i = 0; j = 0;
        for(k = p; k <= r; k++){
            if( i < n1 && j < n2 ){
                if( L[i].compareTo(R[j]) < 0){
                    A[k] = L[i];
                    B[k] = LN[i];
                    i++;
                }else{
                    A[k] = R[j];
                    B[k] = RN[j];
                    j++;
                }
            }else if( i < n1 ){
                A[k] = L[i];
                B[k] = LN[i];
                i++;
            }else{ // j<n2
                A[k] = R[j];
                B[k] = RN[j];
                j++;
            }
        }
    }

    static int binarySearch(String[] A, int p, int r,  String target){
        int q;
        if(p > r) {
            return -1;
        }else{
            q = (p + r) / 2;
            if(target.compareTo(A[q]) == 0){
                return q;
            }else if(target.compareTo(A[q]) < 0){
                return binarySearch(A, p, q - 1, target);
            }else{ // target > A[q]
                return binarySearch(A, q + 1, r, target);
            }
        }
    }
}

