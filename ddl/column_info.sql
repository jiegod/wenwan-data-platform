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
