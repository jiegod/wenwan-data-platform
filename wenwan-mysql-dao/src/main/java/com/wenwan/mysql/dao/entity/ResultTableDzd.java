package com.wenwan.mysql.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("result_table_dzd")
@ApiModel("结果解析表-对账单")
public class ResultTableDzd extends ResultTable{

}
