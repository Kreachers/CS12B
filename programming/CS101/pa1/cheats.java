//Donovan Alexander (donalexa)
//PA3
//List.java
//A doubly-linked list ADT

class List{
   private class Node{
     
      //Node Fields node values
      Object data;
      Node prev;
      Node next;

      //Node Constructor makes new nodes
      Node(Object data){
         this.data = data;
         this.prev = null;
         this.next = null;
      }

      //Node toString turns data into a string value
         public String toString() {
         return String.valueOf(this.data);
      }
   }

   //Fields//
   private Node front;
   private Node back;
   private Node cursor;
   private int length;
   private int cursIndex;
   
   //Constructor//
   List() {
      front = null;
      cursor = null;
      back = null;
      length = 0;
      cursIndex = -1;
   }
   
   //Access Functions//
   
   //front() returns front item
   //List must not be empty
   Object front(){
     if(this.isEmpty()){
        throw new RuntimeException("List ADT Error: calling front() on empty List.");
     }
     return front.data;
   }

   //back() returns back item
   //List must not be empty
   Object back(){
      if(this.isEmpty()){
         throw new RuntimeException("List ADT Error: calling back() on empty List.");
      }
      return back.data;
   }
      
   //length() returns the length of the list
   int length(){
      return this.length;
   }
   
   //getIndex() returns index of highlighted element
   //If no highlighted element, return -1
   int getIndex(){
      if (this.isEmpty()){
         System.out.println("List ADT Error: calling getIndex() on empty List.");
      }
      if (cursor == null){
         return -1;
      }
      if(this.cursIndex ==(this.length()-1)){
         return (this.length()-1);
      }
      int j = -1;
      while (cursor != null){
         cursor=cursor.prev;
         j++;
      }
      this.cursIndex = j;
      return this.cursIndex;
   }
   
   //isEmpty() returns true if your list is empty
   boolean isEmpty(){
      return length==0;
   }
   
   //getElement() returns highlighted element in list
   //List can't be empty
   Object getElement(){
      if(this.isEmpty()){
         throw new RuntimeException("List ADT Error: calling getElement() on empty List.");
      }
      if((this.cursIndex<0) || (this.cursIndex>this.length())){
         throw new RuntimeException("List ADT Error: calling getElement() while List's cursor is undefined.");
      }
      else{
         Node temp = this.front;
         for(int i=0; i<cursIndex; i++){
            temp=temp.next;
         }
         this.cursor = temp;
         return this.cursor.data;
      }
   }
   
   //equals() checks to see if two lists are the same
   //If lists are empty they're the same
   public boolean equals(Object x){
      if(this == x){
         return true;
      } else if(x == null){
         throw new RuntimeException("List ADT Error: Calling equals() while referencing a null object");
      }else if(x instanceof List){
         List temp = (List) x;
         if(this.isEmpty() && temp.isEmpty()) return true;
         if(this.length() != temp.length()) return false;
         Node thisTemp = this.front;
         Node xTemp = temp.front;
         for(int i=0; i<this.length(); i++){
            if(thisTemp.data != xTemp.data){
               return false;
            }
            else{
               thisTemp = thisTemp.next;
               xTemp = xTemp.next;
            }
         }
      }
     return true;
   }
   //Manipulation functions//
   
   //clear() resets List to the empty state
   void clear(){
      if(this.length()==0){
         System.out.println("List ADT Mistake: calling clear() on already empty List.");
      }
      else{
         Node curr = this.front;
         Node next = curr.next;
         while(next!=null){
            curr = null;
            curr = next;
            next = curr.next;
         }
         curr = null;
         this.length=0;
      }
   }
   
   //moveTo() moves the cursor to the int given, as long as the int is within the list
   //otherwise the cursor becomes undefined
   void moveTo(int i){
      if(i>=0 && i<=(this.length()-1)){
         int j = 0;
         this.cursor = this.front;
         while (i>0){
            this.cursor = this.cursor.next;
            i--;
            j++;
         }
         this.cursIndex = j;
      }
      else if(i==(this.length()-1)){
         this.cursor = this.back;
         this.cursIndex = (this.length()-1);
      }
      else{
         this.cursor = null;
      }
   }
   
   //movePrev() will move the cursor one step toward the front, if such an element is defined
   //otherwise cursor becomes undefined
   void movePrev(){
      if(this.cursIndex>=0 && this.cursIndex<=(length()-1)){
         this.moveTo(cursIndex-1);
      }
      else if(cursIndex==length()-1 || cursIndex==-1){
         this.cursor = null;
      }
   }
   
