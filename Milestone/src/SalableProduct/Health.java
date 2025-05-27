package SalableProduct;

public class Health extends SalableProduct {
	private int healAmount;

	public Health(int productId, String name, String description, double price, int quantity, int healAmount) {
		super(productId, name, description, price, quantity);
		this.healAmount = healAmount;
		// TODO Auto-generated constructor stub
	}
	
	public int getHealAmount() {
		return healAmount;
	}


}
