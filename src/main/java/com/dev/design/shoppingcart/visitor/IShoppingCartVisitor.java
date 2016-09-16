package com.dev.design.shoppingcart.visitor;

public interface IShoppingCartVisitor {
	public double visitShoppingCart(ShoppingCart shoppingCart);
	public void visitCartItem(Item cartItem);
	public double visitDiscount(Discount discount);
}
