// --------------------------------------------------------
// DictionaryTest.java
// 12B pa3
// 4/24/16
// Test for Dictionary.java to check every part
// --------------------------------------------------------

class DictionaryTest {
	public static void main(String[] args) {
		Dictionary A = new Dictionary();
		System.out.println(A.isEmpty());
		A.insert("1", "a");
		System.out.println(A.isEmpty());
		System.out.println("Size of list: " + A.size());
		A.insert("2", "b");
		A.insert("3", "c");
		A.insert("4", "d");
		A.insert("5", "e");
		A.insert("6", "f");
		System.out.println(A.toString());
		System.out.println("Size of list: " + A.size());
		A.delete("4");
		System.out.println(A.toString());
		System.out.println("Size of list: " + A.size() + "\n");
		System.out.println("********************************\n");
		try {
			A.insert("6", "Duplicate"); // Throws DuplicateKeyException
		} catch(DuplicateKeyException e) {
			System.out.println("Caught Exception " + e);
        	System.out.println("Continuing without interuption \n");
		}
		A.insert("4", "Reinserted");
		System.out.println(A);
		A.makeEmpty();
		System.out.println("Size of list: " + A.size() + "\n");
		try {
			A.delete("4"); //Throws KeyNotFoundException
		} catch(KeyNotFoundException e) {
			System.out.println("Caught Exception " + e);
        	System.out.println("Continuing without interuption");
		}

	}
}

/*OUTPUT

true
false
Size of list: 1
1 a
2 b
3 c
4 d
5 e
6 f

Size of list: 6
1 a
2 b
3 c
5 e
6 f

Size of list: 5

********************************

Caught Exception DuplicateKeyException

1 a
2 b
3 c
5 e
6 f
4 Reinserted

Size of list: 0

Caught Exception KeyNotFoundException
*/
