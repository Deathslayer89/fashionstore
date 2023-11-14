package com.swan.fashionstore.repository;

import com.swan.fashionstore.modal.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository {

    @Query("SELECT c From Cart c where c.user.id=:userId")
    public Cart findByUserId(@Param("userId")Long userId);
}
