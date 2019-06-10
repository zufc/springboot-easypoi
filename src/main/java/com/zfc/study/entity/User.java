package com.zfc.study.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @Author zufeichao
 * @ProjectName springboot-easypoi
 * @Description TODO
 * @Date 2019-06-10 13:37
 **/
@ExcelTarget("20")
public class User implements Serializable {

    @Excel(name = "id")
    private Integer id;

    @Excel(name = "姓名",orderNum = "0")
    private String name;

    @Excel(name = "性别",orderNum = "1")
    private String sex;

    @Excel(name ="生日",orderNum = "2")
    private String birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        String s = null;
        try {
            s = JSON.toJSONString(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return s;
    }
}

