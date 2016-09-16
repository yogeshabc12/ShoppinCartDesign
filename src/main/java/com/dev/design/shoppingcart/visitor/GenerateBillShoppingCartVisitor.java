package com.dev.design.shoppingcart.visitor;

import java.util.List;

public class GenerateBillShoppingCartVisitor implements IShoppingCartVisitor {

	public void visitCartItem(Item cartItem) {
		
		double itemCost = cartItem.getItemCount() * cartItem.getPrice();
		cartItem.getShoppingCart().setTotalBill(
				cartItem.getShoppingCart().getTotalBill() + itemCost);
		
		System.out.println(cartItem.getItemCount() + " " + 
				cartItem.getName().toUpperCase() + 
				"(" + cartItem.getPrice() + ") - Rs." + itemCost);
	}

	public void visitDiscount(Discount discount) {
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
				discount.getShoppingCart().getTotalBill()  - (appleDiscount + orangeDiscount));
		
		System.out.println("After Discount  : " + 
				discount.getShoppingCart().getTotalBill());
	}


	public double visitShoppingCart(ShoppingCart shoppingCart) {
		
		System.out.println("---- Total Cost  ----");
		
		for (int i = 0 ; i < shoppingCart.getCartItems().size() ; i ++) {
			shoppingCart.getCartItems().get(i).accept(this);
		}
		
		System.out.println("\nAmount to pay : " + shoppingCart.getTotalBill());
		return shoppingCart.getTotalBill();
	}

}
