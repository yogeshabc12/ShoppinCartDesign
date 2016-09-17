package com.dev.design.shoppingcart;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dev.design.shoppingcart.constant.FruitEnum;
import com.dev.design.shoppingcart.visitor.GenerateBillShoppingCartVisitor;
import com.dev.design.shoppingcart.visitor.Item;
import com.dev.design.shoppingcart.visitor.PrintShoppingCartVisitor;
import com.dev.design.shoppingcart.visitor.ShoppingCart;

public class ShoppingCartTest {

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {

	}

	/**
	 * TDD Step 1: First Test case without Implementation to calculate total
	 * Fruit Costs.
	 */
  
	public void testTotalCostOfFruits() {

		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.addCartItem(new Item(FruitEnum.APPLE.name(), 3, 0.60));
		shoppingCart.addCartItem(new Item(FruitEnum.ORANGE.name(), 1, 0.25));
		shoppingCart.accept(new PrintShoppingCartVisitor());
		System.out.println();
		shoppingCart.accept(new GenerateBillShoppingCartVisitor());
		Assert.assertEquals(2.05, shoppingCart.getTotalBill(), 0);
	}

	/**
	 * TDD Step 2 : Calculate Total Cost with Discount.
	 */
	@Test
	public void testTotalCostWithDiscount() {
	      ShoppingCart shoppingCart = new ShoppingCart();
	      shoppingCart.addCartItem(new Item(FruitEnum.APPLE.name(), 3, 0.60));
	      shoppingCart.addCartItem(new Item(FruitEnum.ORANGE.name(), 1, 0.25));
	      shoppingCart.giveDiscount();
	      shoppingCart.accept(new PrintShoppingCartVisitor());
	  	  System.out.println();
	      shoppingCart.accept(new GenerateBillShoppingCartVisitor());
	      Assert.assertEquals(1.45, shoppingCart.giveDiscount(), 0);
	}

}
