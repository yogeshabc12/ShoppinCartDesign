package com.dev.design.shoppingcart.visitor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class GenerateBillShoppingCartVisitor implements IShoppingCartVisitor {

	public void visitCartItem(Item cartItem) {
		
		double itemCost = cartItem.getItemCount() * cartItem.getPrice();
		cartItem.getShoppingCart().setTotalBill(
				cartItem.getShoppingCart().getTotalBill() + round(itemCost, 2));
		
		System.out.println(cartItem.getItemCount() + " " + 
				cartItem.getName().toUpperCase() + 
				"(" + cartItem.getPrice() + ") - Rs." + itemCost);
	}

	public double visitDiscount(Discount discount) {
		System.out.println("\nTotal bill : " + discount.getShoppingCart().getTotalBill());
		double appleDiscount = 0;
		double orangeDiscount = 0;
		List<IShoppingCartElement> items = discount.getShoppingCart().getCartItems();
		for (int i=0; i<items.size(); ++i) {
		  if (items.get(i) != null) {
			  Object item = (Object) items.get(i);
			  if (item instanceof Item) {
				  Item fruitType = (Item) item;
			    if(fruitType.getName().equals("APPLE")) {
			    	appleDiscount = (fruitType.getItemCount()  / 3) * fruitType.getPrice();
		       } else {
			    	orangeDiscount = (fruitType.getItemCount()  / 2 ) * fruitType.getPrice();
			
			    }
			 }
			}
		  }
		
		discount.getShoppingCart().setTotalBill(
				round((discount.getShoppingCart().getTotalBill()  - (appleDiscount + orangeDiscount)), 2));
		
		System.out.println("After Discount  : " + 
				discount.getShoppingCart().getTotalBill());
		return discount.getShoppingCart().getTotalBill();
	}


	public double visitShoppingCart(ShoppingCart shoppingCart) {
		
		System.out.println("---- Total Cost  ----");
		
		for (int i = 0 ; i < shoppingCart.getCartItems().size() ; i ++) {
			shoppingCart.getCartItems().get(i).accept(this);
		}
		
		System.out.println("\nAmount to pay : " + shoppingCart.getTotalBill());
		return shoppingCart.getTotalBill();
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

}
