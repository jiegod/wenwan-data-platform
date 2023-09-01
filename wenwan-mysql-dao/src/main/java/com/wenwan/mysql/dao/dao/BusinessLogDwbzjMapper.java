package com.wenwan.mysql.dao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwan.mysql.dao.entity.BusinessLogCnsj;
import com.wenwan.mysql.dao.entity.BusinessLogDwbzj;
import org.apache.ibatis.annotations.Select;

public interface BusinessLogDwbzjMapper extends BaseMapper<BusinessLogDwbzj> {
    @Select("select * from business_log_dwbzj where table_status = 0 limit 1 for update")
    BusinessLogDwbzj getUnStartOneRow();

    @Select("select * from business_log_dwbzj where table_status = 2 and parse_status = 0 limit 1 for update")
    BusinessLogCnsj getUnStartParseTaskOneRow();
}
