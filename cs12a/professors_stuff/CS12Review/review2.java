class review2{
	
	//Let's do some cool things with the fruit example. 
	public static void main(String [] args){
		//An orange with 3 dank memes. 
		Fruit f = new Fruit("Orange",3);
		//Banana with 6 dank memes who is also dat boi.
		Banana b = new Banana("Banana",6,true);
		//A Green banana with 10 dank memes who is sadly not dat boi.
		GreenBanana g = new GreenBanana("Green Banana",10,false,"Green");

		//Let's see how many dank memes each fruit has.
		f.dank();
		b.dank();
		g.dank();

		//If we remember inheritance, classes that extend can use the methods of their parents.
		//In this case b and g use the dank() method defined in Fruit.java.
		//Let's see what happens when the banana and the green banana asks if it is dat boi.
		b.hereComesDatBoi(b.isDatBoi);
		g.hereComesDatBoi(g.isDatBoi);
		//Same as above, we can call the super methods in a sub class.

		//Can we call methods on a sub class if it asks for a super class?
		whoAmI(f);
		whoAmI(b);
		whoAmI(g);
		//Turns out that we can, since they are all fruits by extension. 

		//Try accessing the methods of super classes and the attributes of sub classes and see what works.
		//Uncomment these to see some things fail.
		//Super classes cant access subclass methods. For instance, a fruit can't access the properties of a banana.
		//f.hereComesDatBoi(f.isDatBoi);

	}

	//This method takes a fruit and says something.
	static void whoAmI(Fruit f){
		System.out.println("Hi I am a fruit, and I am of type"+f.name);

	}
}