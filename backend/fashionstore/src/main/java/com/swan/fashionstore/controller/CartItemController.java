package com.swan.fashionstore.controller;

import com.swan.fashionstore.exception.CartItemException;
import com.swan.fashionstore.exception.UserException;
import com.swan.fashionstore.modal.CartItem;
import com.swan.fashionstore.modal.User;
import com.swan.fashionstore.response.ApiResponse;
import com.swan.fashionstore.service.CartItemService;
import com.swan.fashionstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cart_items")
public class CartItemController {

    private CartItemService cartItemService;
    private UserService userService;

    public CartItemController(CartItemService cartItemService,UserService userService) {
        this.cartItemService=cartItemService;
        this.userService=userService;
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItemHandler(@PathVariable Long cartItemId, @RequestHeader("Authorization")String jwt) throws CartItemException, UserException {

        Optional<User> user=userService.findUserProfileByJwt(jwt);
        cartItemService.removeCartItem(user.get().getId(), cartItemId);

        ApiResponse res=new ApiResponse("Item Remove From Cart",true);

        return new ResponseEntity<ApiResponse>(res, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<CartItem>updateCartItemHandler(@PathVariable Long cartItemId, @RequestBody CartItem cartItem, @RequestHeader("Authorization")String jwt) throws CartItemException, UserException{

        Optional<User> user=userService.findUserProfileByJwt(jwt);

        CartItem updatedCartItem =cartItemService.updateCartItem(user.get().getId(), cartItemId, cartItem);

        //ApiResponse res=new ApiResponse("Item Updated",true);

        return new ResponseEntity<>(updatedCartItem,HttpStatus.ACCEPTED);
    }
}
