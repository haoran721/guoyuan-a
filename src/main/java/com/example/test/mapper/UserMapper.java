package com.example.test.mapper;

import com.example.test.bean.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {

    //登录时信息核对
    UserBean getInfo(String agentcode,String password);

    //根据ID查询用户信息
    UserBean selectUserById(String agentcode);

    //插入新的用户
    int insertUser(UserBean userBean);

    //删除用户
    int deleteUser(String id);

    //修改用户
    int updateUser(UserBean userBean);

    //查询所有用户
    List<UserBean> getAllUser();

}
