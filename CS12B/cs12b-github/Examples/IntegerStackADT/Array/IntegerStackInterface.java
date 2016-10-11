//-----------------------------------------------------------------------------
// IntegerStackInterface.java
// interface for the IntegerStack ADT
//-----------------------------------------------------------------------------

public interface IntegerStackInterface{

   // isEmpty
   // returns true if this IntgerStack is empty, false otherwise
   // pre: none
   public boolean isEmpty();

   // push
   // pushes x onto top of this IntegerStack
   // pre: none
   public void push(int x);

   // pop
   // deletes and returns item from top of Stack
   // pre: !isEmpty()
   public int pop() throws StackEmptyException;

   // peek
   // returns item on top of Stack
   // pre: !isEmpty()
   public int peek() throws StackEmptyException;

   // popAll
   // sets stack to its original empty state
   // pre: !isEmpty()
   public void popAll() throws StackEmptyException;
}