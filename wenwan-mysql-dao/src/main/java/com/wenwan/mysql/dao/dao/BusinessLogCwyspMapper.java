package com.wenwan.mysql.dao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwan.mysql.dao.entity.BusinessLogCnsj;
import com.wenwan.mysql.dao.entity.BusinessLogCwysp;
import org.apache.ibatis.annotations.Select;

public interface BusinessLogCwyspMapper extends BaseMapper<BusinessLogCwysp> {

    @Select("select * from business_log_cwysp where table_status = 0 limit 1 for update")
    BusinessLogCwysp getUnStartOneRow();

    @Select("select * from business_log_cwysp where table_status = 2 and parse_status = 0 limit 1 for update")
    BusinessLogCwysp getUnStartParseTaskOneRow();
}
