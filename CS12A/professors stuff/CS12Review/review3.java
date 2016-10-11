class review3{
	
	public static void main(String [] args){
		//Let's create a new linked list. 
		Node n = new Node(2);
		//Let's add an element next to 2
		n.next = new Node(7);
		//And one after 7.
		n.next.next = new Node(8);
		//Let's print the list!
		System.out.println("Original List");
		printList(n);

		//Let's add a 6 between 7 and 8
		//Store the reference into a temporary variable for easy traversal.
		Node temp = n;
		//Go until there is nothing on the list. 
		while(temp != null){

			//Find if the value is 7
			if(temp.value == 7){
				//Save a reference of the next one so it is not lost
				Node after = temp.next; 
				//Now add 6 as the next one to 7
				temp.next = new Node(6);
				//Add the reference as the neighbor of 6
				temp.next.next = after; 
			}
			//Move to the next pointer. 
			temp = temp.next;
		}
		//The linked list works on references, so temp is a reference to n.
		//And as such we can print N since it's the original list we worked on.
		System.out.println("After Adding 6 to the List");
		printList(n);

		//Let's remove 6. 
		//Store the reference into a temporary variable for easy traversal.
		temp = n;
		while(temp != null){
			//Find if the value after the current is 6, since we need to save the value of the previous reference.
			//We must check that the next element is not null and then check if the next value has 6.
			if(temp.next != null && temp.next.value == 6){
				//Save a reference of the next one after 6 so it is not lost
				Node after = temp.next.next; 
				//Now add 6 as the next one to 7
				temp.next = after;
				//Add the reference as the neighbor of 6 
			}
			//Move to the next pointer. 
			temp = temp.next;
		}
		System.out.println("After Removing 6 from the List");
		printList(n);
	}


	static void printList(Node n){
		//Save n into a temp reference.
		Node temp = n;
		//Iterate through list until you find a null value. 
		while(temp != null){
		//Print out element value.
		System.out.println("The value of this node is: "+temp.value);
		temp = temp.next; 
		}

	}
}