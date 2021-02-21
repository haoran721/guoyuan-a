package com.example.test.entity.vo;

import com.example.test.entity.PolicyDO;
import lombok.Data;

/**
 * @Author Kerwin.Hou
 * @Description policy'
 * @CreateTime 2021年02月20日 23:10
 **/
@Data
public class PolicyVO extends PolicyDO {
    private Integer num;
    private String message;
}
