package com.swan.fashionstore.service;

import com.swan.fashionstore.config.JwtTokenProvider;
import com.swan.fashionstore.exception.UserException;
import com.swan.fashionstore.modal.User;
import com.swan.fashionstore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation  implements UserService{
    private  UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;

    public UserServiceImplementation(UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public User findUserById(Long userId) throws UserException {
        Optional<User>user=userRepository.findById(userId);
        if(user.isPresent()){
            return user.get();
        }else throw new UserException("user not found with Id" + userId);

    }

    @Override
    public Optional<User> findUserProfileByJwt(String jwt) throws UserException {
        System.out.println("user service");
        String email=jwtTokenProvider.getEmailFromJwtToken(jwt);

        System.out.println("Email"+email);
        User user=userRepository.findByEmail(email);

        if(user==null){
            throw new UserException("user not found with this email "+email);

        }
        System.out.println("email user:"+user.getEmail());
        return Optional.of(user);
    }
}
