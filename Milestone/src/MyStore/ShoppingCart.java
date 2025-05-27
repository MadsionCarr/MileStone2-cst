package MyStore;

import java.util.ArrayList;
import java.util.List;
//import SalableProduct.SalableProduct;

import SalableProduct.SalableProduct;

public class ShoppingCart {
	private List<SalableProduct> items;
	private InventoryManager inventoryManager;
	
	public ShoppingCart(InventoryManager inventoryManager) {
		this.inventoryManager = inventoryManager;
		this.items = new ArrayList<>();
	}
	
	public void addItem(SalableProduct product, int quantity) {
		//check is product os in cart already
		for(SalableProduct item: items) {
			if(item.getName().equals(product.getName())) {
				item.setQuantity(item.getQuantity() + quantity);
				return;
			}
		}
		// new instance 
		SalableProduct newItem = new SalableProduct(
				product.getId(), 
				product.getName(),
				product.getDescription(),
				product.getPrice(),
				quantity);
				items.add(newItem);
}
/**
 * remove
 * @param productName
 * from cart
 */
	public void removeItem(String productName) {
		items.removeIf(item -> item.getName().equals(productName));
		System.out.println(productName + " has been removed from cart.");
	}
	
	
	/**
	 * 
	 * @return
	 */
	private double getTotalPrice() {
		// TODO Auto-generated method stub
		double total = 0;
		for(SalableProduct item: items) {
			total += item.getPrice()* item.getQuantity();
		}
		return total;
	}

	/**
	 * 
	 */
	public void checkout() {
		System.out.println("Checkout SUmmary: ");
		for (SalableProduct item : items) {
            SalableProduct inventoryItem = inventoryManager.getProduct(item.getName());
            if (inventoryItem != null && inventoryItem.getQuantity() >= item.getQuantity()) 
            {
                inventoryItem.setQuantity(inventoryItem.getQuantity() - item.getQuantity());
                inventoryManager.updateProduct(inventoryItem);
                System.out.println("Purchased: " + item.getQuantity() + " x " + item.getName());
            } else {
                System.out.println("Insufficient stock for: " + item.getName());
            }
        }
        System.out.println("Total checkout price: $" + getTotalPrice());
        items.clear(); // Empty cart after checkout
    }

	public void viewCart() {
		// TODO Auto-generated method stub
		
	}
		
	}


