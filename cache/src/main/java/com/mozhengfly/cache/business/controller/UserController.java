package com.mozhengfly.cache.business.controller;


import com.mozhengfly.cache.business.entity.User;
import com.mozhengfly.cache.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mozhengfly123
 * @since 2018-12-27
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 增加User
     * @param user
     * @return
     */
    @PostMapping("")
    public User addUser(@RequestBody User user) {
        user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        userService.insertUser(user);
        return user;
    }

    /**
     * 删除User
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 获取user
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return new ResponseEntity<>(userService.selectUserById(id), HttpStatus.OK);
    }
}

