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
