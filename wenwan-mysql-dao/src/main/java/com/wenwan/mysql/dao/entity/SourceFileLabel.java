package com.wenwan.mysql.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("source_file_label")
public class SourceFileLabel extends BaseModel{

    private Long fileId;
    private Long labelId;
}
