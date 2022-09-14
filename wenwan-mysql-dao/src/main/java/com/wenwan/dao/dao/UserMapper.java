package com.wenwan.dao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwan.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
