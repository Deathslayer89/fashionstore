package com.swan.fashionstore.controller;

import com.swan.fashionstore.exception.OrderException;
import com.swan.fashionstore.exception.UserException;
import com.swan.fashionstore.modal.Address;
import com.swan.fashionstore.modal.Order;
import com.swan.fashionstore.modal.User;
import com.swan.fashionstore.service.OrderService;
import com.swan.fashionstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;
    private UserService userService;

    public OrderController(OrderService orderService, UserService userService) {
        this.orderService=orderService;
        this.userService=userService;
    }

    @PostMapping("/")
    public ResponseEntity<Order> createOrderHandler(@RequestBody Address spippingAddress,
                                                    @RequestHeader("Authorization")String jwt) throws UserException{

        Optional<User> user=userService.findUserProfileByJwt(jwt);
        Order order =orderService.createOrder(user.get(), spippingAddress);

        return new ResponseEntity<Order>(order,HttpStatus.OK);

    }

    @GetMapping("/user")
    public ResponseEntity< List<Order>> usersOrderHistoryHandler(@RequestHeader("Authorization")
                                                                 String jwt) throws OrderException, UserException{

        Optional<User> user=userService.findUserProfileByJwt(jwt);
        List<Order> orders=orderService.usersOrderHistory(user.get().getId());
        return new ResponseEntity<>(orders,HttpStatus.ACCEPTED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity< Order> findOrderHandler(@PathVariable Long orderId, @RequestHeader("Authorization")
    String jwt) throws OrderException, UserException {

        Optional<User> user=userService.findUserProfileByJwt(jwt);
        Order orders=orderService.findOrderById(orderId);
        return new ResponseEntity<>(orders, HttpStatus.ACCEPTED);
    }

}

