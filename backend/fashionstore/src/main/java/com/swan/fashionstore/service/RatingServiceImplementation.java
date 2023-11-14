package com.swan.fashionstore.service;

import com.swan.fashionstore.exception.ProductException;
import com.swan.fashionstore.modal.Product;
import com.swan.fashionstore.modal.Rating;
import com.swan.fashionstore.modal.User;
import com.swan.fashionstore.repository.RatingRepository;
import com.swan.fashionstore.request.RatingRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class RatingServiceImplementation implements  RatingService{
    private RatingRepository ratingRepository;
    private ProductService productService;
    @Override
    public Rating createRating(RatingRequest req, Optional<User> user) throws ProductException {
        Product product=productService.findProductById(req.getProductId());
        Rating rating=new Rating();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(req.getRating());
        rating.setCreatedAt(LocalDateTime.now());


        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getProductRating(Long productId) {
        return ratingRepository.getAllProductsRating(productId);
    }
}
