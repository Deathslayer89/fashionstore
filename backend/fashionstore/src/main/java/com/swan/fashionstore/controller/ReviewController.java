package com.swan.fashionstore.controller;

import com.swan.fashionstore.exception.ProductException;
import com.swan.fashionstore.exception.UserException;
import com.swan.fashionstore.modal.Review;
import com.swan.fashionstore.modal.User;
import com.swan.fashionstore.request.ReviewRequest;
import com.swan.fashionstore.service.ReviewService;
import com.swan.fashionstore.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private ReviewService reviewService;
    private UserService userService;

    public ReviewController(ReviewService reviewService, UserService userService) {
        this.reviewService = reviewService;
        this.userService = userService;
    }
    @PostMapping("/create")
    public ResponseEntity<Review> createReviewHandler(@RequestBody ReviewRequest req, @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        Optional<User> user=userService.findUserProfileByJwt(jwt);
        System.out.println("product id "+req.getProductId()+" - "+req.getReview());
        Review review=reviewService.createReview(req, user.get());
        System.out.println("product review "+req.getReview());
        return new ResponseEntity<Review>(review,HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getProductsReviewHandler(@PathVariable Long productId){
        List<Review> reviews=reviewService.getAllReviews(productId);
        return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    }
}
