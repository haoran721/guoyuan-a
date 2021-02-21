package com.example.test.mapper;

import com.example.test.bean.PolicyBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyMapper {

    //根据条件查询未决清单
    PolicyBean getInfo(String policynum,String password);

    /*//根据ID查询用户信息
    PolicyBean selectUserByPolicyNum(String policynum);*/

    //插入新的未决清单
    int insertPolicy(PolicyBean policyBean);

    //删除清单
    int deletePolicy(String id);

    //修改回访内容
    int updatePolicy(PolicyBean policyBean);

    //查询所有未决清单
    List<PolicyBean> getAllPolicy();

}
