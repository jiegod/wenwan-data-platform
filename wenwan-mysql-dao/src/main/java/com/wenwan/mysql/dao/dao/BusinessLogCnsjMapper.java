package com.wenwan.mysql.dao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwan.mysql.dao.entity.BusinessLogCnsj;
import org.apache.ibatis.annotations.Select;

public interface BusinessLogCnsjMapper extends BaseMapper<BusinessLogCnsj> {
    @Select("select * from business_log_cnsj where table_status = 0 limit 1 for update")
    BusinessLogCnsj getUnStartOneRow();
}
