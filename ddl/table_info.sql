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
