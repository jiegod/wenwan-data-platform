package com.wenwan.mysql.dao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwan.mysql.dao.entity.BusinessLogCnsj;
import com.wenwan.mysql.dao.entity.BusinessLogCwjz;
import org.apache.ibatis.annotations.Select;

public interface BusinessLogCwjzMapper extends BaseMapper<BusinessLogCwjz> {
    @Select("select * from business_log_cwjz where table_status = 0 limit 1 for update")
    BusinessLogCwjz getUnStartOneRow();

    @Select("select * from business_log_cwjz where table_status = 2 and parse_status = 0 limit 1 for update")
    BusinessLogCwjz getUnStartParseTaskOneRow();
}
