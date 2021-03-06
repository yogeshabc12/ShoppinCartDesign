package com.dev.design.shoppingcart.visitor;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements IShoppingCartElement {

	private List<IShoppingCartElement> cartItems = 
					new ArrayList<IShoppingCartElement>();
	
	private double totalBill;
	
	public void addCartItem(Item shoppingCartElement) {
		shoppingCartElement.setShoppingCart(this);
		cartItems.add(shoppingCartElement);
	}
	
	public List<IShoppingCartElement> getItems() {
		return this.cartItems;
	}
	
	
	
	public double giveDiscount() {
		Discount discount = new Discount(0);
		discount.setShoppingCart(this);
		cartItems.add(discount);
		return totalBill;
	}

	public void accept(IShoppingCartVisitor shoppingCartVisitor) {
		shoppingCartVisitor.visitShoppingCart(this);
	}

	public List<IShoppingCartElement> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<IShoppingCartElement> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
}
