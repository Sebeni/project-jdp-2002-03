package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Key;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.exception.UserNotAuthorisedException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getAllUsers")
    public List<UserDto> getAllUsers() {
        return userMapper.mapToUserDtoList(userService.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.POST, value = "addUser", consumes = APPLICATION_JSON_VALUE)
    public UserDto addUser(@RequestBody UserDto userToAdd) {
        return userMapper.mapToUserDto(userService.saveUser(userMapper.mapToUser(userToAdd)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public UserDto blockUser(@RequestParam Long id) {
        UserDto userToBlock = userMapper.mapToUserDto(userService.getUserById(id).orElseThrow(UserNotFoundException::new));
        userToBlock.setBlocked(true);
        return userMapper.mapToUserDto(userService.saveUser(userMapper.mapToUser(userToBlock)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getKey")
    public Key getKey(@RequestParam Long id, String userName) {
        return userService.getKey(id, userName);
    }
}
