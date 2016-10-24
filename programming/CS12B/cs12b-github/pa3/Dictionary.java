// ----------------------------------------------------------------------------------
// Dictionary.java
// 12B pa3
// 4/24/16
// Dictionary implementation of ADT using nodes
// ----------------------------------------------------------------------------------


public class Dictionary implements DictionaryInterface {
	private class Node {
		String key;
		String value;
		Node next;

		Node (String key, String value) {
			this.key = key;
			this.value = value;
			next = null;
		}
	}

	// Fields for Dictionary class
	private Node head;
	private int numItems;

	// Constructor for Dictionary class
	public Dictionary() {
		head = null;
		numItems = 0;
	}

	// Private Functions --------------------------------------

	// findKey()
	private Node findKey(String key) {
		Node N = head;
		while(N != null) {
			if(N.key != key) {
				N = N.next;
			} else return N;
		}
		return null;
	}

	// myString()
	/*private String myString(Node H) {
		if (H == null)
			return "";
		else
			return H.key + " " + H.value + "\n" + myString(H.next);
	}*/

	// ADT Operations -----------------------------------------

	// isEmpty()
	public boolean isEmpty() {
		return (numItems == 0);
	}

	// size()
	public int size() {
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
	public void insert(String key, String value) throws DuplicateKeyException {
		if (lookup(key) != null) {
			throw new DuplicateKeyException("cannot insert duplicate keys");
		} else {
			if (head == null) {
				Node N = new Node(key, value);
				head = N;
			} else {
				Node N = head;
				while(N != null){
					if (N.next == null) break;
					N = N.next;
				}
				N.next = new Node(key, value);
			}
			numItems++;
		}
	}

	// delete()
	public void delete(String key) throws KeyNotFoundException {
		if (lookup(key) == null) {
			throw new KeyNotFoundException("cannot delete non-existent key");
		} else {
			if (numItems <= 1) {
				Node N = head;
				head = head.next;
				N.next = null;
				//numItems--;
			} else {
				Node N = head;
				if (N.key.equals(key)) {
					head = N.next;
					//numItems--;
				} else {
					while(!N.next.key.equals(key))
						N = N.next;
					N.next = N.next.next;
					//numItems--;
				}
			}
			numItems--;
		}
	}

	// makeEmpty()
	public void makeEmpty() {
		head = null;
		numItems = 0;
	}

	// toString()
	public String toString() {
		//return myString(head);
		String s = "";
		Node N = head;
		while(N != null) {
			s += N.key + " " + N.value + "\n";
			N = N.next;
		}
		return s;
	}
}
