/*
package com.example.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.test.entity.vo.PolicyVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/login")
@Slf4j
public class ExcelController {
    private final static SimpleDateFormat sf1 = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", Locale.ENGLISH);
    private final static SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat sf3 = new SimpleDateFormat("yyyy/MM/dd");
    private final static SimpleDateFormat sf4 = new SimpleDateFormat("yyyyMMdd");

    @ResponseBody
    @PostMapping("/import")
    String importEdor(@RequestParam(value = "inputFile", required = false) MultipartFile file, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        log.info("excel导入开始。。。");
        // 第一步，解析导入文件
        JSONObject jsonObject=new JSONObject();
        try {
            String fileName = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            Workbook workbook = null;
            if(fileName.endsWith(".xls")) {
                workbook = new HSSFWorkbook(inputStream);
            }else if(fileName.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            }
            // 解析文件生成数据
            Sheet sheetAt = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheetAt.iterator();
            int listNum = 0;
            String failRemind="";
            PolicyVO policyVO;
            List<PolicyVO> failList =new ArrayList();//存放问题数据
            List<PolicyVO> passList =new ArrayList();//存放通过数据
            Set<String> checkSet =new HashSet<>();//校验数据重复
            while (iterator.hasNext()) {
                policyVO = new PolicyVO();
                Row row = iterator.next();
                if (listNum != 0) {
                    Cell cell  = row.getCell(0);
                    Cell cell1 = row.getCell(1);
                    Cell cell2 = row.getCell(2);
                    Cell cell3 = row.getCell(3);
                    Cell cell4 = row.getCell(4);
                    //0、保单号
                    cell.setCellType(CellType.STRING);
                    String contNo = cell.getStringCellValue().replaceAll(" ", "");
                    //1、保全项编码
                    cell1.setCellType(CellType.STRING);
                    String str = cell1.getStringCellValue().replaceAll(" ", "");
                    String edorType = str.substring(str.lastIndexOf("-") + 1, str.length());
                    //2、保险公司
                    cell2.setCellType(CellType.STRING);
                    String supplierCode = row.getCell(2).getStringCellValue().replaceAll(" ", "");
                    //3、保全生效日期
                    Date edorValiDates = getCellDate(cell3);
                    cell4.setCellType(CellType.STRING);
                    String auditOperator = cell4.getStringCellValue().replaceAll(" ", "");



                    PolicyVO.setContNo(contNo);
                    PolicyVO.setSupplierCode(supplierCode);
                    PolicyVO.setEdorType(edorType);
                    PolicyVO.setAuditOperator(auditOperator);
                    PolicyVO.setListNum(listNum+1);
                    PolicyVO.setSaasId(saasId);
                    //校验是否有数据缺失
                    if (StringUtils.isBlank(contNo)|| StringUtils.isBlank(supplierCode)|| StringUtils.isBlank(edorType)||edorValiDates==null|| StringUtils.isBlank(auditOperator)) {
                        failRemind =  "第{" + (listNum+1) + "}行数据有误，保单号、保全类型、保险分公司、保全生效日期、审核人有缺失，或表格结尾有空白行，请确认";
                        PolicyVO.setMessage(failRemind);
                        if(edorValiDates!=null){//反参表格使用
                            PolicyVO.setEdorValiDate(DateUtil.toString(edorValiDates));
                        }
                        //放入失败list
                        failList.add(PolicyVO);
                        listNum++;
                        continue;
                    }
                    PolicyVO.setEdorValiDate(DateUtil.toString(edorValiDates));

                    //校验数据是否重复
                    if(!checkSet.add(contNo)){
                        failRemind =  "第{" + (listNum+1) + "}行数据重复，请注意！！";
                        PolicyVO.setMessage(failRemind);
                        //放入失败list
                        failList.add(PolicyVO);
                        listNum++;
                        continue;
                    }
                    //放入成功list
                    passList.add(PolicyVO);
                }
                listNum++;
            }

            if(listNum==0||listNum==1){
                throw new RuntimeException("本次导入0条，请核对excel中是否有数据");
            }
            //导入列表去重
            List<PolicyVO> passList1 = new ArrayList<>(new HashSet(passList));
            Map<String, Object> map = new HashMap<>();
            map.put("passList",passList1);
            map.put("failList",failList);
            map.put("userName",ShiroUtils.getUser().getName());
            map.put("saasId",ShiroUtils.getSaasId());
            Map resultMaps = fpEdorMainClient.importEdor(map);
            jsonObject = JSONObject.parseObject(JSON.toJSONString(resultMaps));
        } catch (Exception e) {
            log.error("保全导入异常！edorImportException={}",e);
        }
        return jsonObject.toJSONString();
    }

    // Excel日期数据格式化
    private Date getCellDate(Cell cell) throws ParseException {
        Date date = null;
        if(cell.getCellTypeEnum()==CellType.NUMERIC) {
            date = sf1.parse(cell.getDateCellValue().toString());
        } else {
            cell.setCellType(CellType.STRING);
            try{
                date = sf3.parse(cell.getStringCellValue());
            } catch (Exception e) {
                try {
                    date = sf2.parse(cell.getStringCellValue());
                } catch (Exception e1) {
                    date = sf4.parse(cell.getStringCellValue());
                }
            }
        }
        return date;
    }
}
*/
