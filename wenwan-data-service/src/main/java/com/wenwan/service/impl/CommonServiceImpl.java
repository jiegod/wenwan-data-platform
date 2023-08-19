package com.wenwan.service.impl;

import com.wenwan.common.constant.CommonConst;
import com.wenwan.model.StaticLabel;
import com.wenwan.service.api.ConfigCenter;
import com.wenwan.service.api.common.CommonService;
import com.wenwan.service.constant.TypeCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommonServiceImpl extends ConfigCenter implements CommonService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Set<StaticLabel>> getStaticTypeList(String key) {
        Map<String, Set<StaticLabel>> result = new HashMap<>();
        result.put(CommonConst.RECEIVER_EMAIL, getReceivers().stream().map(s ->
            new StaticLabel(s, s)).collect(Collectors.toSet()));
        result.put(CommonConst.DATASOURCE, TypeCache.dataSource);
        result.put(CommonConst.FILE_TYPE, TypeCache.fileType);
        result.put(CommonConst.BUSINESS_LOG, TypeCache.businessLog);
        return result;
    }

    @Override
    public List<Map<String, String>> executeDynamicQuery(String dynamicSql) {
        RowMapper<Map<String, String>> rowMapper = new RowMapper<Map<String, String>>() {
            @Override
            public Map<String, String> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                int columnCount = resultSet.getMetaData().getColumnCount();
                Map<String, String> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = resultSet.getMetaData().getColumnName(i);
                    String value = resultSet.getString(i);
                    row.put(columnName, value);
                }
                return row;
            }
        };

        return jdbcTemplate.query(dynamicSql, rowMapper);
    }

    @Override
    public int count(String db, String table) {
        String countSql = "SELECT COUNT(*) FROM " + db+ "." + table;
        return jdbcTemplate.queryForObject(countSql, Integer.class);
    }
}
