package com.wenwan.mysql.dao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwan.mysql.dao.entity.BusinessLogDzd;
import org.apache.ibatis.annotations.Select;

public interface BusinessLogDzdMapper extends BaseMapper<BusinessLogDzd>  {
    @Select("select * from business_log_dzd where table_status = 0 limit 1 for update")
    BusinessLogDzd getUnStartOneRow();
}
