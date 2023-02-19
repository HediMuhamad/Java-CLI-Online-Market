
public class CartObj {
	int id;
	String name;
	float price;
	int quantity;
	float cost;
	
	CartObj(int id, int quantity){
		this.id = StoreItems.id[id];
		this.name = StoreItems.name[id];
		this.price = StoreItems.price[id];
		this.quantity = quantity;
		this.cost = quantity*price;
	}

	
	
}
