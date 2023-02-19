import java.util.*;

public class CartProcess {
	static ArrayList<CartObj> cart = Customers.cart;
	static Scanner scanner = new Scanner(System.in);
	
	static void addToCart(int id, int quantity){
		for(int i=0;i<cart.size();i++) {
			if(cart.get(i).id-1==id) {
				cart.get(i).quantity+=quantity;
				cart.get(i).cost+=(quantity*cart.get(i).price);
				return;
			}	
		}
		
		cart.add(new CartObj(id, quantity));

	}
	

	static void showCart(){
		float costOfAllItems=0;
		
		System.out.println("\n==================================================\n");
		System.out.printf("%-2s : %-26s : %-4s : %-4s : %-6s \n", "ID", "Name", "Price", "Quantity", "Cost");
				
		for(int i=0;i<cart.size();i++){
			CartObj showingCart = (CartObj) cart.get(i);
			System.out.printf("%-2s : %-26s : %-4s$ : %-8s : %-6s$ \n", showingCart.id, showingCart.name, showingCart.price, showingCart.quantity, showingCart.cost);
			
			costOfAllItems+=showingCart.cost;
		}
		
		addCheckoutChange(costOfAllItems);
		
	}
	
	static void addCheckoutChange(float costOfAllItems) {
		System.out.println("\nThe cost of ("+cart.size()+") item\\items which is\\are you picked is ("+costOfAllItems+"$)");
		System.out.print("\n1: to continue in buying.\n2: to checking out the items.\n3: to change items quantity.\nWrite: ");
		try {
			switch(new Scanner(System.in).nextInt()) {
				case 1:
					System.out.println("\n==================================================\n");
					Customers.showTheList();
					break;
				case 2:
					System.out.print("Write The MasterCard Code: ");
					long code = scanner.nextLong();
					System.out.print("Write The CVV: ");
					int cvv = scanner.nextInt();
					System.out.print("Write The expiration month: ");
					int expirationMonth = scanner.nextInt();
					System.out.print("Write The expiration year: ");
					int expirationYear = scanner.nextInt();
					System.out.print("Write Card Holder Name: ");
					String cardHolder = scanner.nextLine();
					
					MasterCard master = new MasterCard(code, cvv, expirationMonth, expirationYear, cardHolder);
					master.payment(costOfAllItems);
					break;
				case 3:
					System.out.print("\nPlease enter \'ID\': ");
					int id= scanner.nextInt();
					System.out.println("Enter \'value\' of the quantity: ");
					int quantityValue= scanner.nextInt();
					Quantity.changeQuantity(id, quantityValue);
					break;
				default:
					System.out.println("INPUT ERROR, USER INTEGER");
					CartProcess.showCart();
					break;
					
			}
		}catch(Exception e) {
			System.out.println("INPUT ERROR, USER INTEGER");
			CartProcess.showCart();
		}
	}
}
