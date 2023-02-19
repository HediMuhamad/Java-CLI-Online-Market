import java.util.*;

public class Customers {
	static ArrayList<CartObj> cart = new ArrayList<CartObj>();
	
	Customers(){
		/* Programmed By: Hedi M. Sharif, Honer H. Ibrahim, Eisa M. Hassan*/
		System.out.print("Welcome to Online Electrical Company(OEC).\n");
		showTheList();
	}
	
	static void showTheList() {

		System.out.printf("%-2s : %-26s : %-4s : %-4s \n", "ID", "Name", "Price", "Quantity");
		
		for(int i=0;i<StoreItems.id.length;i++){
			System.out.printf("%-2s : %-26s : %-4s$ : %-8s \n", StoreItems.id[i], StoreItems.name[i], StoreItems.price[i], StoreItems.quantity[i]);
		}
		buy();
	}
	
	
	static void buy(){
		Scanner scanner = new Scanner(System.in);
		
		int ID=0;
		int quantity=0;
		
		System.out.print("\nPlease enter the ID of the items which you want: ");
		
		try {
 			int id = scanner.nextInt(10);
			
			if(id>10 || id<1) {
				System.out.println("Invalid ID, Program restarted.\n\n");
				Main.main(null);
			}
			
			else {
				ID=id-1;
				while(quantity==0)
					quantity = Quantity.quantity(ID);
			}
		}catch (Exception e) {
			System.out.println("INPUT ERROR, your input isn't Integer number.\n\n");
			Main.main(null);
		}
		
		CartProcess.addToCart(ID, quantity);
		StoreItems.decreasingStoreQuantity(ID, quantity);
		CartProcess.showCart();
			
		
	}
	
	

	
	
}
