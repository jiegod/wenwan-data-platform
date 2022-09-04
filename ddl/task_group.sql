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
