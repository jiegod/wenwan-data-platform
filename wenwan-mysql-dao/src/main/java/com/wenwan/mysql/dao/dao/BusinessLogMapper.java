package com.wenwan.mysql.dao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import com.wenwan.mysql.dao.entity.BusinessLog;

public interface BusinessLogMapper extends BaseMapper<BusinessLog> {

    @Select("select * from business_log where table_status = 0 limit 1 for update")
    BusinessLog getUnStartOneRow();
}
