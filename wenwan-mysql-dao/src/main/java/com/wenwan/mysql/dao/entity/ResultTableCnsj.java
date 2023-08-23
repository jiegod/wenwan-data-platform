package com.wenwan.mysql.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("result_table_cnsj")
@ApiModel("结果解析表-场内数据")
public class ResultTableCnsj extends ResultTable{

}
