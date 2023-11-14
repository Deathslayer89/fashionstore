package com.swan.fashionstore.service;

import com.swan.fashionstore.exception.ProductException;
import com.swan.fashionstore.modal.Cart;
import com.swan.fashionstore.modal.User;
import com.swan.fashionstore.request.AddItemRequest;

public interface CartService {
    public Cart createCart(User user);
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException;

    public Cart findUserCart(Long userId);
}
