package com.example.test.controller;

import com.example.test.bean.PolicyBean;
import com.example.test.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PolicyController {

    @Autowired
    PolicyService policyService;

    /**
     * 查询所有未决清单
     * @param modelMap
     * @return
     */
    @RequestMapping("/policy")
    public String showUsers(ModelMap modelMap){
        List<PolicyBean> policyList = policyService.queryAllPolicy();
        modelMap.addAttribute("policyList",policyList);
        return "policy";
    }

    /**
     * 新增用户
     * remark：这里未做用户名是否重复校验
     * @param policyBean
     * @return
     */
    @RequestMapping("/addPolicy")
    @ResponseBody
    public Map addPolicy(PolicyBean policyBean){
        int flag = policyService.addPolicy(policyBean);
        Map<String,Object> map = new HashMap<String,Object>();
        if(flag == 1){
            map.put("msg","新增用户成功");
            return map;
        }else {
            map.put("msg","新增用户失败");
            return map;
        }
    }


    /**
     * 根据用户ID删除用户信息
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/deletePolicy+{id}")
    public String dropUser(@PathVariable("id") String id,ModelMap modelMap){
        int flag = policyService.dropPolicy(id);
        List<PolicyBean> policyList = policyService.queryAllPolicy();
        modelMap.addAttribute("policyList",policyList);
        if(flag == 1){
            return "policys";
        }else {
            return "error";
        }
    }

    /**
     * 根据用户ID查询用户信息
     * @param agentcode
     * @return
     */
    /*@RequestMapping("/user+{agentcode}")
    public String queryUser(@PathVariable("agentcode") String agentcode,ModelMap modelMap){
        PolicyBean policyBean = policyService.queryUserById(agentcode);
        modelMap.addAttribute("user",policyBean);
        return "userInfo";
    }*/

    /**
     * 根据用户ID修改用户信息
     * remark：这里未做用户名是否重复校验
     * @param policyBean
     * @return
     */
    @RequestMapping("/modifyPolicy")
    @ResponseBody
    public Map modifyPolicy(PolicyBean policyBean){
        int flag = policyService.modifyPolicy(policyBean);
        Map<String,Object> map = new HashMap<>();
        if(flag == 1){
            map.put("msg","修改用户信息成功");
            return map;
        }else {
            map.put("msg","修改用户信息失败");
            return map;
        }
    }

}
