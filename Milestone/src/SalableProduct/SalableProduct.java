package SalableProduct;


	//SalableProduct class represents a product that is available for sale in the store.
public class SalableProduct {
	    private int productId;
	    private String name;
	    private String description;
	    private double price;
	    private int quantity;
	    
	    // Constructor to initialize a SalableProduct 
	    public SalableProduct(int productId, String name, String description, double price, int quantity) {
	        this.productId = productId;
	        this.name = name;
	        this.description = description;
	        this.price = price;
	        this.quantity = quantity;
	    }

	    // Getters and setters for SalableProduct attributes
	    public int getId() {
	        return productId;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getDescription() {
	        return description;
	    }
	    public void setPrice(double price) {
	    	this.price = price;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

		
	}


