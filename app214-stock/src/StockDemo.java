import java.util.Random; // Reserved for future expansion. 
/**
 * Demonstrate the StockManager and Product classes. The demonstration becomes properly functional as the StockManager
 * class is completed.
 * 
 * @author David J. Barnes and Michael Kölling (1.0), Modified by Leighton Burgoyne (2.0)
 * @version 1.0 (29/02/2016), 2.0 (01/11/2021)
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;
    
    private Random generatedStock = new Random(); // Reserved for future expansion.

    /**
     * Create a StockManager and populate it with at least 10 sample products.
     */
    public StockDemo()
    {
        this.stock = new StockList();
        
        // Add at least 10 products, they must be unique to you. Make sure the ids are sequential numbers.
        
        stock.addProduct(new Product(101, "Steelseries Apex Keyboard"));
        stock.addProduct(new Product(102, "Airpods Pro with Charging Case"));
        stock.addProduct(new Product(103, "32GB SanDisk USB Drive"));
        stock.addProduct(new Product(104, "Razer Gaming Mouse"));
        stock.addProduct(new Product(105, "Apple iPhone 13 Pro Max 256GB"));
        stock.addProduct(new Product(106, "Google Pixel 6 Pro 128GB"));
        stock.addProduct(new Product(107, "Lenovo Gaming Laptop Ryzen 5 8GB RAM 256GB SSD"));
        stock.addProduct(new Product(108, "Dell 27 Inch Monitor 1920x1080 60Hz"));
        stock.addProduct(new Product(109, "USB-C Charging Cable 2M"));
        stock.addProduct(new Product(110, "Apple Lightning Cable 1M"));
    }
}