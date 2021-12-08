import java.util.ArrayList;

/**
 * Manage the stock in a business. The stock is described by zero or more Products.
 * 
 * @author Leighton Burgoyne
 * @version v1.0 (10/11/2021)
 */
public class StockList
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockList()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productId)
    {
        for(Product product : stock) // Complete for all products in Stock List
        {
            if(product.getID() == productId)
            {
                return product;
            }

        }
        return null;
    }

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     */
    public void addProduct(Product item)
    {
        if (findProduct(item.getID()) != null) // If Product with ID already exists
        {
            System.out.println("ERROR: Product already exists under this ID, please amend your input.");
        }
        else // If Product with ID does not already exist
        {
            stock.add(item);
        }
    }

    /**
     * Remove a Product from the Stock Array List
     */
    public void removeProduct(int productId)
    {
        Product product = findProduct(productId);

        if(product != null) // If Product exists
        {
            stock.remove(product);
        }
        else // If Product does not exist
        {
            System.out.println("ERROR: The Product cannot be found, please check your input.");
        }
    }

    /**
     * Buy a quantity of a specific product defined by User Input.
     * Increase the quantity of the product by the given amount.
     * @param productId The ID of the product.
     * @param productQuantity The amount to increase the quantity by.
     */
    public void buyProduct(int productId, int productQuantity)
    {
        Product product = findProduct(productId);
        
        if(product != null) // Check to see whether the product exists (is not null)
        {
            if(product.getQuantity() < 500) // Validates whether the stock is within the limit
            {
                product.increaseQuantity(productQuantity);
                System.out.println("Bought " + productQuantity + " of Product: " + product.getName());
            }
            else if(product.getQuantity() > 500) // Validates the Stock Level
            {
                System.out.println("ERROR: Unable to buy " + productQuantity + " of "
                + product + " because it exceeds the maximum quantity of 500");
            }
        }
        else
        {
            System.out.println("ERROR: Cannot find product");
        }
    }
    
    /**
     * Sell a quantity of a specific product defined by User Input.
     * Decrease the quantity of the product by the given amount.
     * @param productId The ID of the product.
     * @param productQuantity The amount to decrease the quantity by.
     */
    public void sellProduct(int productId, int productQuantity)
    {
        Product product = findProduct(productId);
        
        if(product != null) 
        {
            if(product.getQuantity() > 0 && product.getQuantity() >= productQuantity)
            {
                product.decreaseQuantity(productQuantity);
                System.out.println("Sold " + productQuantity + " of Product: " + product.getName());
            }
            else if(product.getQuantity() < productQuantity)
            {
                System.out.println("ERROR: Unable to sell " + productQuantity + " of "
                + product + " because it exceeds the product stock level of "
                + product.getQuantity());
            }
            else
            {
                System.out.println("ERROR: The Product: " + product.getName() + 
                " is out of stock");
            }
        }
        else
        {
            System.out.println("ERROR: Cannot find product");
        }
    }

    /**
     * Search for Product by a Search Phrase and return a list of products that apply to the Search
     */
    public void searchProduct (String phrase)
    {
        int count = 0;

        for(Product product : stock) // Complete for all products in Stock List
        {
            if(product.getName().contains(phrase))
            {
                System.out.println(product);
                count += 1;
            }
            else
            {
                System.out.println("Not Found");
            }
            System.out.println("The search returned " + count + " query(s)");
        }
    }

    /**
     * Locate a product with the given ID, and return how many of this item are in stock. If the ID does not match any
     * product, then return a value of zero, as it does not exist therefore is no stock.
     * @param productId The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productId)
    {
        return 0;
    }

    /**
     * Print details of the specified product. If found, its name and stock quantity will be shown.
     * @param productId The ID of the product to look for.
     */
    public void printProduct(int productId)
    {
        Product product = findProduct(productId);
        
        if(product != null) // If Product exists
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock in the order they are in the stock list
     */
    public void printAllStock()
    {
        printHeading();
        
        for(Product product : stock) // Complete for all products in Stock List
        {
            System.out.println(product);
        }

        System.out.println();
    }

    /**
     * Print a list of products where the stock level is between 1-5 (deemed as low)
     */
    public void printLowStock()
    {
        printLowStockHeading();

        for(Product product : stock) // Complete for all products in Stock List
        {
            if(product.getQuantity() <= 5) // If Product is Low (between 1-5)
            {
                System.out.println(product);
            }
        }
        System.out.println();
    }

    /**
     * Automatically restocks all products where stock level is less than 5 (deemed as low) to the minimum quantity
     */
    public void restock()
    {
        for(Product product : stock) // Complete for all products in Stock List
        {
            if(product.getQuantity() <= 5) // If Product is Low (between 1-5)
            {
                product.setQuantity(6);
                System.out.println("Product " +product.getID() + " : " + product.getName() + " restocked to minimum quantity");
            }
        }
        System.out.println();
    }

    /**
     * Print out a Heading for the Stock List
     */
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Leighton's Tech Store | Stock List");
        System.out.println(" ==================================");
        System.out.println();
    }

    /**
     * Print out a Heading for the Low Stock
     */
    public void printLowStockHeading()
    {
        System.out.println();
        System.out.println(" Leighton's Tech Store | Low Stock ");
        System.out.println(" ================================= ");
        System.out.println();
    }
}