package com.wenwan.dao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenwan.dao.entity.SourceFile;
import com.wenwan.model.FilePattern;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SourceFileMapper extends BaseMapper<SourceFile> {

    @Select({"<script>" +
            " select * from source_file" +
            " <where>" +
            " <if test='filePattern.filePathRegular != null and filePattern.filePathRegular !=\"\" '>" +
            " and file_path regexp #{filePattern.filePathRegular}" +
            " </if>" +
            " <if test='filePattern.fileNameRegular != null and filePattern.fileNameRegular !=\"\" '>" +
            " and file_name regexp #{filePattern.fileNameRegular} " +
            " </if>" +
            " <if test='filePattern.senderRegular != null and filePattern.senderRegular !=\"\" '>" +
            " and sender regexp #{filePattern.senderRegular} " +
            " </if>" +
            " <if test='filePattern.receiverRegular != null and filePattern.receiverRegular !=\"\" '>" +
            " and receiver regexp #{filePattern.receiverRegular} " +
            " </if>" +
            " <if test='filePattern.themeRegular != null and filePattern.themeRegular !=\"\" '>" +
            " and theme regexp #{filePattern.themeRegular} " +
            " </if>" +
            " <if test='filePattern.labels != null and filePattern.labels !=\"\" '>" +
            " and labels = #{filePattern.labels} " +
            " </if>" +
            " <if test='filePattern.status != null'>" +
            " and status = #{filePattern.status} " +
            " </if>" +
            " <if test='filePattern.id != null'>" +
            " and id > #{filePattern.id} " +
            " </if>" +
            "ORDER BY id" +
            " <if test='filePattern.size != null'>" +
            " limit #{filePattern.size}" +
            " </if>" +
            " </where>" +
            "</script>"
    })
    List<SourceFile> regexp4Sort(@Param("filePattern") FilePattern filePattern);

    @Select({"<script>" +
            " select a.* from source_file a" +
            " left join business_log b on a.id=b.file_id and b.file_id is null" +//未加载的
            " left join source_file_label c on a.id=c.file_id" +
            " where a.status=1" +//已分拣
            " <if test='filePattern.filePathRegular != null and filePattern.filePathRegular !=\"\" '>" +
            " and a.file_path regexp #{filePattern.filePathRegular}" +
            " </if>" +
            " <if test='filePattern.fileNameRegular != null and filePattern.fileNameRegular !=\"\" '>" +
            " and a.file_name regexp #{filePattern.fileNameRegular} " +
            " </if>" +
            " <if test='filePattern.senderRegular != null and filePattern.senderRegular !=\"\" '>" +
            " and a.sender regexp #{filePattern.senderRegular} " +
            " </if>" +
            " <if test='filePattern.receiverRegular != null and filePattern.receiverRegular !=\"\" '>" +
            " and a.receiver regexp #{filePattern.receiverRegular} " +
            " </if>" +
            " <if test='filePattern.themeRegular != null and filePattern.themeRegular !=\"\" '>" +
            " and a.theme regexp #{filePattern.themeRegular} " +
            " </if>" +
            " <if test='filePattern.labels != null'>" +
            " and c.label_id in "+
            " <foreach collection='filePattern.labels' item='labelId' open='(' separator=',' close=')' >"+
            "#{labelId}"+
            " </foreach>"+
            " </if>" +
            " <if test='filePattern.id != null'>" +
            " and a.id &lt;= #{filePattern.id} " +
            " </if>" +
            "</script>"
    })
    List<SourceFile> regexp4Parse(@Param("filePattern") FilePattern filePattern);
}
