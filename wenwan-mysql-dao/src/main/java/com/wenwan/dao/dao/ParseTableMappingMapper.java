package com.wenwan.dao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwan.dao.entity.ParseTableMapping;
import com.wenwan.model.parse.ParseRuleTableVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ParseTableMappingMapper extends BaseMapper<ParseTableMapping> {

    @Select({
            "<script>",
            "select a.parse_rule_id, a.order, b.id as tableId, b.db_name, b.table_name, b.comment",
            "from parse_table_mapping a inner join table_info b on a.table_id = b.id",
            "where a.parse_rule_id in",
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<ParseRuleTableVo> getTableByParseRuleIds(@Param("ids") List<Long> ids);
}
