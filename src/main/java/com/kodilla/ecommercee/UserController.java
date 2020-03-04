package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {

    private List<UserDto> users = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET, value = "getAllUsers")
    public List<UserDto> getAllUsers() {
        return users;
    }

    @RequestMapping(method = RequestMethod.POST, value = "addUser", consumes = APPLICATION_JSON_VALUE)
    public UserDto addUser(@RequestBody UserDto userToAdd) {
        users.add(userToAdd);
        return userToAdd;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public UserDto blockUser(@RequestParam Long userId ) {
        return new UserDto(userId, "Jan", "Kowalski", true);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getKey")
    public Long getKey(@RequestParam Long userId) {
        Random random = new Random();
        return random.nextLong();
    }
}
