package com.wenwan.oracle.dao.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wenwan.oracle.dao.dao.UserMapper;
import com.wenwan.oracle.dao.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.List;

@Configuration
@Slf4j
public class oracle implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        LambdaQueryWrapper wrapper = Wrappers.lambdaQuery(User.class).eq(User::getId, 1);
        List<User> userList = userMapper.selectList(wrapper);
        log.info("oracle startUp user:{}", userList);
    }

    @Resource
    private UserMapper userMapper;
}
