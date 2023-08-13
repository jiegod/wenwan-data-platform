package com.wenwan.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("business_log_cwqrd")
@ApiModel("场外确认单")
public class BusinessLogCwqrd extends BusinessLog {


}
