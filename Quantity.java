import java.util.ArrayList;
import java.util.*;

public class Quantity {
	static ArrayList<CartObj> cart = Customers.cart;
	
	static int quantity(int ID){
		int quantity=0;
		try {
			System.out.print("Enter the quantity that you want to order: ");
			quantity = new Scanner(System.in).nextInt();
			
			if(quantity>StoreItems.quantity[ID] || quantity<0) {
				System.out.println("Out of quantity.");
				quantity=quantity(ID);
			}
			return quantity;
		}catch (Exception e) {
			System.out.println("INPUT ERROR, your input isn't Integer number.");
			quantity=quantity(ID);
		}
		return 0;
	}


	static void changeQuantity(int id, int changeQuantity){
			for(int i=0;i<cart.size();i++) {
				if(id==cart.get(i).id) {
					int currentQuantity = cart.get(i).quantity;
					if(changeQuantity==0) {
						cart.remove(i);
					}
					else {
						cart.get(i).quantity=changeQuantity;
						cart.get(i).cost=cart.get(i).price*changeQuantity;
					}
					StoreItems.encreasingStoreQuantity(id-1, currentQuantity-changeQuantity);
					CartProcess.showCart();
					return;
				}
			}
			System.out.println("Theres no item with ("+id+") ID.");
			CartProcess.showCart();
	}
}
