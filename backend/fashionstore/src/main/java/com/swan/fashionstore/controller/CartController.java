package com.swan.fashionstore.controller;

import com.swan.fashionstore.exception.ProductException;
import com.swan.fashionstore.exception.UserException;
import com.swan.fashionstore.modal.Cart;
import com.swan.fashionstore.modal.User;
import com.swan.fashionstore.request.AddItemRequest;
import com.swan.fashionstore.response.ApiResponse;
import com.swan.fashionstore.service.CartService;
import com.swan.fashionstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private CartService cartService;
    private UserService userService;

    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<Cart> findUserCartHandler(@RequestHeader("Authorization") String jwt) throws UserException {

        Optional<User> user = userService.findUserProfileByJwt(jwt);

        Cart cart = cartService.findUserCart(user.get().getId());

        System.out.println("cart - " + cart.getUser().getEmail());

        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @PutMapping("/add")
    public ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddItemRequest req, @RequestHeader("Authorization") String jwt) throws UserException, ProductException {

        Optional<User> user = userService.findUserProfileByJwt(jwt);

        cartService.addCartItem(user.get().getId(), req);

        ApiResponse res = new ApiResponse("Item Added To Cart Successfully", true);

        return new ResponseEntity<ApiResponse>(res, HttpStatus.ACCEPTED);

    }
}
