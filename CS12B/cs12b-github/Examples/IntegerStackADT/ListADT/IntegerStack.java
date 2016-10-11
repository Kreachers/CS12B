//-----------------------------------------------------------------------------
// IntegerStack.java
// IntegerStack ADT based on the IntegerList ADT
//-----------------------------------------------------------------------------

public class IntegerStack implements IntegerStackInterface{

   private IntegerList list;  // list of items in stack

   // IntegerStack
   // default constructor for the IntegerStack class
   public IntegerStack(){
      list = new IntegerList();
   }

   // isEmpty
   // pre: none
   // post: returns true if this IntgerStack is empty, false otherwise
   public boolean isEmpty(){
      return(list.isEmpty());
   }

   // push
   // pushes x onto top of this IntegerStack
   // pre: none
   // post: !isEmpty()
   public void push(int x){
      list.add(1, x);
   }

   // pop
   // deletes and returns item from top of Stack
   // pre: !isEmpty()
   // post: this Stack will have one fewer element
   public int pop() throws StackEmptyException{
      if( list.size()==0 ){
         throw new StackEmptyException("cannot pop() empty stack");
      }
      int returnValue = list.get(1);
      list.remove(1);
      return returnValue;
   }

   // peek
   // pre: !isEmpty()
   // post: returns item on top of Stack
   public int peek() throws StackEmptyException {
      if( list.size()==0 ){
         throw new StackEmptyException("cannot peek() empty stack");
      }
      return list.get(1);
   }

   // popAll
   // pre: !isEmpty()
   // post: isEmpty()
   public void popAll() throws StackEmptyException{
      if( list.size()==0 ){
         throw new StackEmptyException("cannot popAll() empty stack");
      }
      list.removeAll();
   }

   // toString
   // overrides Object's toString() method
   public String toString() { return list.toString(); }

   // equals
   // overrides Object's equals
   public boolean equals(Object rhs){
      IntegerStack R = null;
      Boolean eq = false;

      if(rhs instanceof IntegerStack){
         R = (IntegerStack)rhs;
         eq = ( this.list.equals(R.list) );
      }
      return eq;
   }
}