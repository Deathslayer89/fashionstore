package com.swan.fashionstore.service;


import com.swan.fashionstore.exception.OrderException;
import com.swan.fashionstore.modal.Address;
import com.swan.fashionstore.modal.Order;
import com.swan.fashionstore.modal.User;

import java.util.List;

public interface OrderService {
    public Order createOrder(User user, Address shippingAddress);

    public Order findOrderById(Long orderId) throws OrderException;

    public List<Order> usersOrderHistory(Long userId);

    public Order placedOrder(Long orderId) throws OrderException;

    public Order confirmedOrder(Long orderId)throws OrderException;

    public Order shippedOrder(Long orderId) throws OrderException;

    public Order deliveredOrder(Long orderId) throws OrderException;

    public Order cancledOrder(Long orderId) throws OrderException;

    public List<Order>getAllOrders();

    public void deleteOrder(Long orderId) throws OrderException;
}
