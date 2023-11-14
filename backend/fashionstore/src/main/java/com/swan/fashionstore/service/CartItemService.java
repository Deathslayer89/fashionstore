package com.swan.fashionstore.service;

import com.swan.fashionstore.exception.CartItemException;
import com.swan.fashionstore.exception.UserException;
import com.swan.fashionstore.modal.Cart;
import com.swan.fashionstore.modal.CartItem;
import com.swan.fashionstore.modal.Product;

public interface CartItemService {
    public CartItem createCartItem(CartItem cartItem);

    public CartItem updateCartItem(Long userId, Long id,CartItem cartItem) throws CartItemException, UserException;

    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);

    public void removeCartItem(Long userId,Long cartItemId) throws CartItemException, UserException;

    public CartItem findCartItemById(Long cartItemId) throws CartItemException;
}
