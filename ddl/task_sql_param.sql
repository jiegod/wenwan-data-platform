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
