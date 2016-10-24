class Fruit{
	String name;
	int dankMemes;

	Fruit(){}

	Fruit(String name, int dankMemes){
	this.name = name;
	this.dankMemes = dankMemes;
	}

	void dank(){
		System.out.println("This fruit is of type:"+this.name+" and it has "+this.dankMemes+" dank memes");
	}
}