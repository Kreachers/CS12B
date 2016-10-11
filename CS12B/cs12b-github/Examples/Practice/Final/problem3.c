/* The public class Node defined below can be used to build a binary search tree in java. Trace the main
 function in the class Problem3 below and draw the binary search tree that results. Write java
 instructions that will "manually" perform the following operations in succession: insert the key 1, insert
 the key 3, delete the key 7. Draw the resulting binary search tree. */
 
//Node.java
public class Node {
 int key;
 Node left;
 Node right;
 
 Node(int k) {
   this.key = k;
   this.left = this.right = null;
  }
}

// Problem3.java
public class Problem3 {
  public static void main(String[] args) {
    Node root = new Node(5);
    root.left = new Node(2);
    root.right = new Node(7);
    root.left.right = new Node(4);
    root.right.left = new Node(6);
    root.right.right = new Node(8);
    
    // Your code goes here
    root.left.left = new Node(1);
    root.left.right.left = new Node(3);
    root.right = root.right.left;
    root.right.left = null;
  }
}
