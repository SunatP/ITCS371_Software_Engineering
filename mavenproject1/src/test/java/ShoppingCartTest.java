/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sunat
 */
public class ShoppingCartTest {
    ShoppingCart shopcart;
    
    
    public ShoppingCartTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        shopcart = new ShoppingCart();
    }
    
    @Test
    public void getItemCount()
    {
        int amount = shopcart.getItemCount();
        assertEquals(0, amount);
    }
    
    @Test
    public void Empty()
    {
        shopcart.empty();
        assertEquals(0, shopcart.getItemCount());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBalance method, of class ShoppingCart.
     */
    
    @Test
    public void addNewProduct()
    {
        Product product = new Product("Test", 1000);
        double beforecal = shopcart.getBalance();
        shopcart.addItem(product);
        double aftercal = shopcart.getItemCount();
        assertEquals(beforecal + 1 , aftercal,0);
    }
    
    @Test
    public void increaseBalance()
    {
        Product product = new Product("Test", 1000);
        double beforecal = shopcart.getBalance();
        shopcart.addItem(product);
        assertEquals(beforecal + product.getPrice() , shopcart.getBalance(),0);
    }
    
    @Test
    public void decreaseProduct() throws ProductNotFoundException
    {
        Product product = new Product("Test", 1000);
        double beforecal = shopcart.getBalance();
        shopcart.addItem(product);
        shopcart.removeItem(product);
        assertEquals(0, shopcart.getItemCount());
    }
    
    @Test
    public void decreaseNotFoundProduct() 
    {
        Product product = new Product("Test", 1000);
        Product productNotFound = new Product("test1", 1000);
        shopcart.addItem(product);
        try {
            shopcart.removeItem(productNotFound);
        } catch (ProductNotFoundException ex) {
            assertEquals(null, ex.getMessage());
        }
        
    }
}
