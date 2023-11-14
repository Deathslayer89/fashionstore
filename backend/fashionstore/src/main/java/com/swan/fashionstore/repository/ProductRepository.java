package com.swan.fashionstore.repository;

import com.swan.fashionstore.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>  {
    @Query("SELECT p from Product p where lower(p.category.name)=:category")
    public List<Product> findByCategory(@Param("category")String category);

    @Query("SELECT p from Product p where lower(p.title) Like %:query% or lower(p.description) Like %:query% or lower(p.brand) LIKE %:query% or lower(p.category.name) LIKE %:query%")
    public List<Product> searchProduct(@Param("query")String query);
    @Query("SELECT p FROM Product p " +
            "WHERE (p.category.name = :category OR :category = '') " +
            "AND ((:minPrice IS NULL AND :maxPrice IS NULL) OR (p.discountedPrice BETWEEN :minPrice AND :maxPrice)) " +
            "AND (:minDiscount IS NULL OR p.discountPercent >= :minDiscount) " +
            "ORDER BY " +
            "CASE WHEN :sort = 'price_low' THEN p.discountedPrice END ASC, " +
            "CASE WHEN :sort = 'price_high' THEN p.discountedPrice END DESC")
    List<Product> filterProducts(
            @Param("category") String category,
            @Param("minPrice") Integer minPrice,
            @Param("maxPrice") Integer maxPrice,
            @Param("minDiscount") Integer minDiscount,
            @Param("sort") String sort
    );
}
