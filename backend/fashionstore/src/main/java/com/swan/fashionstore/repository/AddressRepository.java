package com.swan.fashionstore.repository;

import com.swan.fashionstore.modal.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
