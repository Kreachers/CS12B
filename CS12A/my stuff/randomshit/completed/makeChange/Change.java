// MakeChange.java - change in dimes and pennies
import java.util.*; // use Scanner for input

class MakeChange {
    public static void main (String[] args) {
	int price, change, dimes, pennies;
	Scanner scan = new Scanner(System.in);
	System.out.println("type price (0 to 100):");
	price = scan.nextInt();
	change = 100 - price;
	//how much change
	dimes = change / 10;
	//number of dimes
	pennies = change % 10;
	//number of pennies
	System.out.print("The change is :");
	System.out.print(dimes);
	System.out.print(" dimes ");
	System.out.print(pennies);
	System.out.print(" pennies.\n");
    }
}
