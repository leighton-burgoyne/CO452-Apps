
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo()
    {
        this.stock = new StockList();
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "Steelseries Apex Keyboard"));
        stock.add(new Product(102, "Airpods Pro with Charging Case"));
        stock.add(new Product(103, "32GB SanDisk USB Drive"));
        stock.add(new Product(104, "Razer Gaming Mouse"));
        stock.add(new Product(105, "Apple iPhone 13 Pro Max 256GB"));
        stock.add(new Product(106, "Google Pixel 6 Pro 128GB"));
        stock.add(new Product(107, "Lenovo Gaming Laptop Ryzen 5 8GB RAM 256GB SSD"));
        stock.add(new Product(108, "Dell 27 Inch Monitor 1920x1080 60Hz"));
        stock.add(new Product(109, "USB-C Charging Cable 2M"));
        stock.add(new Product(110, "Apple Lightning Cable 1M"));
        
        runDemo(); // Runs the Demo Function
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        stock.print();

        buyProducts(); // Buy Products Function
        stock.print(); // Print the Stock List

        sellProducts(); // Sell Products Function
        stock.print(); // Print the Stock List        
    }
    
    private void buyProducts()
    
    {
        stock.buyProduct(101, 500); // Buy Product 101 as 500
    }

    private void sellProducts()
    {
        // sellProducts()
    }    
}