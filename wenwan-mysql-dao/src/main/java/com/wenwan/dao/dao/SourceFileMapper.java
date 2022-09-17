package com.wenwan.dao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwan.dao.entity.SourceFile;
import com.wenwan.model.FilePattern;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SourceFileMapper extends BaseMapper<SourceFile> {

    @Select({"<script>"+
            " select * from source_file"+
            " <where>"+
            " <if test='filePattern.filePathRegular != null and filePattern.filePathRegular !=\"\" '>"+
            " and file_path = #{filePattern.filePathRegular}"+
            " </if>"+
            " <if test='filePattern.fileNameRegular != null and filePattern.fileNameRegular !=\"\" '>"+
            " and file_name = #{filePattern.fileNameRegular} "+
            " </if>"+
            " <if test='filePattern.senderRegular != null and filePattern.senderRegular !=\"\" '>"+
            " and sender = #{filePattern.senderRegular} "+
            " </if>"+
            " <if test='filePattern.receiverRegular != null and filePattern.receiverRegular !=\"\" '>"+
            " and receiver = #{filePattern.receiverRegular} "+
            " </if>"+
            " <if test='filePattern.themeRegular != null and filePattern.themeRegular !=\"\" '>"+
            " and theme = #{filePattern.themeRegular} "+
            " </if>"+
            " </where>"+
            "</script>"
    })
    List<SourceFile> regexp(@Param("filePattern") FilePattern filePattern);
}
