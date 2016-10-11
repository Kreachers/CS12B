//-----------------------------------------------------------------------------
// IntegerStackTest.java
// Test Client for the IntegerStack class
//-----------------------------------------------------------------------------

public class IntegerStackTest{

   public static void main(String[] args){
      IntegerStack A = new IntegerStack();

      A.push(5); A.push(3); A.push(9); A.push(7); A.push(8);
      System.out.println(A);
      System.out.println(A.peek());

      A.pop(); A.pop(); A.pop();
      System.out.println(A.peek());
      System.out.println(A);

      IntegerStack B = new IntegerStack();
      System.out.println(A.isEmpty());
      System.out.println(B.isEmpty());

      B.push(5); B.push(3);
      System.out.println(A.equals(B));

      A.push(12);
      B.push(13);
      System.out.println(A);
      System.out.println(B);
      System.out.println(A.equals(B));

      A.popAll();
      System.out.println(A);
      System.out.println(A.isEmpty());
   }
}