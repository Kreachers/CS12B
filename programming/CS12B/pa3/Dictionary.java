// ----------------------------------------------------------------------------------
// Dictionary.java
// 12B pa3
// 10/28/16
// Dictionary implementation of ADT using nodes
// ----------------------------------------------------------------------------------


public class Dictionary implements DictionaryInterface{

  // Fields for the IntegerList class
  private Node head;     // reference to first Node in List
  private int numItems;  // number of items in this IntegerList

  public Dictionary(){ 
    head = null;
    numItems = 0;   
  }

  // private inner Node class
  private class Node {
    String key;
    String value;
    Node next;

    Node(String key, String value){
      this.key = key;
      this.value = value;
      next = null;
    }
  }

  // private helper function -------------------------------------------------

  // findKey()
  // returns a reference to the Node at position index in this IntegerList
  private Node findKey(String key){
    Node N = head;
    while(N != null) {
      if(N.key != key) {
        N = N.next;
      } else return N;
    }
    return null;
  }

  // ADT operations ----------------------------------------------------------

  // isEmpty()
  public boolean isEmpty(){
    return(numItems == 0);
  }

  // size()
  public int size(){
    return numItems;
  }

  // lookup()
  public String lookup(String key) {
    Node N = findKey(key);
    //Node N = head;
    while (N != null) {
      if (N.key.equals(key)) 
        return N.value;
      N = N.next;
    }
    return null;
  }

  // insert()
  public void insert(String key, String value){

    if(lookup(key) != null) throw new DuplicateKeyException();
    else{
      if (head == null) {
        Node N = new Node(key, value);
        head = N;
      } else {
        Node N = head;
        for(int i = 1; i < numItems; i++){
          if (N.next == null) break;
          N = N.next;
        }
        N.next = new Node(key, value);
      }
      numItems++;
    }
  }

  // delete()
  public void delete(String key){
    if(lookup(key) == null)throw new KeyNotFoundException();
    else{
      if (numItems <= 1) {
        Node N = head;
        head = head.next;
        N.next = null;
      } else {
        Node N = head;
        if (N.key.equals(key)) {
          head = N.next;
        } else {
          while(!N.next.key.equals(key))
            N = N.next;
          N.next = N.next.next;
        }
      }
      numItems--;
    }
  }

  // makeEmpty()
  public void makeEmpty(){
    head = null;
    numItems = 0;
  }

  // toString()
  public String toString(){
    StringBuffer sb = new StringBuffer();
    Node N = head;

    for( ; N != null; N = N.next){
      sb.append(N.key + " " + N.value + "\n");
    }
    return new String(sb);
  }
}


