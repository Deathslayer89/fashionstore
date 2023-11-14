package com.swan.fashionstore.service;

import com.swan.fashionstore.exception.ProductException;
import com.swan.fashionstore.modal.Review;
import com.swan.fashionstore.modal.User;
import com.swan.fashionstore.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    public Review createReview(ReviewRequest req, User user)throws ProductException;

    public List<Review>getAllReviews(Long productId);
}
