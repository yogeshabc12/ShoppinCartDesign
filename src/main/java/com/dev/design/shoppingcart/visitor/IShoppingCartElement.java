package com.dev.design.shoppingcart.visitor;

public interface IShoppingCartElement {
	public void accept(IShoppingCartVisitor shoppingCartVisitor);
}
