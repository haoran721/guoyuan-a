package com.example.test.serviceImpl;

import com.example.test.bean.UserBean;
import com.example.test.mapper.UserMapper;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    UserMapper userMapper;

    /**
     * 登录验证
     * @param agentcode
     * @param password
     * @return
     */
    @Override
    public UserBean loginIn(String agentcode, String password) {
        return userMapper.getInfo(agentcode,password);
    }

    /**
     * 根据ID查询用户信息
     * @param agentcode
     * @return
     */
    @Override
    public UserBean queryUserById(String agentcode) {
        return userMapper.selectUserById(agentcode);
    }


    /**
     * 新增用户
     * @param userBean
     * @return
     */
    @Override
    public int addUser(UserBean userBean) {
        int aFlag = userMapper.insertUser(userBean);
        return aFlag;
    }

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    @Override
    public int dropUser(String id) {
        int dFlag = userMapper.deleteUser(id);
        return dFlag;
    }


    /**
     * 修改用户信息
     * remark：实际上还是根据用户ID修改用户信息
     * @param userBean
     * @return
     */
    @Override
    public int modifyUser(UserBean userBean) {
        int mFlag = userMapper.updateUser(userBean);
        return mFlag;
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<UserBean> queryAllUser() {
        return userMapper.getAllUser();
    }
}
