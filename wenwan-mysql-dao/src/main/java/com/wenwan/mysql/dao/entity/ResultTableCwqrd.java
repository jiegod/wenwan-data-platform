package com.wenwan.mysql.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("result_table_cwqrd")
@ApiModel("结果解析表-场外确认单")
public class ResultTableCwqrd extends ResultTable{

}
