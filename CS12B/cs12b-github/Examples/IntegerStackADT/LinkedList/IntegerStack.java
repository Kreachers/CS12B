//-----------------------------------------------------------------------------
// IntegerStack.java
// Linked List implementation of IntegerStack ADT
//-----------------------------------------------------------------------------

public class IntegerStack implements IntegerStackInterface{

   private class Node{
      int item;
      Node next;
      Node(int item){
         this.item = item;
         this.next = null;
      }
   }

   private Node top;      // reference to the top Node in the stack
   private int numItems;      // number of items in this IntegerStack

   // IntegerStack
   // default constructor for the IntegerStack class
   public IntegerStack(){
      top = null;
      numItems = 0;
   }

   // isEmpty
   // pre: none
   // post: returns true if this IntgerStack is empty, false otherwise
   public boolean isEmpty(){
      return(numItems == 0);   // could also check top==null
   }

   // push
   // pushes x onto top of this IntegerStack
   // pre: none
   // post: !isEmpty()
   public void push(int x){
      Node N = new Node(x);
      N.next = top;
      top = N;
      numItems++;
   }

   // pop
   // deletes and returns item from top of Stack
   // pre: !isEmpty()
   // post: this Stack will have one fewer element
   public int pop() throws StackEmptyException{
      if( numItems==0 ){  // could also check top==null
         throw new StackEmptyException("cannot pop() empty stack");
      }
      int returnValue = top.item;
      top = top.next;
      numItems--;
      return returnValue;
   }

   // peek
   // pre: !isEmpty()
   // post: returns item on top of Stack
   public int peek() throws StackEmptyException {
      if( numItems==0 ){  // could also check top==null
         throw new StackEmptyException("cannot peek() empty stack");
      }
      return top.item;
   }

   // popAll
   // pre: !isEmpty()
   // post: isEmpty()
   public void popAll() throws StackEmptyException{
      if( numItems==0 ){  // could also check top==null
         throw new StackEmptyException("cannot popAll() empty stack");
      }
      top = null;
      numItems = 0;
   }

   // toString
   // overrides Object's toString() method
   public String toString(){
      String s = "";
      for(Node N = top; N!=null; N=N.next){
         s = s+String.valueOf(N.item)+" ";
      }
      return s;
   }

   // equals
   // overrides Object's equals
   public boolean equals(Object rhs){
      boolean eq = false;
      IntegerStack R;

      if(rhs instanceof IntegerStack){
         R = (IntegerStack)rhs;
         eq = (this.numItems==R.numItems);
         Node N = this.top;
         Node M = R.top;
         while(eq && N!=null){
            eq = (N.item==M.item);
            N = N.next;
            M = M.next;
         }
      }
      return eq;
   }

}