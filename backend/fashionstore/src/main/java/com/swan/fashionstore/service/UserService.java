package com.swan.fashionstore.service;

import com.swan.fashionstore.exception.UserException;
import com.swan.fashionstore.modal.User;

import java.util.Optional;

public interface UserService {

public User findUserById(Long userId)throws UserException;
public Optional<User> findUserProfileByJwt(String jwt)throws UserException;

}