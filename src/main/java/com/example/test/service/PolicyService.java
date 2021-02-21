package com.example.test.service;

import com.example.test.bean.PolicyBean;

import java.util.List;

public interface PolicyService {

    //根据条件查询未决清单
    PolicyBean loginIn(String agentcode,String password);

   /* //根据ID查询用户信息
    PolicyBean queryUserById(String agentcode);*/

    //插入新的清单
    int addPolicy(PolicyBean policyBean);

    //删除清单
    int dropPolicy(String id);

    //修改回访内容
    int modifyPolicy(PolicyBean policyBean);

    //查询所有未决清单
    List<PolicyBean> queryAllPolicy();

}
