/**
 * This app provides a user interface to the stock manager so that users can add, edit, print and remove stock products
 *
 * @author Leighton Burgoyne
 * @version v1.0 (26/11/2021)
 */
public class StockApp
{
    private InputReader reader;
    
    private StockList stock;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        
        stock = new StockList();
    }

    /**
     *  Display a list of menu options and execute the user's option. This is the first function to be called.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuOptions();
           
            String option = reader.getString("Please enter your Menu option > ");
            
            finished = executeOption(option.toLowerCase());
        }
    }
    
    private boolean executeOption(String option) // User Menu using Switch Statements
    {
        switch (option) {
            case "add" -> { // Add Product Option
                System.out.println("Option Selected: Add Product");
                addProduct();
            }
            case "remove" -> { // Remove Product Option
                System.out.println("Option Selected: Remove Product");
                removeProduct();
            }
            case "buy" -> { // Buy Products Option
                System.out.println("Option Selected: Buy Products");
                buyProduct();
            }
            case "sell" -> { // Sell Products Option
                System.out.println("Option Selected: Sell Products");
                sellProduct();
            }
            case "search" -> { // Search Products Option
                System.out.println("Option Selected: Search Products");
                searchProduct();
            }
            case "stock" -> { // Stock Check Option
                System.out.println("Option Selected: Stock Check");
                checkLowStock();
            }
            case "print" -> { // Print Stock Option
                System.out.println("Option Selected: Print Stock");
                printStock();
            }
            case "restock" -> { // Restock Option
                System.out.println("Option Selected: Restock all Low Stock");
                restock();
            }
            case "demo" -> { // Demo Option (bulk add products for testing)
                System.out.println("Option Selected: Demo Mode (Bulk Add 10 Products)");
                demo();
            }
            case "quit" -> { // Quit Application Option
                System.out.println("Option Selected: Quit Application");
                System.exit(0); // Exit the Program via System Status 0 (Exit)
            }
            default -> // Error Message for any input not defined above
                    System.out.println("ERROR: Invalid Input, please select a choice from the User Menu");
        }
        return false;
    }

    /**
     *  Add a new product to the Stock List based on inputted Product Name and Product ID
     */
    private void addProduct()
    {
        int productId = reader.getInt("Enter Product ID to Create: "); // Enter Product ID
        String productName = reader.getString("Enter Product Name to Create: "); // Enter Product Name
        Product product = new Product(productId, productName);  // Creates Product Object, with productId and productName properties.
        stock.addProduct(product);  // Add Product to Stock
        System.out.println("Product " + product.getID() + ": " + product.getName() + " has been added."); // User Output Message
    }

    /**
     *  Remove a Product from the Stock List on inputted Product Name and Product ID
     */
    private void removeProduct()
    {
        int productId = reader.getInt("Enter Product ID to Remove: "); // Enter Product ID
        stock.removeProduct(productId); // Remove Product from Stock
        System.out.println("Product with ID " + productId + " has been removed."); // User Output Message

    }

    /**
     *  Buy a Product in a set quantity between 1 and 10
     */
    private void buyProduct()
    {
        int productId = reader.getInt("Enter Product ID to Buy: "); // Enter Product ID
        int productQuantity = reader.getInt("Enter Quantity to Buy: "); // Enter Product Quantity to Buy
        stock.buyProduct(productId, productQuantity); // Buy the specified product at the defined quantity
        System.out.println("Product " + productId + " has been successfully bought in Quantity " + productQuantity); // User Output Message
    }

    /**
     *  Sell a Product in a set quantity between 1 and 10
     */
    private void sellProduct()
    {
        int productId = reader.getInt("Enter Product ID to Sell: "); // Enter Product ID
        int productQuantity = reader.getInt("Enter Quantity to Sell: "); // Enter Product Quantity to Sell
        stock.sellProduct(productId, productQuantity); // Buy the specified product at the defined quantity
        System.out.println("Product " + productId + " has been successfully sold in Quantity " + productQuantity); // User Output Message
    }

    /**
     *  Search for Products within the Stock List by a user-defined Phrase
     */
    private void searchProduct()
    {
        String phrase = reader.getString("Enter Search Term: "); // Enter Search Term
        stock.searchProduct(phrase); // Search StockList for the Phrase and return via associated function
        System.out.println("Search Results for " + phrase + " :"); // User Output Message
    }

    /**
     *  Show a list of products where the stock level is between 1-5 (deemed as Low)
     */
    private void checkLowStock()
    {
        stock.printLowStock(); // Print Low Stock Levels via associated function
    }

    /**
     *  Automatically restocks all products where stock level is less than 5 (deemed as low) to the minimum quantity
     */
    private void restock()
    {
        stock.restock(); // Restock all Low Products via associated function
    }

    /**
     *  Print a list of all Products, and the associated Stock Levels, and ID Numbers
     */
    private void printStock()
    {
        stock.printAllStock(); // Print All Stock via associated function
    }

    /**
     *  Bulk Add 10 Products to the Stock List for Testing Purposes
     */
    private void demo()
    {
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

    /**
     * Print out a User Menu of Options, informing the user of the options available to them
     */
    private void printMenuOptions()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Buy:        Buy a Quantity of Products");
        System.out.println("    Sell:       Sell a Quantity of Products");
        System.out.println("    Search:     Search for a Product by Name");
        System.out.println("    Stock:      Check Low Stock Levels");
        System.out.println("    Restock:    Auto Restock all Low Products");
        System.out.println("    Print:      Print all products");
        System.out.println("    Demo:       Bulk Create 10 Products");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name for appearance purposes
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application   ");
        System.out.println("      by Leighton Burgoyne      ");
        System.out.println("********************************");
    }
}