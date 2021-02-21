package com.example.test.controller;

import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    //将Service注入Web层yangdan1
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public Map login(String agentcode, String password){
        Map map =new HashMap();
        UserBean userBean = userService.loginIn(agentcode,password);
        if(userBean!=null){
            map.put("result","success");

        }else {
            map.put("result","error");
        }
        return map;
    }



}
