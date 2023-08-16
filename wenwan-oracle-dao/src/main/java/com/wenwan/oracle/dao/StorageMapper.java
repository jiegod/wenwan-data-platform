package com.wenwan.oracle.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StorageMapper {
    void execStorage(String sql);
}
