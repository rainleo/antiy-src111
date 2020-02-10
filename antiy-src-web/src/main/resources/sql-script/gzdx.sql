/*
 Navicat Premium Data Transfer

 Source Server         : 贵州电信
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : gzdx

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 10/02/2020 11:52:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for task_info
-- ----------------------------
DROP TABLE IF EXISTS `task_info`;
CREATE TABLE `task_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `task_type` int(11) DEFAULT NULL COMMENT '1.排雷2.扫雷',
  `task_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `start_time` bigint(20) NOT NULL,
  `end_time` bigint(20) NOT NULL,
  `task_status` tinyint(4) DEFAULT NULL COMMENT '1.进行中2.已关闭',
  `create_user` bigint(20) NOT NULL,
  `modify_user` bigint(20) DEFAULT NULL,
  `gmt_create` bigint(20) NOT NULL,
  `gmt_modify` bigint(20) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name_type`(`task_name`, `task_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for vul_examine_info
-- ----------------------------
DROP TABLE IF EXISTS `vul_examine_info`;
CREATE TABLE `vul_examine_info`  (
  `id` int(11) NOT NULL,
  `vul_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `examiner` bigint(20) NOT NULL,
  `result` int(11) NOT NULL COMMENT '2通过3未通过',
  `reason` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `examine_material_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `examine_material_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `examine_date` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for vul_info
-- ----------------------------
DROP TABLE IF EXISTS `vul_info`;
CREATE TABLE `vul_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vul_no` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vul_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` tinyint(4) DEFAULT NULL COMMENT '1.扫雷,2.排雷',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vul_port` int(11) NOT NULL,
  `vul_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address_owner` int(11) NOT NULL,
  `vul_type` tinyint(20) NOT NULL COMMENT '1.Web应用漏洞2.主机系统漏洞3.移动APP漏洞4.弱口令类漏洞',
  `vul_level` tinyint(4) NOT NULL COMMENT '1高危漏洞，2中危漏洞3.低危漏洞',
  `event_level` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'A,B,C,D拼接',
  `vul_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `repair_suggest` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vul_material_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vul_material_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vul_status` tinyint(4) DEFAULT NULL COMMENT '1待审核2通过3未通过',
  `task_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `system_type` tinyint(4) DEFAULT NULL COMMENT '1.普通系统2.重要或设计用户敏感信息系统',
  `create_user` bigint(20) DEFAULT NULL,
  `modify_user` bigint(20) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modify` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT 1 COMMENT '0删除1正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for vul_integral_info
-- ----------------------------
DROP TABLE IF EXISTS `vul_integral_info`;
CREATE TABLE `vul_integral_info`  (
  `id` int(11) NOT NULL,
  `task_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `intergral_event` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vul_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vul_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `vul_port` int(11) NOT NULL,
  `commit_date` bigint(20) NOT NULL,
  `grade` int(11) NOT NULL,
  `commit_user` bigint(20) NOT NULL,
  `department` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
