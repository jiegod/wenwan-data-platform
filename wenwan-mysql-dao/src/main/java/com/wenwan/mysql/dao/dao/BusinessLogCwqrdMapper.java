package com.wenwan.mysql.dao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwan.mysql.dao.entity.BusinessLogCwqrd;
import org.apache.ibatis.annotations.Select;

public interface BusinessLogCwqrdMapper extends BaseMapper<BusinessLogCwqrd> {

    @Select("select * from business_log_cwqrd where table_status = 0 limit 1 for update")
    BusinessLogCwqrd getUnStartOneRow();
}
