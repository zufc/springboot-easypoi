package com.zfc.study.controller;

import com.zfc.study.entity.User;
import com.zfc.study.service.UserService;
import com.zfc.study.util.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author zufeichao
 * @ProjectName springboot-easypoi
 * @Description TODO
 * @Date 2019-06-10 14:08
 **/
@RestController
@RequestMapping(value = "/excel/export")
public class ExcelExportController {

    @Autowired
    private UserService userService;

    @GetMapping("/exportExcel")
    public void export(HttpServletResponse response) {
        System.out.println(1);
        // 模拟从数据库获取需要导出的数据
        List<User> personList = userService.selectList();
        // 导出操作
        ExcelUtils.exportExcel(personList, "easypoi导出功能", "导出sheet1", User.class, "测试user.xls", response);


    }
}
