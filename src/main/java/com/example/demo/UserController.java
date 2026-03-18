package com.example.demo;

import com.example.demo.User;
import com.example.demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        try {
            // 使用 MyBatis-Plus 自带的 save 方法
            boolean isSuccess = userService.save(user);
            return isSuccess ? "注册成功" : "注册失败";
        } catch (Exception e) {
            return "发生错误: " + e.getMessage();
        }
    }
}