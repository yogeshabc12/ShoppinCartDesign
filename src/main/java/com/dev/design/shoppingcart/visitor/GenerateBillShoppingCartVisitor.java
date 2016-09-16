package com.dev.design.shoppingcart.visitor;

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
		discount.getShoppingCart().setTotalBill(
				discount.getShoppingCart().getTotalBill() * (100-discount.getDiscount())/100);
		
		System.out.println("After Discount (" + discount.getDiscount() + "%) : " + 
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
