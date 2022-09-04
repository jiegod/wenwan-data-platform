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
