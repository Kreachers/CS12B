// ----------------------------------------------------------------------------------
// List.java
// CS101
// Devin Siems
// List implementation of ADT using nodes
// ----------------------------------------------------------------------------------


public class List{

	// Fields for the IntegerList class
	private Node head;     // reference to first Node in List
	private Node tail;
	private Node cursor;
	private int numItems;  // number of items in this IntegerList
	private int cursIndex;

	public List(){
		head = null;
		tail = null;
		numItems = 0;
		cursIndex = -1;
		cursor = null;
	}

	// private inner Node constructor class
	private class Node {
		Object data;
		Node next;
		Node previous;

		Node(String key, String value){
			this.data = null;
			this.next = null;
			this.previous = null;
		}
	}
	
	// ADT operations ----------------------------------------------------------

	//front() returns first item
	//List must not be empty
	Object front(){
		if(this.isEmpty()){
			throw new RuntimeException("List ADT Error: calling front() on empty List.");
		}
		return head.data;
	}

	//back() returns last item
	//List must not be empty
	Object back(){
		if(this.isEmpty()){
			throw new RuntimeException("List ADT Error: calling back() on empty List.");
		}
		return tail.data;
	}

	// isEmpty()
	public boolean isEmpty(){
		return(numItems == 0);
	}

	// size()
	public int length(){
		return numItems;
	}

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
			cursor=cursor.previous;
			j++;
		}
		return j;
	}

	
	
	// insert()
	public void insert(String key, String value){

		if(lookup(key) != null) throw new RuntimeException("");
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
			sb.append(N.data + "\n");
		}
		return new String(sb);
	}
}

