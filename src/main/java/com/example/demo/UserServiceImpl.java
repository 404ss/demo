package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// 删掉 extends ServiceImpl，确保不触发 getBaseMapper 调用
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean save(User user) {
        // 直接调用 mapper，不走基类逻辑
        return userMapper.insert(user) > 0;
    }
}