//-----------------------------------------------------------------------------
// IntegerList.java
// A fully recursive version of the IntegerList ADT,  i.e. the IntegerList
// Object itself is defined recursively.
//-----------------------------------------------------------------------------

public class IntegerList implements IntegerListInterface {

   // Fields for the IntegerList class
   private Integer     firstItem;    // first item in this IntegerList
   private IntegerList otherItems;   // IntegerList of remaining items
   private int         numItems;     // number of items in this IntegerList

   // IntegerList()
   // constructor for the IntegerList class
   public IntegerList(){
      firstItem = null;
      otherItems = null;
      numItems = 0;
   }


   // private helper functions ------------------------------------------------

   // shallowCopy()
   // returns a shallow copy this IntegerList, used by add()
   private IntegerList shallowCopy(){
      IntegerList L = new IntegerList();
      L.firstItem  = this.firstItem;
      L.otherItems = this.otherItems;
      L.numItems   = this.numItems;
      return L;
   }

   // toStringBuffer()
   // returns StringBuffer representation of this IngeterList,  used by 
   // toString()
   private StringBuffer toStringBuffer(){
      if(numItems==0){
         return new StringBuffer();
      }else{
         return otherItems.toStringBuffer().insert(0,firstItem+" ");
      }
   }

   // listEquals()
   // returns true if this IntegerList equals R, assumes both lists have the
   // same length, used by equals()
   private boolean listEquals(IntegerList R){
      if(numItems==0){
         return true;
      }else if(firstItem==R.firstItem){
         return otherItems.listEquals(R.otherItems);
      }else{
         return false;
      }

   }


   // ADT operations ----------------------------------------------------------

   // isEmpty()
   // pre: none
   // post: returns true if this IntgerList is empty, false otherwise
   public boolean isEmpty(){
      return(numItems == 0);
   }

   // size()
   // pre: none
   // post: returns the number of elements in this IntegerList
   public int size() {
      return numItems;
   }

   // get()
   // pre: 1 <= index <= size()
   // post: returns item at position index in this IntegerList
   public int get(int index) throws ListIndexOutOfBoundsException {
      if( index<1 || index>numItems ){
         throw new ListIndexOutOfBoundsException(
            "IntegerList Error: get() called on invalid index: " + index);
      }

      if(index==1){
         return firstItem;
      }else{
         return otherItems.get(index-1);
      }
   }

   // add()
   // inserts newItem into this IntegerList at position index
   // pre: 1 <= index <= size()+1
   // post: !isEmpty(), items to the right of newItem are renumbered
   public void add(int index, int newItem) throws ListIndexOutOfBoundsException{
      if( index<1 || index>(numItems+1) ){
         throw new ListIndexOutOfBoundsException(
            "IntegerList Error: add() called on invalid index: " + index);
      }

      if(index==1){
         IntegerList C = this.shallowCopy();
         firstItem = newItem;
         otherItems = C;
      }else{
         otherItems.add(index-1, newItem);
      }
      numItems++;
   }

   // remove()
   // deletes item at position index from this IntegerList
   // pre: 1 <= index <= size()
   // post: items to the right of deleted item are renumbered
   public void remove(int index)
      throws ListIndexOutOfBoundsException{
      if( index<1 || index>numItems ){
         throw new ListIndexOutOfBoundsException(
            "IntegerList Error: remove() called on invalid index: " + index);
      }

      if(index==1){
         firstItem = otherItems.firstItem;
         otherItems = otherItems.otherItems;
      }else{
         otherItems.remove(index-1);
      }
      numItems--;
   }

   // removeAll()
   // pre: none
   // post: isEmpty()
   public void removeAll(){
      firstItem = null;
      otherItems = null;
      numItems = 0;
   }


   // other methods -----------------------------------------------------------

   // toString()
   // pre: none
   // post:  prints current state to stdout
   // Overrides Object's toString() method
   public String toString(){
      return new String(this.toStringBuffer());
   }


   // equals()
   // pre: none
   // post: returns true if this IntegerList matches rhs, false otherwise
   // Overrides Object's equals() method
   public boolean equals(Object rhs){
      boolean eq = false;
      IntegerList R = null;

      if(rhs instanceof IntegerList){
         R = (IntegerList)rhs;
         if(this.numItems==R.numItems){
            eq = this.listEquals(R);
         }
      }
      return eq;
   }

}