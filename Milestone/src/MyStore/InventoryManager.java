package MyStore;

import java.util.ArrayList;
import java.util.List;

import SalableProduct.SalableProduct;

public class InventoryManager {

	private List<SalableProduct> products;
	
	public InventoryManager() {
		this.products = new ArrayList<>();
	}

	public void addProduct(SalableProduct product) {
		products.add(product);
		
	}

	// Method to get a product from the inventory by its name
    public SalableProduct getProduct(String name) {
        for (SalableProduct product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null; // Return null if the product with the given name is not found
    }

	public void updateProduct(SalableProduct updateProduct) {
		// TODO Auto-generated method stub
		for(int i = 0; i <products.size(); i++) {
			if(products.get(i).getId() == updateProduct.getId()) {
				products.set(i,  updateProduct); //update with new product
				return;
			}
		}
		
	}

	public void displayInventory() {
		if(products.isEmpty()) {
			System.out.println("The story inventory is empty. ");
			return;
	
		}
		System.out.println("Store Inventory: ");
		for (SalableProduct product : products) {
			System.out.println("------------");
			System.out.println("ID: " + product.getId());
			System.out.println(" Name: " + product.getName());
			System.out.println(" Description: " + product.getDescription());
			System.out.println(" Price: $" + product.getPrice());
			System.out.println(" Quanitiy Available: " + product.getQuantity());
			System.out.println("-------------");
		}
		
	}

}
