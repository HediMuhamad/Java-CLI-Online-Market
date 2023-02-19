import java.util.Random;

public class MasterCard {
	private float balance;
	private int expirationYear;
	private int expirationMonth;
	private int cvv;
	private long code;
	private String cardHolder;
	
	public MasterCard(long code, int cvv, int expirationMonth, int expirationYear, String cardHolder) {
		this.code=code;
		this.cvv=cvv;
		this.expirationMonth=expirationMonth;
		this.expirationYear=expirationYear;
		this.cardHolder=cardHolder;
		this.balance = new Random().nextInt(10000);
		
	}
	
	float getBalance() {
		return balance;
	}
	
	void payment(float reducing) {
		if(balance==0) {
			System.out.println("\nYour Balance is 0$, we can't proccess your order.\nThe program is closed.");
			System.exit(0);
		}
		else if(balance>=reducing) {
			balance-=reducing;
			System.out.println("Your Order is in proccess.\nTHANKS FOR USING OUR ONLINE SYSTEM <3\nGOODBYE, SEE YOU LATER...");
		}
		else {
			System.out.println("Your Balance is ("+balance+"$), please reduce your order items.");
			return;
		}
	}
}
