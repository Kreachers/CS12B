//-----------------------------------------------------------------------------
// IntegerStack.java
// Array based implementation of IntegerStack ADT (with array doubling)
//-----------------------------------------------------------------------------

public class IntegerStack implements IntegerStackInterface{
   private static final int INITIAL_SIZE = 1;
   private int physicalSize;  // current length of underlying array
   private int[] item;        // array of IntegerStack items
   private int numItems;      // number of items in this IntegerStack
   private int top;           // index of top element of Stack in array

   // doubleItemArray
   // doubles the physical size of the underlying array item[]
   private void doubleItemArray(){
      physicalSize *=2;
      int[] newArray = new int[physicalSize];
      for(int i=0; i<numItems; i++) newArray[i] = item[i];
      item = newArray;
   }

   // IntegerStack
   // default constructor for the IntegerStack class
   public IntegerStack(){
      physicalSize = INITIAL_SIZE;
      item = new int[physicalSize];
      numItems = 0;
      top = -1;       // indicates empty Stack
   }

   // isEmpty
   // returns true if this IntgerStack is empty, false otherwise
   // pre: none
   public boolean isEmpty(){
      return(numItems == 0);   // could also check top<0
   }

   // push
   // pushes x onto top of this IntegerStack
   // pre: none
   public void push(int x){
      if( numItems == physicalSize ) doubleItemArray();
      numItems++;
      top++;
      item[top] = x;
   }

   // pop
   // deletes and returns item from top of Stack
   // pre: !isEmpty()
   public int pop() throws StackEmptyException{
      if( numItems==0 ){  // could also check top < 0
         throw new StackEmptyException("cannot pop() empty stack");
      }
      int returnValue = item[top];
      top--;
      numItems--;
      return returnValue;
   }

   // peek
   // returns item on top of Stack
   // pre: !isEmpty()
   public int peek() throws StackEmptyException {
      if( numItems==0 ){  // could also check top<0
         throw new StackEmptyException("cannot peek() empty stack");
      }
      return item[top];
   }

   // popAll
   // sets stack to its original empty state
   // pre: !isEmpty()
   public void popAll() throws StackEmptyException{
      if( numItems==0 ){  // could also check top < 0
         throw new StackEmptyException("cannot popAll() empty stack");
      }
      numItems = 0;
      top = -1;
   }

   // toString
   // overrides Object's toString() method
   public String toString(){
      String s = "";

      for(int i=numItems-1; i>=0; i--){
         s += item[i] + " ";
      }
      return s;
   }

   // equals
   // overrides Object's equals
   public boolean equals(Object rhs){
      IntegerStack R = null;
      boolean eq = false;

      if(rhs instanceof IntegerStack){
         R = (IntegerStack)rhs;
         eq = ( this.numItems == R.numItems );
         for(int i=0; eq && i<numItems; i++){
            eq = ( this.item[i] == R.item[i] );
         }
      }
      return eq;
   }

}