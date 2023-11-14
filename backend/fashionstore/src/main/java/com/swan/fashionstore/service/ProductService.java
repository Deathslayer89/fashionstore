package com.swan.fashionstore.service;

import com.swan.fashionstore.exception.ProductException;
import com.swan.fashionstore.modal.Product;
import com.swan.fashionstore.request.CreateProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    //admin users
    public Product createProduct(CreateProductRequest req) throws ProductException;
    public String deleteProduct(Long productId)throws ProductException;
    public Product updateProduct(Long productId,Product product)throws ProductException;
    public List<Product> getAllProducts();

    //normalUsers

    public Product findProductById(Long id)throws ProductException;
    public List<Product> findProductByCategory(String category)throws ProductException;
    public List<Product> searchProduct(String query);
    public Page<Product>getAllProduct(String category,List<String>colors,List<String>sizes,Integer minPrice,Integer maxPrice,Integer minDiscount,String sort,String stock,Integer pageNumber,Integer PageSize);

}
