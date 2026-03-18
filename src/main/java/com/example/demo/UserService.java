package com.example.demo;

import com.example.demo.User;

public interface UserService {
    // 删掉 extends IService，只留这一个方法
    boolean save(User user);
}