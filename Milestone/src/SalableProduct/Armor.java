package SalableProduct;

public class Armor extends SalableProduct {

	private int defenseRating;

	public Armor(int productId, String name, String description, double price, int quantity, int defenseRating) {
		super(productId, name, description, price, quantity);
		this.defenseRating = defenseRating;
		// TODO Auto-generated constructor stub
	}
	
	public int getDefenseRating() {
		return defenseRating;
	}

}
