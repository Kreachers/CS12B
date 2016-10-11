//This was Apple in the board example, but it seems a bit counter intuitive.
//So I changed to a green banana as it seems more appropiate. 
//The green banana extends from banana which extends from fruit. 
class GreenBanana extends Banana{
	String color; 

	GreenBanana(){}

	GreenBanana(String name, int dankMemes, boolean isDatBoi, String color){
		this.name = name; 
		this.dankMemes = dankMemes; 
		this.isDatBoi = isDatBoi;
		this.color = color; 
	}

}