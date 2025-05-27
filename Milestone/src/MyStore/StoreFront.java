package MyStore;

import java.util.Scanner;

import SalableProduct.Armor;
import SalableProduct.Health;
import SalableProduct.SalableProduct;
import SalableProduct.Weapon;


//StoreFront class represents the front-end of the store, managing inventory and purchases.
public class StoreFront {
 private InventoryManager inventoryManager; // Private attribute to manage inventory

 // Constructor initializes the InventoryManager
 public StoreFront() {
    inventoryManager = new InventoryManager();
 }

 // Method to initialize the store with sample products
 public void initializeStore() {
	    inventoryManager.addProduct(new Weapon(1, "Sword", "A sharp steel sword", 299.99, 5, 50));
	    inventoryManager.addProduct(new Weapon(2, "Bow", "A long-range bow", 199.99, 4, 35));
	    inventoryManager.addProduct(new Armor(3, "Helmet", "A protective steel helmet", 99.99, 6, 25));
	    inventoryManager.addProduct(new Armor(4, "Shield", "A sturdy battle shield", 149.99, 3, 40));
	    inventoryManager.addProduct(new Health(5, "Health Potion", "Restores 50 HP", 49.99, 10, 50));
	}
 
 public InventoryManager getInventoryManager() {
	 return inventoryManager;
 }


 /**
  * method for 
  * @param productName
  * @return
  */
 public boolean purchaseProduct(String productName) {
    
	 SalableProduct product = inventoryManager.getProduct(productName);
     // Checks if the product exists in inventory and has available quantity
     if (product != null && product.getQuantity() > 0) {
         product.setQuantity(product.getQuantity() - 1); // Decrease quantity after purchase
         inventoryManager.updateProduct(product);
         //update user
         System.out.println("Successfully purchased: " + product.getName() + " for $" + product.getPrice());
         return true; // Return true indicating successful purchase
     }
     System.out.println("Purchase failed " + productName + " is out of stock" + product.getQuantity() + " or does not exist.");
     return false; // Return false indicating failed purchase
 }

 // Method to cancel a purchase and return the product to inventory
 public boolean cancelPurchase(String productName) {
     // Implement cancel purchase
	 SalableProduct product = inventoryManager.getProduct(productName);
     // Checks if the product exists in inventory
	 if (product != null) {
		product.setQuantity(product.getQuantity() +1 );
		inventoryManager.updateProduct(product);// update quantity after cancellation
	 
         return true; // Return true for successful cancellation
     }
     return false; // Return false for failed cancellation
 }
 
 public static void main(String[] args) {
     // Create an instance of InventoryManager
	 StoreFront store = new StoreFront();
	 store.initializeStore();
	 
	 //Create shopping cart
	 ShoppingCart cart = new ShoppingCart(store.getInventoryManager());
	 Scanner scanner = new Scanner(System.in);
	 
	 //welcome
	 System.out.println("Welcome to my Store Front!");
	 
	 /**
	  * display menu
	  */
	 while (true) {
		 System.out.println("/nSelect and Option:");
		 System.out.println("1: View Inventory");
		 System.out.println("2: Add Item to cart");
		 System.out.println("3: Remove Item");
		 System.out.println("4: View Cart");
		 System.out.println("5: Checkout");
		 System.out.println("6: Exit");
		 
		 int choice = scanner.nextInt();
		 scanner.nextLine(); 
		 
		 switch (choice) {
		 case 1:
			 store.getInventoryManager().displayInventory();
			 break;
		 case 2:
			 System.out.println("Enter product name to add: ");
			 String ItemName = scanner.nextLine();
			 SalableProduct item = store.getInventoryManager().getProduct(ItemName);
			 if(item != null) {
				 cart.addItem(item,choice);
				 System.out.println(ItemName + " Added to cart");
			 } else {
				 System.out.println(" Product not found");
			 }
			 break;
		 case 3:
			 System.out.println("Enter product name to remove: ");
			 String removeProduct = scanner.nextLine();
			 cart.removeItem(removeProduct);
			 break;
		 case 4:
			 System.out.println(" Cart Contents: ");
			 cart.viewCart();
			 break;
		 case 5:
			 cart.checkout();
			 break;
		 case 6:
			 System.out.println("Thank you for visiting my store, come back soon!");
			 scanner.close();
			 return;
		default:
			System.out.println("Invalid selection, please try again");
			 
		 }
	 }
     
 }
}
