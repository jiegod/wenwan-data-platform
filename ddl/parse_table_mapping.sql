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
