package com.example.test.entity;

import lombok.Data;

import java.math.BigInteger;

/**
 * @Author Kerwin.Hou
 * @Description policy
 * @CreateTime 2021年02月20日 22:27
 **/
@Data
public class PolicyDO {
    private BigInteger id;
    private String createDate;
    private String modifyDate;
    private String comCode;//'机构码',
    private String comName;// '机构名称',
    private String policyNo;// '保单号',
    private String claimNo;//'报案号',
    private String risk;//'险种',
    private String customer;// '被保险人',
    private String accidentDate;//'出险日期',
    private String accidentAddress;//'出险地址',
    private String claimDate;//'报案时间',
    private String claimPeople;//'报案人',
    private String phone;//'报案电话',
    private String carNum;//'车牌号',
    private String money;//'未决金额',
    private String state;// '案件状态',
    private String stayDays;//'滞留天数',
    private String isPerson;//'是否人伤',
    private String surveyPerson;//'首次查勘人员',
    private String Content;// '上次回访内容',
    private String update;//'最近一次回访时间',
}
