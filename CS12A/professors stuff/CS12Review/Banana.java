class Banana extends Fruit{
	
	boolean isDatBoi; 

	Banana(){}
	//Since it extends Fruit, it already has a .name and a .dankMemes attribute.
	Banana(String name, int dankMemes, boolean isDatBoi){
		this.name = name; 
		this.dankMemes = dankMemes;
		this.isDatBoi = isDatBoi;
	}

	void hereComesDatBoi(boolean isDatBoi){
		if(isDatBoi){
			System.out.println("O S*** WADDUP!");
		}
		else{
			System.out.println(":(");
		}
	}
}