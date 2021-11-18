import java.util.Random; // Reserved for future expansion. 
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
    
    private Random generatedStock = new Random(); // Reserved for future expansion.

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
        
        stock.printAllStock();

        buyProductsDemo(); // Buy Products Function
        stock.printAllStock(); // Print the Stock List

        sellProductsDemo(); // Sell Products Function
        stock.printAllStock(); // Print the Stock List        
    }
    
    private void buyProductsDemo()
    
    {
        stock.buyProduct(101, 10); // Buy Product 101 in 10 quantity
        stock.buyProduct(102, 46); // Buy Product 102 in 46 quantity
        stock.buyProduct(103, 78); // Buy Product 103 in 78 quantity
        stock.buyProduct(104, 92); // Buy Product 104 in 92 quantity
        stock.buyProduct(105, 13); // Buy Product 105 in 13 quantity
        stock.buyProduct(106, 19); // Buy Product 106 in 19 quantity
        stock.buyProduct(107, 41); // Buy Product 107 in 41 quantity
        stock.buyProduct(108, 33); // Buy Product 108 in 33 quantity
        stock.buyProduct(109, 79); // Buy Product 109 in 79 quantity
        stock.buyProduct(110, 57); // Buy Product 110 in 57 quantity
    }

    private void sellProductsDemo()
    {
        stock.sellProduct(101, 5);  // Sell Product 101 in 5 quantity (Normal)
        stock.sellProduct(102, 49); // Sell Product 102 in 49 quantity (Erroneous)
        stock.sellProduct(103, 90); // Sell Product 103 in 90 quantity (Erroneous)
        stock.sellProduct(104, 20); // Sell Product 104 in 20 quantity (Normal)
        stock.sellProduct(105, 10); // Sell Product 105 in 10 quantity (Normal)
        stock.sellProduct(106, 9);  // Sell Product 106 in 9 quantity (Normal)
        stock.sellProduct(107, 100);// Sell Product 107 in 100 quantity (Erroneous)  
        stock.sellProduct(108, 33); // Sell Product 108 in 33 quantity (Boundary)
        stock.sellProduct(109, 43); // Sell Product 109 in 43 quantity (Normal)
        stock.sellProduct(110, 57); // Sell Product 110 in 57 quantity (Boundary)
    }    
}