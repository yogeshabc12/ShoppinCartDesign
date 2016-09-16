package com.dev.design.shoppingcart.visitor;

public class PrintShoppingCartVisitor implements IShoppingCartVisitor {

	public void visitCartItem(Item cartItem) {
		System.out.println(cartItem.getItemCount() + " " + cartItem.getName().toUpperCase() + "(S) each costing Rs."
				+ cartItem.getPrice());
	}

	public void visitDiscount(Discount discount) {
		System.out.println("Discount : 2 for 3 Apples and buy one get one free Orange " );
	}

	public double visitShoppingCart(ShoppingCart shoppingCart) {
 
		System.out.println("---- Shopping Cart Vistor Trace ----");
        double price =0;
		for (int i = 0; i < shoppingCart.getCartItems().size(); i++) {
		  shoppingCart.getCartItems().get(i).accept(this);
		}
		return 0;

	}

}
