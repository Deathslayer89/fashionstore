package com.swan.fashionstore.service;

import com.swan.fashionstore.exception.ProductException;
import com.swan.fashionstore.modal.Rating;
import com.swan.fashionstore.modal.User;
import com.swan.fashionstore.request.RatingRequest;

import java.util.List;
import java.util.Optional;

public interface RatingService {
    public Rating createRating(RatingRequest req, Optional<User> user)throws ProductException;
    public List<Rating> getProductRating(Long productId);
}
