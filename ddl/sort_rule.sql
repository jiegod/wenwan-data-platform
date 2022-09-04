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
