package com.swan.fashionstore.controller;

import com.swan.fashionstore.exception.ProductException;
import com.swan.fashionstore.exception.UserException;
import com.swan.fashionstore.modal.Rating;
import com.swan.fashionstore.modal.User;
import com.swan.fashionstore.request.RatingRequest;
import com.swan.fashionstore.service.RatingService;
import com.swan.fashionstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    private UserService userService;
    private RatingService ratingService;
    public RatingController(UserService userService,RatingService ratingServices) {
        this.ratingService=ratingServices;
        this.userService=userService;
        // TODO Auto-generated constructor stub
    }

    @PostMapping("/create")
    public ResponseEntity<Rating> createRatingHandler(@RequestBody RatingRequest req, @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        Optional<User> user=userService.findUserProfileByJwt(jwt);
        Rating rating=ratingService.createRating(req, user);
        return new ResponseEntity<>(rating,HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getProductsReviewHandler(@PathVariable Long productId){

        List<Rating> ratings=ratingService.getProductRating(productId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }
}
