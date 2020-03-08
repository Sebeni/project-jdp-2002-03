package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Key;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.exception.UserNotAuthorisedException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(final Long id) {
        return userRepository.findById(id);
    }

    public Key getKey(Long id, String userName) throws UserNotFoundException, UserNotAuthorisedException {
        User userOfKey = getUserById(id).orElseThrow(UserNotFoundException::new) ;
        if (userName.equals(userOfKey.getUserName())) {
            Random random = new Random();
            Long value = random.nextLong() + id;
            Key userKey = new Key(value, LocalDateTime.now(), LocalDateTime.now().plusHours(1));
            return userKey;
        } else throw new UserNotAuthorisedException();
    }
}
