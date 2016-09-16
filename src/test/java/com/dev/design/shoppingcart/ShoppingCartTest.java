package com.dev.design.shoppingcart;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dev.design.shopping.constant.FruitEnum;
import com.dev.design.shopping.fruit.Fruit;
import com.dev.design.shopping.impl.ShoppingCartImpl;
import com.dev.design.shopping.item.Item;
import com.dev.design.shopping.item.ShoppingCart;



public class ShoppingCartTest {
	
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
	       
	}
	
	/**
	 * TDD : First Test case without Implementation to calculate total Fruit Costs.
	 */
	@Test
	public void testTotalCostOfFruits() {
		Item[] items = new Item[]{new Fruit(0.60, FruitEnum.APPLE), new  Fruit(0.60, FruitEnum.APPLE), 
				new Fruit(0.25, FruitEnum.ORANGE), new Fruit(0.60, FruitEnum.APPLE)};
         
        double total = calculateTotalPrice(items);
        Assert.assertEquals(2.05, total,0);
        		
	}
	
	
	  
	  private static double  calculateTotalPrice(Item[] items) {
		    ShoppingCart shoppingCart = new ShoppingCartImpl();
	        double sum=0;
	        for(Item item : items){
	            sum = sum + item.accept(shoppingCart);
	        }
	        return sum;
	  
	  }
	  


}
