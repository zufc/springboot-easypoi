package com.zfc.study.service.impl;

import com.google.common.collect.Lists;
import com.zfc.study.entity.User;
import com.zfc.study.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author zufeichao
 * @ProjectName springboot-easypoi
 * @Description TODO
 * @Date 2019-06-10 14:06
 **/
@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> selectList() {


        List<User> list = Lists.newArrayList();
        User user = new User();
        user.setId(10);
        user.setName("张三");
        user.setSex("男");
        user.setBirthday("2017-05-19");
        User user1 = new User();
        user1.setId(20);
        user1.setName("李四");
        user1.setSex("男");
        user1.setBirthday("2017-05-19");

        User user2 = new User();
        user2.setId(20);
        user2.setName("王五");
        user2.setSex("男");
        user2.setBirthday("2017-05-19");
        list.add(user);
        list.add(user1);
        list.add(user2);

        return list;

    }
}
