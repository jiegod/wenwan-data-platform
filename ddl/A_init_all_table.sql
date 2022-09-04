DROP TABLE IF EXISTS `business_log`;
CREATE TABLE `business_log` (
  `id` bigint NOT NULL AUTO_INCREMENT comment 'id',
  `name` varchar(32) DEFAULT NULL comment 'name',
  `file_id` varchar(32) DEFAULT NULL comment 'fileId',
  `receiver` varchar(32) DEFAULT NULL comment 'receiver',
  `sender` varchar(32) DEFAULT NULL comment 'sender',
  `theme` varchar(32) DEFAULT NULL comment 'theme',
  `receive_date` varchar(32) DEFAULT NULL comment 'receiveDate',
  `content` varchar(32) DEFAULT NULL comment 'content',
  `file_name` varchar(32) DEFAULT NULL comment 'fileName',
  `file_path` varchar(32) DEFAULT NULL comment 'filePath',
  `file_type` varchar(32) DEFAULT NULL comment 'fileType',
  `data_source` varchar(32) DEFAULT NULL comment 'dataSource',
  `status` varchar(32) DEFAULT NULL comment 'status',
  `operator` varchar(32) DEFAULT NULL comment 'operator',
  `operation_date` varchar(32) DEFAULT NULL comment 'operationDate',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `column_info`;
CREATE TABLE `column_info` (
  `id` bigint NOT NULL AUTO_INCREMENT comment 'id',
  `name` varchar(32) DEFAULT NULL comment 'name',
  `table_id` varchar(32) DEFAULT NULL comment 'tableId',
  `comment` varchar(32) DEFAULT NULL comment 'comment',
  `type` varchar(32) DEFAULT NULL comment 'type',
  `length` varchar(32) DEFAULT NULL comment 'length',
  `operator` varchar(32) DEFAULT NULL comment 'operator',
  `operation_date` varchar(32) DEFAULT NULL comment 'operationDate',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `file_type`;
CREATE TABLE `file_type` (
  `id` bigint NOT NULL AUTO_INCREMENT comment 'id',
  `name` varchar(32) DEFAULT NULL comment 'name',
  `operator` varchar(32) DEFAULT NULL comment 'operator',
  `operation_date` varchar(32) DEFAULT NULL comment 'operationDate',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` bigint NOT NULL AUTO_INCREMENT comment 'id',
  `name` varchar(32) DEFAULT NULL comment 'name',
  `operator` varchar(32) DEFAULT NULL comment 'operator',
  `receiver` varchar(32) DEFAULT NULL comment 'receiver',
  `operation_date` varchar(32) DEFAULT NULL comment 'operationDate',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `parse_rule`;
CREATE TABLE `parse_rule` (
  `id` bigint NOT NULL AUTO_INCREMENT comment 'id',
  `code` varchar(32) DEFAULT NULL comment 'code',
  `name` varchar(32) DEFAULT NULL comment 'name',
  `data_source` varchar(32) DEFAULT NULL comment 'dataSource',
  `priority` varchar(32) DEFAULT NULL comment 'priority',
  `file_type` varchar(32) DEFAULT NULL comment 'fileType',
  `business_log` varchar(32) DEFAULT NULL comment 'businessLog',
  `description` varchar(32) DEFAULT NULL comment 'description',
  `file_path_regular` varchar(32) DEFAULT NULL comment 'filePathRegular',
  `file_name_regular` varchar(32) DEFAULT NULL comment 'fileNameRegular',
  `sender_regular` varchar(32) DEFAULT NULL comment 'senderRegular',
  `receiver_regular` varchar(32) DEFAULT NULL comment 'receiverRegular',
  `theme_regular` varchar(32) DEFAULT NULL comment 'themeRegular',
  `status` varchar(32) DEFAULT NULL comment 'status',
  `operator` varchar(32) DEFAULT NULL comment 'operator',
  `operation_date` varchar(32) DEFAULT NULL comment 'operationDate',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `parse_table_mapping`;
CREATE TABLE `parse_table_mapping` (
  `id` bigint NOT NULL AUTO_INCREMENT comment 'id',
  `parse_rule_id` varchar(32) DEFAULT NULL comment 'parseRuleId',
  `table_id` varchar(32) DEFAULT NULL comment 'tableId',
  `status` varchar(32) DEFAULT NULL comment 'status',
  `order` varchar(32) DEFAULT NULL comment 'order',
  `operator` varchar(32) DEFAULT NULL comment 'operator',
  `operation_date` varchar(32) DEFAULT NULL comment 'operationDate',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `sort_rule`;
CREATE TABLE `sort_rule` (
  `id` bigint NOT NULL AUTO_INCREMENT comment 'id',
  `labels` varchar(32) DEFAULT NULL comment 'labels',
  `name` varchar(32) DEFAULT NULL comment 'name',
  `receiver_regular` varchar(32) DEFAULT NULL comment 'receiverRegular',
  `sender_regular` varchar(32) DEFAULT NULL comment 'senderRegular',
  `theme_regular` varchar(32) DEFAULT NULL comment 'themeRegular',
  `file_name_regular` varchar(32) DEFAULT NULL comment 'fileNameRegular',
  `priority` varchar(32) DEFAULT NULL comment 'priority',
  `expire_start` varchar(32) DEFAULT NULL comment 'expireStart',
  `expire_end` varchar(32) DEFAULT NULL comment 'expireEnd',
  `operator` varchar(32) DEFAULT NULL comment 'operator',
  `operation_date` varchar(32) DEFAULT NULL comment 'operationDate',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `source_file`;
CREATE TABLE `source_file` (
  `id` bigint NOT NULL AUTO_INCREMENT comment 'id',
  `receiver` varchar(32) DEFAULT NULL comment 'receiver',
  `sender` varchar(32) DEFAULT NULL comment 'sender',
  `theme` varchar(32) DEFAULT NULL comment 'theme',
  `receive_date` varchar(32) DEFAULT NULL comment 'receiveDate',
  `content` varchar(32) DEFAULT NULL comment 'content',
  `file_name` varchar(32) DEFAULT NULL comment 'fileName',
  `file_path` varchar(32) DEFAULT NULL comment 'filePath',
  `labels` varchar(32) DEFAULT NULL comment 'labels',
  `description` varchar(32) DEFAULT NULL comment 'description',
  `operator` varchar(32) DEFAULT NULL comment 'operator',
  `operation_date` varchar(32) DEFAULT NULL comment 'operationDate',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `sql_log`;
CREATE TABLE `sql_log` (
  `id` bigint NOT NULL AUTO_INCREMENT comment 'id',
  `parse_rule_id` varchar(32) DEFAULT NULL comment 'parseRuleId',
  `parse_rule_code` varchar(32) DEFAULT NULL comment 'parseRuleCode',
  `file_id` varchar(32) DEFAULT NULL comment 'fileId',
  `task_group_id` varchar(32) DEFAULT NULL comment 'taskGroupId',
  `task_group_code` varchar(32) DEFAULT NULL comment 'taskGroupCode',
  `task_sql_id` varchar(32) DEFAULT NULL comment 'taskSqlId',
  `task_sql_code` varchar(32) DEFAULT NULL comment 'taskSqlCode',
  `type` varchar(32) DEFAULT NULL comment 'type',
  `priority` varchar(32) DEFAULT NULL comment 'priority',
  `status` varchar(32) DEFAULT NULL comment 'status',
  `cost_time` varchar(32) DEFAULT NULL comment 'costTime',
  `error` varchar(32) DEFAULT NULL comment 'error',
  `operator` varchar(32) DEFAULT NULL comment 'operator',
  `operation_date` varchar(32) DEFAULT NULL comment 'operationDate',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `table_info`;
CREATE TABLE `table_info` (
  `id` bigint NOT NULL AUTO_INCREMENT comment 'id',
  `db_name` varchar(32) DEFAULT NULL comment 'dbName',
  `table_name` varchar(32) DEFAULT NULL comment 'tableName',
  `comment` varchar(32) DEFAULT NULL comment 'comment',
  `operator` varchar(32) DEFAULT NULL comment 'operator',
  `operation_date` varchar(32) DEFAULT NULL comment 'operationDate',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `task_group`;
CREATE TABLE `task_group` (
  `id` bigint NOT NULL AUTO_INCREMENT comment 'id',
  `parse_rule_id` varchar(32) DEFAULT NULL comment 'parseRuleId',
  `parse_rule_code` varchar(32) DEFAULT NULL comment 'parseRuleCode',
  `code` varchar(32) DEFAULT NULL comment 'code',
  `name` varchar(32) DEFAULT NULL comment 'name',
  `desc` varchar(32) DEFAULT NULL comment 'desc',
  `operator` varchar(32) DEFAULT NULL comment 'operator',
  `operation_date` varchar(32) DEFAULT NULL comment 'operationDate',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `task_sql`;
CREATE TABLE `task_sql` (
  `id` bigint NOT NULL AUTO_INCREMENT comment 'id',
  `code` varchar(32) DEFAULT NULL comment 'code',
  `task_group_id` varchar(32) DEFAULT NULL comment 'taskGroupId',
  `task_group_code` varchar(32) DEFAULT NULL comment 'taskGroupCode',
  `type` varchar(32) DEFAULT NULL comment 'type',
  `status` varchar(32) DEFAULT NULL comment 'status',
  `priority` varchar(32) DEFAULT NULL comment 'priority',
  `content` varchar(32) DEFAULT NULL comment 'content',
  `operator` varchar(32) DEFAULT NULL comment 'operator',
  `operation_date` varchar(32) DEFAULT NULL comment 'operationDate',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `task_sql_param`;
CREATE TABLE `task_sql_param` (
  `id` bigint NOT NULL AUTO_INCREMENT comment 'id',
  `task_sql_id` varchar(32) DEFAULT NULL comment 'taskSqlId',
  `task_sql_code` varchar(32) DEFAULT NULL comment 'taskSqlCode',
  `group` varchar(32) DEFAULT NULL comment 'group',
  `key` varchar(32) DEFAULT NULL comment 'key',
  `value` varchar(32) DEFAULT NULL comment 'value',
  `operator` varchar(32) DEFAULT NULL comment 'operator',
  `operation_date` varchar(32) DEFAULT NULL comment 'operationDate',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT comment 'id',
  `name` varchar(32) DEFAULT NULL comment 'name',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT 'update_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
