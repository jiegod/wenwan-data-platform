package com.wenwan.dao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwan.dao.entity.BusinessLog;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BusinessLogMapper extends BaseMapper<BusinessLog> {

    @Select("select * from business_log where table_status = 0 limit 1 for update")
    BusinessLog getUnStartOneRow();
}
