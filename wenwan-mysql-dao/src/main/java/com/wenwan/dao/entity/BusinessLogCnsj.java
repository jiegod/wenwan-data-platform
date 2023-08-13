package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("business_log_cnsj")
@ApiModel("场内数据")
public class BusinessLogCnsj extends BusinessLog {


}
