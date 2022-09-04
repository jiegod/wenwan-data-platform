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
