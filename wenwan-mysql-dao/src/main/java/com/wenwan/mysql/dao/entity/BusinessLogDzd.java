package com.wenwan.mysql.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("business_log_dzd")
@ApiModel("对账单")
public class BusinessLogDzd extends BusinessLog {


}
