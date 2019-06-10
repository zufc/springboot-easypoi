package com.zfc.study.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.alibaba.fastjson.JSONObject;
import com.zfc.study.entity.User;
import com.zfc.study.util.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author zufeichao
 * @ProjectName springboot-easypoi
 * @Description TODO
 * @Date 2019-06-10 16:19
 **/
@RestController
@RequestMapping("/excel/import")
public class ExcelImportController {

    private Logger logger = LoggerFactory.getLogger(ExcelImportController.class);

    @PostMapping("/importExcel")
    public String importExcel(@RequestParam("file")MultipartFile file){
        ImportParams importParams = new ImportParams();
        importParams.setHeadRows(1);
        importParams.setTitleRows(1);
        importParams.setNeedVerfiy(false);

        try {
            //ExcelImportResult<User> result = ExcelImportUtil.importExcelMore(file.getInputStream(),User.class,importParams);
           // List<User> userList = result.getList();
            List<User> userList = ExcelUtils.importExcel(file,0,1,User.class);
            userList.forEach(user->{
                logger.info("从Excel导入数据到数据库的详细为：{}", JSONObject.toJSONString(user));
            });
            logger.info("导入共{}条数据",userList.size());
        }/*catch (IOException ioe){
            logger.warn(ioe.getMessage());
        }*/catch (Exception e){
            logger.warn(e.getMessage());
        }
        return "导入成功";
    }
}
