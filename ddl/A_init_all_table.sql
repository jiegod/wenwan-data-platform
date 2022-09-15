/*
Navicat MySQL Data Transfer

Source Server         : wenwan
Source Server Version : 80025
Source Host           : rm-bp1z0r275698r8y64so.mysql.rds.aliyuncs.com:3306
Source Database       : wenwan

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2022-09-15 19:26:42
*/
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business_log
-- ----------------------------
DROP TABLE
    IF EXISTS `business_log`;

CREATE TABLE `business_log`
(
    `id`             BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`           VARCHAR(32) DEFAULT NULL COMMENT 'name',
    `file_id`        VARCHAR(32) DEFAULT NULL COMMENT 'fileId',
    `receiver`       VARCHAR(32) DEFAULT NULL COMMENT 'receiver',
    `sender`         VARCHAR(32) DEFAULT NULL COMMENT 'sender',
    `theme`          VARCHAR(32) DEFAULT NULL COMMENT 'theme',
    `receive_date`   VARCHAR(32) DEFAULT NULL COMMENT 'receiveDate',
    `content`        VARCHAR(32) DEFAULT NULL COMMENT 'content',
    `file_name`      VARCHAR(32) DEFAULT NULL COMMENT 'fileName',
    `file_path`      VARCHAR(32) DEFAULT NULL COMMENT 'filePath',
    `file_type`      VARCHAR(32) DEFAULT NULL COMMENT 'fileType',
    `data_source`    VARCHAR(32) DEFAULT NULL COMMENT 'dataSource',
    `status`         VARCHAR(32) DEFAULT NULL COMMENT 'status',
    `operator`       VARCHAR(32) DEFAULT NULL COMMENT 'operator',
    `operation_date` VARCHAR(10) DEFAULT NULL COMMENT 'operationDate',
    `create_time`    datetime    DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time`    datetime    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3;

-- ----------------------------
-- Table structure for column_info
-- ----------------------------
DROP TABLE
    IF EXISTS `column_info`;

CREATE TABLE `column_info`
(
    `id`             BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`           VARCHAR(32)         DEFAULT NULL COMMENT 'name',
    `table_id`       VARCHAR(32)         DEFAULT NULL COMMENT 'tableId',
    `comment`        VARCHAR(32)         DEFAULT NULL COMMENT 'comment',
    `type`           VARCHAR(32)         DEFAULT NULL COMMENT 'type',
    `length`         VARCHAR(32)         DEFAULT NULL COMMENT 'length',
    `operator`       VARCHAR(32)         DEFAULT NULL COMMENT 'operator',
    `operation_date` VARCHAR(10) CHARACTER
        SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'operationDate',
    `create_time`    datetime            DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time`    datetime            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unx_co_table` (`name`, `table_id`) USING BTREE
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3;

-- ----------------------------
-- Table structure for file_type
-- ----------------------------
DROP TABLE
    IF EXISTS `file_type`;

CREATE TABLE `file_type`
(
    `id`             BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`           VARCHAR(32)         DEFAULT NULL COMMENT 'name',
    `operator`       VARCHAR(32)         DEFAULT NULL COMMENT 'operator',
    `operation_date` VARCHAR(10) CHARACTER
        SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'operationDate',
    `create_time`    datetime            DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time`    datetime            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3;

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE
    IF EXISTS `label`;

CREATE TABLE `label`
(
    `id`             BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`           VARCHAR(32)         DEFAULT NULL COMMENT 'name',
    `operator`       VARCHAR(32)         DEFAULT NULL COMMENT 'operator',
    `receiver`       VARCHAR(32)         DEFAULT NULL COMMENT 'receiver',
    `operation_date` VARCHAR(10) CHARACTER
        SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'operationDate',
    `create_time`    datetime            DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time`    datetime            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3;

-- ----------------------------
-- Table structure for parse_rule
-- ----------------------------
DROP TABLE
    IF EXISTS `parse_rule`;

CREATE TABLE `parse_rule`
(
    `id`                BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `code`              VARCHAR(32)      DEFAULT NULL COMMENT 'code',
    `name`              VARCHAR(32)      DEFAULT NULL COMMENT 'name',
    `data_source`       VARCHAR(32)      DEFAULT NULL COMMENT 'dataSource',
    `priority`          VARCHAR(32)      DEFAULT NULL COMMENT 'priority',
    `file_type`         VARCHAR(32)      DEFAULT NULL COMMENT 'fileType',
    `business_log`      VARCHAR(32)      DEFAULT NULL COMMENT 'businessLog',
    `description`       VARCHAR(32)      DEFAULT NULL COMMENT 'description',
    `file_path_regular` VARCHAR(32)      DEFAULT NULL COMMENT 'filePathRegular',
    `file_name_regular` VARCHAR(32)      DEFAULT NULL COMMENT 'fileNameRegular',
    `sender_regular`    VARCHAR(32)      DEFAULT NULL COMMENT 'senderRegular',
    `receiver_regular`  VARCHAR(32)      DEFAULT NULL COMMENT 'receiverRegular',
    `theme_regular`     VARCHAR(32)      DEFAULT NULL COMMENT 'themeRegular',
    `status`            VARCHAR(32)      DEFAULT NULL COMMENT 'status',
    `operator`          VARCHAR(32)      DEFAULT NULL COMMENT 'operator',
    `operation_date`    VARCHAR(10) CHARACTER
        SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'operationDate',
    `create_time`       datetime         DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time`       datetime         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3;

-- ----------------------------
-- Table structure for parse_table_mapping
-- ----------------------------
DROP TABLE
    IF EXISTS `parse_table_mapping`;

CREATE TABLE `parse_table_mapping`
(
    `id`             BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `parse_rule_id`  VARCHAR(32)         DEFAULT NULL COMMENT 'parseRuleId',
    `table_id`       VARCHAR(32)         DEFAULT NULL COMMENT 'tableId',
    `status`         VARCHAR(32)         DEFAULT NULL COMMENT 'status',
    `order`          VARCHAR(32)         DEFAULT NULL COMMENT 'order',
    `operator`       VARCHAR(32)         DEFAULT NULL COMMENT 'operator',
    `operation_date` VARCHAR(10) CHARACTER
        SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'operationDate',
    `create_time`    datetime            DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time`    datetime            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unx_ruleid_tableid` (`parse_rule_id`, `table_id`) USING BTREE
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3;

-- ----------------------------
-- Table structure for sort_rule
-- ----------------------------
DROP TABLE
    IF EXISTS `sort_rule`;

CREATE TABLE `sort_rule`
(
    `id`                BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `labels`            VARCHAR(32)      DEFAULT NULL COMMENT 'labels',
    `name`              VARCHAR(32)      DEFAULT NULL COMMENT 'name',
    `receiver_regular`  VARCHAR(32)      DEFAULT NULL COMMENT 'receiverRegular',
    `sender_regular`    VARCHAR(32)      DEFAULT NULL COMMENT 'senderRegular',
    `theme_regular`     VARCHAR(32)      DEFAULT NULL COMMENT 'themeRegular',
    `file_name_regular` VARCHAR(32)      DEFAULT NULL COMMENT 'fileNameRegular',
    `priority`          VARCHAR(32)      DEFAULT NULL COMMENT 'priority',
    `expire_start`      VARCHAR(32)      DEFAULT NULL COMMENT 'expireStart',
    `expire_end`        VARCHAR(32)      DEFAULT NULL COMMENT 'expireEnd',
    `operator`          VARCHAR(32)      DEFAULT NULL COMMENT 'operator',
    `operation_date`    VARCHAR(10) CHARACTER
        SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'operationDate',
    `create_time`       datetime         DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time`       datetime         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3 COMMENT = 'sort rule';

-- ----------------------------
-- Table structure for source_file
-- ----------------------------
DROP TABLE
    IF EXISTS `source_file`;

CREATE TABLE `source_file`
(
    `id`             BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `receiver`       VARCHAR(32)         DEFAULT NULL COMMENT 'receiver',
    `sender`         VARCHAR(32)         DEFAULT NULL COMMENT 'sender',
    `theme`          VARCHAR(32)         DEFAULT NULL COMMENT 'theme',
    `receive_date`   VARCHAR(32)         DEFAULT NULL COMMENT 'receiveDate',
    `content`        text CHARACTER
        SET utf8 COLLATE utf8_general_ci COMMENT 'content',
    `file_name`      VARCHAR(32)         DEFAULT NULL COMMENT 'fileName',
    `file_path`      VARCHAR(32)         DEFAULT NULL COMMENT 'filePath',
    `labels`         VARCHAR(32)         DEFAULT NULL COMMENT 'labels',
    `description`    VARCHAR(32)         DEFAULT NULL COMMENT 'description',
    `operator`       VARCHAR(32)         DEFAULT NULL COMMENT 'operator',
    `operation_date` VARCHAR(10) CHARACTER
        SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'operationDate',
    `create_time`    datetime            DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time`    datetime            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3;

-- ----------------------------
-- Table structure for sql_log
-- ----------------------------
DROP TABLE
    IF EXISTS `sql_log`;

CREATE TABLE `sql_log`
(
    `id`              BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `parse_rule_id`   VARCHAR(32)        DEFAULT NULL COMMENT 'parseRuleId',
    `parse_rule_code` VARCHAR(32)        DEFAULT NULL COMMENT 'parseRuleCode',
    `file_id`         VARCHAR(32)        DEFAULT NULL COMMENT 'fileId',
    `task_group_id`   VARCHAR(32)        DEFAULT NULL COMMENT 'taskGroupId',
    `task_group_code` VARCHAR(32)        DEFAULT NULL COMMENT 'taskGroupCode',
    `task_sql_id`     VARCHAR(32)        DEFAULT NULL COMMENT 'taskSqlId',
    `task_sql_code`   VARCHAR(32)        DEFAULT NULL COMMENT 'taskSqlCode',
    `type`            VARCHAR(32)        DEFAULT NULL COMMENT 'type',
    `priority`        VARCHAR(32)        DEFAULT NULL COMMENT 'priority',
    `status`          VARCHAR(32)        DEFAULT NULL COMMENT 'status',
    `cost_time`       VARCHAR(32)        DEFAULT NULL COMMENT 'costTime',
    `error`           VARCHAR(32)        DEFAULT NULL COMMENT 'error',
    `operator`        VARCHAR(32)        DEFAULT NULL COMMENT 'operator',
    `operation_date`  VARCHAR(10) CHARACTER
        SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'operationDate',
    `create_time`     datetime           DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time`     datetime           DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3;

-- ----------------------------
-- Table structure for table_info
-- ----------------------------
DROP TABLE
    IF EXISTS `table_info`;

CREATE TABLE `table_info`
(
    `id`             BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `db_name`        VARCHAR(32)         DEFAULT NULL COMMENT 'dbName',
    `table_name`     VARCHAR(32)         DEFAULT NULL COMMENT 'tableName',
    `comment`        VARCHAR(32)         DEFAULT NULL COMMENT 'comment',
    `operator`       VARCHAR(32)         DEFAULT NULL COMMENT 'operator',
    `operation_date` VARCHAR(10) CHARACTER
        SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'operationDate',
    `create_time`    datetime            DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time`    datetime            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3;

-- ----------------------------
-- Table structure for task_group
-- ----------------------------
DROP TABLE
    IF EXISTS `task_group`;

CREATE TABLE `task_group`
(
    `id`              BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `parse_rule_id`   VARCHAR(32)        DEFAULT NULL COMMENT 'parseRuleId',
    `parse_rule_code` VARCHAR(32)        DEFAULT NULL COMMENT 'parseRuleCode',
    `code`            VARCHAR(32)        DEFAULT NULL COMMENT 'code',
    `name`            VARCHAR(32)        DEFAULT NULL COMMENT 'name',
    `desc`            VARCHAR(32)        DEFAULT NULL COMMENT 'desc',
    `operator`        VARCHAR(32)        DEFAULT NULL COMMENT 'operator',
    `operation_date`  VARCHAR(10) CHARACTER
        SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'operationDate',
    `create_time`     datetime           DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time`     datetime           DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3;

-- ----------------------------
-- Table structure for task_sql
-- ----------------------------
DROP TABLE
    IF EXISTS `task_sql`;

CREATE TABLE `task_sql`
(
    `id`              BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `code`            VARCHAR(32)        DEFAULT NULL COMMENT 'code',
    `task_group_id`   VARCHAR(32)        DEFAULT NULL COMMENT 'taskGroupId',
    `task_group_code` VARCHAR(32)        DEFAULT NULL COMMENT 'taskGroupCode',
    `type`            VARCHAR(32)        DEFAULT NULL COMMENT 'type',
    `status`          VARCHAR(32)        DEFAULT NULL COMMENT 'status',
    `priority`        VARCHAR(32)        DEFAULT NULL COMMENT 'priority',
    `content`         text CHARACTER
        SET utf8 COLLATE utf8_general_ci COMMENT 'content',
    `operator`        VARCHAR(32)        DEFAULT NULL COMMENT 'operator',
    `operation_date`  VARCHAR(10) CHARACTER
        SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'operationDate',
    `create_time`     datetime           DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time`     datetime           DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3;

-- ----------------------------
-- Table structure for task_sql_param
-- ----------------------------
DROP TABLE
    IF EXISTS `task_sql_param`;

CREATE TABLE `task_sql_param`
(
    `id`             BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `task_sql_id`    VARCHAR(32)         DEFAULT NULL COMMENT 'taskSqlId',
    `task_sql_code`  VARCHAR(32)         DEFAULT NULL COMMENT 'taskSqlCode',
    `group`          VARCHAR(32)         DEFAULT NULL COMMENT 'group',
    `key`            VARCHAR(32)         DEFAULT NULL COMMENT 'key',
    `value`          VARCHAR(32)         DEFAULT NULL COMMENT 'value',
    `operator`       VARCHAR(32)         DEFAULT NULL COMMENT 'operator',
    `operation_date` VARCHAR(10) CHARACTER
        SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'operationDate',
    `create_time`    datetime            DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time`    datetime            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE
    IF EXISTS `user`;

CREATE TABLE `user`
(
    `id`          BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `username`    VARCHAR(32) CHARACTER
        SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'name',
    `password`    VARCHAR(64)            DEFAULT NULL,
    `create_time` datetime               DEFAULT CURRENT_TIMESTAMP COMMENT 'createTime',
    `update_time` datetime               DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'update_time',
    PRIMARY KEY (`id`)
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3;

