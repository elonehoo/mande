/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : mande

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 08/08/2022 10:17:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` varchar(32) NOT NULL COMMENT 'history id',
  `name` varchar(255) DEFAULT NULL COMMENT 'history name',
  `model_id` varchar(32) DEFAULT NULL COMMENT 'model id',
  `headers` longtext COMMENT 'request header',
  `content` longtext COMMENT 'request content',
  `state` bigint DEFAULT NULL COMMENT 'history state',
  `creation_time` datetime DEFAULT NULL COMMENT 'creation time',
  `modify_time` datetime DEFAULT NULL COMMENT 'modilfy time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Historical forwarding record table, which contains records of forwarding success and failure.';

-- ----------------------------
-- Table structure for model
-- ----------------------------
DROP TABLE IF EXISTS `model`;
CREATE TABLE `model` (
  `id` varchar(32) NOT NULL COMMENT 'key id',
  `name` varchar(255) DEFAULT NULL COMMENT 'model name',
  `url` longtext COMMENT 'model url',
  `method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'how to send the request',
  `creation_time` datetime DEFAULT NULL COMMENT 'create time',
  `modify_time` datetime DEFAULT NULL COMMENT 'change the time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='The forwarding reception table will record all types and urls of reception.';

-- ----------------------------
-- Records of model
-- ----------------------------
BEGIN;
INSERT INTO `model` (`id`, `name`, `url`, `method`, `creation_time`, `modify_time`) VALUES ('426789596681076736', 'get yoho', 'http://localhost:8080/mande/yoho/get', 'get', '2022-08-04 10:30:21', NULL);
INSERT INTO `model` (`id`, `name`, `url`, `method`, `creation_time`, `modify_time`) VALUES ('426789726129881088', 'post yoho', 'http://localhost:8080/mande/yoho/post', 'post', '2022-08-04 10:30:52', NULL);
INSERT INTO `model` (`id`, `name`, `url`, `method`, `creation_time`, `modify_time`) VALUES ('426789775811411968', 'put yoho', 'http://localhost:8080/mande/yoho/put', 'put', '2022-08-04 10:31:04', NULL);
INSERT INTO `model` (`id`, `name`, `url`, `method`, `creation_time`, `modify_time`) VALUES ('426789810821267456', 'delete yoho', 'http://localhost:8080/mande/yoho/delete', 'delete', '2022-08-04 10:31:12', NULL);
COMMIT;

-- ----------------------------
-- Table structure for whitelist
-- ----------------------------
DROP TABLE IF EXISTS `whitelist`;
CREATE TABLE `whitelist` (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'whitelist id',
  `app_key` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT 'whitelist token',
  `name` varchar(255) DEFAULT NULL COMMENT 'organization name',
  `creation_time` datetime DEFAULT NULL COMMENT 'create time',
  `modify_time` datetime DEFAULT NULL COMMENT 'change the time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='All users who can use the repository are recorded.';

-- ----------------------------
-- Records of whitelist
-- ----------------------------
BEGIN;
INSERT INTO `whitelist` (`id`, `app_key`, `name`, `creation_time`, `modify_time`) VALUES ('426496036073242624', 'yBXZo7L6bBdJUD1yd9WKxJJ6fRNjKdOxgUirVABAmEc8jkA4lwZCBeBRpaQWSD0Oqr8jqZBDn3ELw5QMHwf3BMahxYH9m8CaCNVmiUK7Pofvq5PYgks4P16gc3GM4TRKYD/ycrwF/mNMztSfUup23kaN4PLK8Tsh7g+jab0e/7g=', 'elonehoo', '2022-08-03 15:03:51', NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
