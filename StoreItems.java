
public class StoreItems {
	static int[] id = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	static String[] name = {"Contactor 3-Phase", "Contactor 1-Phase", "Circuit-breaker 3-Phase", "Circuit-breaker 1-Phase", "AC-Relay 220V", "DC-Relay 12V", "Digital-Timer", "Cyclometer 3-Phase", "Cyclometer 1-Phase", "Power-Board (60cm × 80cm)"};
	static float[] price = {20, 15, 30, 20, 7, 6, 17, 60, 40, 40};
	static int[] quantity = {50, 60, 45, 70, 30, 30, 25, 40, 45, 30};
	
	static void decreasingStoreQuantity(int id, int decrement){
		StoreItems.quantity[id]-=decrement;
	}
	
	static void encreasingStoreQuantity(int id, int encrement){
		StoreItems.quantity[id]+=encrement;
	}

}
