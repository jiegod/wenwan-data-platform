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
