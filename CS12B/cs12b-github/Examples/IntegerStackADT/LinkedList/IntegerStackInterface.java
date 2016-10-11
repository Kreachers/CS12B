//-----------------------------------------------------------------------------
// IntegerStackInterface.java
// interface for the IntegerStack ADT
//-----------------------------------------------------------------------------

public interface IntegerStackInterface{

   // isEmpty
   // pre: none
   // post: returns true if this IntgerStack is empty, false otherwise
   public boolean isEmpty();

   // push
   // pushes x onto top of this IntegerStack
   // pre: none
   // post: !isEmpty()
   public void push(int x);

   // pop
   // deletes and returns item from top of Stack
   // pre: !isEmpty()
   // post: this Stack will have one fewer element
   public int pop() throws StackEmptyException;

   // peek
   // pre: !isEmpty()
   // post: returns item on top of Stack
   public int peek() throws StackEmptyException;

   // popAll
   // pre: !isEmpty()
   // post: isEmpty()
   public void popAll() throws StackEmptyException;
}