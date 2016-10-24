//-----------------------------------------------------------------------------
// IntegerList.java
// Array based implementation of IntegerList ADT with Exceptions & Interface
//-----------------------------------------------------------------------------

public class IntegerList implements IntegerListInterface{

   public static final int MAX_LENGTH = 1000; // Maximum IntegerList length
   private int[] item;                        // array of IntegerList items
   private int numItems;                // number of items in this IntegerList

   // IntegerList
   // default constructor for the IntegerList class
   public IntegerList(){
      item = new int[MAX_LENGTH];
      numItems = 0;
   }

   // arrayIndex
   // transforms a List index to an Array index
   private int arrayIndex(int listIndex){
      return listIndex-1;
   }

   // isEmpty
   // pre: none
   // post: returns true if this IntgerList is empty, false otherwise
   public boolean isEmpty(){
      return(numItems == 0);
   }

   // size
   // pre: none
   // post: returns the number of elements in this IntegerList
   public int size() {
      return numItems;
   }

   // get
   // pre: 1 <= index <= size()
   // post: returns item at position index
   public int get(int index) throws ListIndexOutOfBoundsException {  
      
      if( index<1 || index>numItems ){
         throw new ListIndexOutOfBoundsException(
            "IntegerList: get() called on invalid index");
      }
      
      return item[arrayIndex(index)];
   }

   // add
   // inserts newItem in this IntegerList at position index
   // pre: size() < MAX_LENGTH, 1 <= index <= size()+1
   // post: !isEmpty(), items to the right of newItem are renumbered
   public void add(int index, int newItem) 
      throws ListFullException, ListIndexOutOfBoundsException {
      
      if( numItems == MAX_LENGTH ){
         throw new ListFullException(
            "IntegerList: add() called on full list");
      }
      if( index<1 || index>(numItems+1) ){
         throw new ListIndexOutOfBoundsException(
            "IntegerList: add() called on invalid index");
      }
      for(int i=numItems; i>=index; i--) {
         item[arrayIndex(i+1)] = item[arrayIndex(i)];
      }
      item[arrayIndex(index)] = newItem;
      numItems++;
   }

   // remove
   // deletes item from position index
   // pre: 1 <= index <= size()
   // post: items to the right of deleted item are renumbered
   public void remove(int index)
      throws ListIndexOutOfBoundsException{
      
      if( index<1 || index>numItems ){
         throw new ListIndexOutOfBoundsException(
            "IntegerList: remove() called on invalid index");
      }
      
      for(int i=index+1; i<=numItems; i++){
         item[arrayIndex(i-1)] = item[arrayIndex(i)];
      }
      numItems--;
   }

   // removeAll
   // pre: none
   // post: isEmpty()
   public void removeAll(){
      numItems = 0;
   }

   // toString
   // pre: none
   // post:  prints current state to stdout
   // Overrides Object's toString() method
   public String toString(){
      int i;
      StringBuffer sb = new StringBuffer();

      for(i=0; i<numItems; i++) sb.append(item[i]).append(" ");
      return new String(sb);
   }

   // equals
   // pre: none
   // post: returns true if this IntegerList matches rhs, false otherwise
   // Overrides Object's equals() method
   public boolean equals(Object rhs){
      int i = 0;
      boolean eq = false;
      IntegerList R = null;

      if(rhs instanceof IntegerList){
         R = (IntegerList)rhs;
         eq = (this.numItems == R.numItems);
         while(eq && i<numItems){
            eq = (this.item[i] == R.item[i]);
            i++;
         }
      }
      return eq;
   }

}