package SalableProduct;

public class Weapon extends SalableProduct {
	private int attackPower;
	/**
	 * 
	 * @param productId
	 * @param name
	 * @param description
	 * @param price
	 * @param quantity
	 */
	public Weapon(int productId, String name, String description, double price, int quantity, int attackPower) {
		super(productId, name, description, price, quantity);
		this.attackPower = attackPower;
	
	}
	/**
	 * 
	 * @return attack power
	 */
	public int getAttackPower() {
		
		return attackPower;
	}

}
