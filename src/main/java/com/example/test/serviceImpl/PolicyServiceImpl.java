package com.example.test.serviceImpl;

import com.example.test.bean.PolicyBean;
import com.example.test.mapper.PolicyMapper;
import com.example.test.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {

    //将DAO注入Service层
    @Autowired
    PolicyMapper policyMapper;

    /**
     * 根据条件查询未决清单
     * @param agentcode
     * @param password
     * @return
     */
    @Override
    public PolicyBean loginIn(String agentcode, String password) {
        return policyMapper.getInfo(agentcode,password);
    }

   /* *//**
     * 根据ID查询用户信息
     * @param agentcode
     * @return
     *//*
    @Override
    public UserBean queryUserById(String agentcode) {
        return userMapper.selectUserById(agentcode);
    }
*/

    /**
     * 新增清单
     * @param policyBean
     * @return
     */
    @Override
    public int addPolicy(PolicyBean policyBean) {
        int aFlag = policyMapper.insertPolicy(policyBean);
        return aFlag;
    }

    /**
     * 删除清单
     * @param id
     * @return
     */
    @Override
    public int dropPolicy(String id) {
        int dFlag = policyMapper.deletePolicy(id);
        return dFlag;
    }


    /**
     * 修改回访内容
     * remark：实际上还是根据用户ID修改用户信息
     * @param policyBean
     * @return
     */
    @Override
    public int modifyPolicy(PolicyBean policyBean) {
        int mFlag = policyMapper.updatePolicy(policyBean);
        return mFlag;
    }

    /**
     * 查询所有未决清单
     * @return
     */
    @Override
    public List<PolicyBean> queryAllPolicy() {
        return policyMapper.getAllPolicy();
    }
}
