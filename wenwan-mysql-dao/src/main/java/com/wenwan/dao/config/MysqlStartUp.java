package com.wenwan.dao.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenwan.dao.dao.UserMapper;
import com.wenwan.dao.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Slf4j
public class MysqlStartUp implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        LambdaQueryWrapper wrapper = Wrappers.lambdaQuery(User.class).eq(User::getId, 1);
       List<User> userList =  userMapper.selectList(wrapper);
       log.info("mysql startUp user:{}", userList);
    }
}
