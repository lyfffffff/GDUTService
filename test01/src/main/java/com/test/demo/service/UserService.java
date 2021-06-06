package com.test.demo.service;

import com.test.demo.entity.UserResult;
import com.test.demo.entity.User;
import com.test.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 注册
     * @param user 参数封装
     * @return Result
     */
    public UserResult regist(User user) {
        UserResult userResult = new UserResult();
        userResult.setSuccess(false);
        userResult.setDetail(null);
        try {
            User existUser = userMapper.findUserByName(user.getUsername());
            if(existUser != null){
                //如果用户名已存在
                userResult.setMsg("用户名已存在");

            }else{
                userMapper.regist(user);
                //System.out.println(user.getId());
                userResult.setMsg("注册成功");
                userResult.setSuccess(true);
                userResult.setDetail(user);
            }
        } catch (Exception e) {
            userResult.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return userResult;
    }
    /**
     * 登录
     * @param user 用户名和密码
     * @return Result
     */
    public UserResult login(User user) {
        UserResult userResult = new UserResult();
        userResult.setSuccess(false);
        userResult.setDetail(null);
        try {
             Long userId= userMapper.login(user);
            if(userId == null){
                userResult.setMsg("用户名或密码错误");
            }else{
                userResult.setMsg("登录成功");
                userResult.setSuccess(true);
                user.setId(userId);
                userResult.setDetail(user);
            }
        } catch (Exception e) {
            userResult.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return userResult;
    }
}