   //moveNext() will move the cursor one step toward the back, if such an element is defined
   //otherwise cursor becomes undefined
   void moveNext(){
      if(this.cursIndex>=0 && this.cursIndex<=(length()-1)){
         this.moveTo(cursIndex+1);
      }
      else if(this.cursIndex==(length()-1) || this.cursIndex==-1){
         this.cursor = null;
      }
   }
   
   //prepend() will insert the new element at the front of the list
   void prepend(Object data){
      if(this.isEmpty()){
         this.front = new Node(data);
         this.back = this.front;
         this.length+=1;
      }
      else{
         Node temp = new Node(data);
         temp.prev = null;
         this.front.prev = temp;
         temp.next = this.front;
         this.front = temp;
         this.length+=1;
      }
   }
   
   //append() will insert a new element at the back of the list
   void append(Object data){
      if(this.isEmpty()){
         this.front = new Node(data);
         this.back = this.front;
         this.length+=1;
      }
      else{
         Node temp = new Node(data);
         temp.next = null;
         this.back.next = temp;
         temp.prev = this.back;
         this.back = temp;
         this.length+=1;
      }
   }
   
   //insertBefore() will insert a new element before the cursored element
   //List cannot be empty; cursor must be defined
   void insertBefore(Object data){
      if(this.cursor == null){
         throw new RuntimeException("List ADT Error: calling insertBefore() while List's cursor is undefined.");
      }
      else if(this.cursIndex == 0){
         this.prepend(data);
      }else{
         Node insBef = new Node(data);
         Node temp = this.cursor;
         this.moveTo(cursIndex -1);
         this.cursor.next = insBef;
         this.moveTo(cursIndex+1);
         this.cursor.next = temp;
         this.length+=1;
      }
   }

   
   //insertAfter() will insert a new element after the cursored element
   //List cannot be empty, cursor must be defined
   void insertAfter(Object data){
      if(this.cursor == null){
         throw new RuntimeException("List ADT Error: calling insertAfter() while List's cursor is undefined.");
      }
      else if(this.cursIndex == (this.length()-1)){
         this.append(data);
      }
      else{
         Node insAft = new Node(data);
         Node temp = this.cursor.next;
         this.cursor.next = insAft;
         this.moveTo(cursIndex+1);
         this.cursor.next = temp;
         this.length+=1;
      }
   }
   
   //deleteFront() will remove the front element of the list
   //List cannot be empty
   void deleteFront(){
      if(this.isEmpty()){
         throw new RuntimeException("List ADT Error: calling deleteFront() on empty List.");
      }else{
         this.front = this.front.next;
         this.front.prev = null;
         this.length-=1;
      }
      if(this.getIndex() == 0){
         this.cursIndex = -1;
      }
   }
   
   //deleteBack() will remove the back element of the list
   //List cannot be empty
   void deleteBack(){
      if(this.isEmpty()){
         throw new RuntimeException("List ADT Error: calling deleteBack() on empty List.");
      }else{
         this.back = this.back.prev;
         this.back.next = null;
         this.length-=1;
      }
      if(this.getIndex() == (this.length()-1)){
         this.cursIndex = -1;
      }
   }
   
   //delete() will remove the cursored element
   //List cannot be empty; cursor must be defined
   void delete(){
      if(this.isEmpty()){
         throw new RuntimeException("List ADT Error: calling delete() on empty List.");
      }
      else if(this.cursIndex<0){
         throw new RuntimeException("List ADT Error: calling delete() while List's cursor is undefined.");
      }else if(this.cursIndex==0){
         this.deleteFront();
      }else if(this.cursIndex == (this.length()-1)){
         this.deleteBack();
      }
      else{
         this.moveTo(this.cursIndex-1);
         Node tempPrev = this.cursor;
         this.moveTo(this.cursIndex+2);
         Node tempNext = this.cursor;
         this.moveTo(this.cursIndex);
         this.cursor = null;
         tempPrev.next = tempNext;
         tempNext.prev = tempPrev;
         this.cursIndex = -1;
         this.length--;
      }
   }
   
   //toString() will output the List as a string
   public String toString(){
      if(this.isEmpty()){
         return "";
      }
      else{
         String tempstr = "";
         for(Node temp = this.front;temp!=null; temp=temp.next){
            tempstr += temp.toString() + " ";
         }
         return tempstr;
      }   
   }
  }

