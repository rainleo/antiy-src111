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

 Date: 18/02/2020 09:40:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '贵阳分公司');
INSERT INTO `department` VALUES (2, '遵义分公司');
INSERT INTO `department` VALUES (3, '安顺分公司');
INSERT INTO `department` VALUES (4, '黔南分公司');
INSERT INTO `department` VALUES (5, '黔东南分公司');
INSERT INTO `department` VALUES (6, '铜仁分公司');
INSERT INTO `department` VALUES (7, '毕节分公司');
INSERT INTO `department` VALUES (8, '六盘水分公司');
INSERT INTO `department` VALUES (9, '黔西南分公司');
INSERT INTO `department` VALUES (10, '贵安新区分公司');
INSERT INTO `department` VALUES (11, '企业信息化部');
INSERT INTO `department` VALUES (12, '政企客户事业部');
INSERT INTO `department` VALUES (13, '销售渠道终端事业部');
INSERT INTO `department` VALUES (14, '客户经营中心（电子渠道销售推广中心）');
INSERT INTO `department` VALUES (15, '视频增值运营中心');
INSERT INTO `department` VALUES (16, '网络运行维护事业部');
INSERT INTO `department` VALUES (17, '支付运营分公司');
INSERT INTO `department` VALUES (18, '系统集成（ICT）分公司');
INSERT INTO `department` VALUES (19, '多彩贵州网络传媒股份有限公司');
INSERT INTO `department` VALUES (20, '采购部');
INSERT INTO `department` VALUES (21, '安保行政部');
INSERT INTO `department` VALUES (22, '省办公室');
INSERT INTO `department` VALUES (23, '市场部');
INSERT INTO `department` VALUES (24, '人力资源部');
INSERT INTO `department` VALUES (25, '网络发展部');
INSERT INTO `department` VALUES (26, '客户服务部');
INSERT INTO `department` VALUES (27, '审计部');
INSERT INTO `department` VALUES (28, '党群部');

-- ----------------------------
-- Table structure for event_level
-- ----------------------------
DROP TABLE IF EXISTS `event_level`;
CREATE TABLE `event_level`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `event_level` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '事件等级',
  `content` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '事件描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of event_level
-- ----------------------------
INSERT INTO `event_level` VALUES (1, 'A', '涉及《中国电信集团保密工作管理办法（暂行）》（中国电信〔2002〕552号）和《关于更改企业商业秘密密级标注的通知》（中国电信综合〔2011〕31号）中规定的电信核心商密级信息泄露');
INSERT INTO `event_level` VALUES (2, 'A', '涉及一省以上全省范围内的用户信息泄露，或估计可能超过1000万用户的信息泄露');
INSERT INTO `event_level` VALUES (3, 'A', '充值、缴费、支付、计费等涉及经济利益的系统存在安全漏洞');
INSERT INTO `event_level` VALUES (4, 'A', '发生导致一省以上出口拥塞半小时以上的DDOS攻击事件');
INSERT INTO `event_level` VALUES (5, 'A', '自有网络设备遭攻击、入侵，导致一省以上公共互联网受影响');
INSERT INTO `event_level` VALUES (6, 'A', '自有域名解析系统、AAA系统等因网络安全问题导致一个以上省在全省范围内的用户无法正常上网');
INSERT INTO `event_level` VALUES (7, 'A', '跨省业务平台、网络遭病毒感染并在系统内传播');
INSERT INTO `event_level` VALUES (8, 'A', '出现被新闻媒体曝光的安全事件');
INSERT INTO `event_level` VALUES (9, 'B', '涉及《中国电信集团保密工作管理办法（暂行）》（中国电信〔2002〕552号）和《关于更改企业商业秘密密级标注的通知》（中国电信综合〔2011〕31号）中规定的电信普通商密级信息泄露');
INSERT INTO `event_level` VALUES (10, 'B', '涉及《中国电信集团保密工作管理办法（暂行）》（中国电信〔2002〕552号）和《关于更改企业商业秘密密级标注的通知》（中国电信综合〔2011〕31号）中规定的电信普通商密级信息泄露');
INSERT INTO `event_level` VALUES (11, 'B', '涉及两个及以上地市范围的用户信息泄露，或估计可能超过100万用户的信息泄露');
INSERT INTO `event_level` VALUES (12, 'B', '发生两个及以上地市出口拥塞半小时以上的DDOS攻击事件');
INSERT INTO `event_level` VALUES (13, 'B', '自有网络设备遭攻击、入侵，导致两个及以上地市公共互联网受影响');
INSERT INTO `event_level` VALUES (14, 'B', '除A级事件外，电信自有网站（含合作网站）发生因网站漏洞导致的网页挂马、域名劫持、缓存投毒等安全事件');
INSERT INTO `event_level` VALUES (15, 'B', '出现某安全漏洞或病毒，经确认影响超过10万台自有IT类设备，且已公开披露该漏洞利用方法、已出现自动化利用工具、或已出现自传播性质的蠕虫病毒');
INSERT INTO `event_level` VALUES (16, 'B', '出现某安全漏洞或病毒，经评估预计影响超过100万台资产归属于我公司的用户端设备（包括不局限于IPTV机顶盒等），且已公开披露该漏洞利用方法、已出现自动化利用工具、或已出现自传播性质的蠕虫病毒');
INSERT INTO `event_level` VALUES (17, 'B', '因自有域名解析系统、AAA系统等因网络安全问题导致两个及以上地市在全市范围内的用户无法正常上网');
INSERT INTO `event_level` VALUES (18, 'B', '省内业务平台、网络遭病毒感染并在系统内传播');
INSERT INTO `event_level` VALUES (19, 'C', '涉及单个地市范围的用户信息泄露，或估计可能超过10万用户的信息泄露');
INSERT INTO `event_level` VALUES (20, 'C', '因自有域名解析系统、AAA系统等因网络安全问题导致一个及以上地市在全市范围内的用户无法正常上网');
INSERT INTO `event_level` VALUES (21, 'C', '发生导致一个地市出口拥塞半小时以上的DDOS攻击事件');
INSERT INTO `event_level` VALUES (22, 'C', '自有网络设备遭攻击、入侵，导致一个地市公共互联网受影响');
INSERT INTO `event_level` VALUES (23, 'C', '出现某安全漏洞或病毒，经确认影响超过1万台自有IT类设备');
INSERT INTO `event_level` VALUES (24, 'C', '出现某安全漏洞或病毒，经评估预计影响超过100万台资产归属于我公司的用户端设备（包括不局限于IPTV机顶盒等）');
INSERT INTO `event_level` VALUES (25, 'C', '地市级业务平台、网络遭病毒感染并在系统内传播');
INSERT INTO `event_level` VALUES (26, 'D', '未达到A、B、C级的其他网络安全突发事件');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) DEFAULT NULL COMMENT '父id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `tag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单标识',
  `type` tinyint(1) DEFAULT NULL COMMENT '菜单类型 1、菜单 2、按钮',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 0, '用户管理', 'user', 1);
INSERT INTO `menu` VALUES (2, 1, '创建普通管理员', 'user:add:admin:general', 2);
INSERT INTO `menu` VALUES (3, 1, '创建审核员', 'user:add:sh', 2);
INSERT INTO `menu` VALUES (4, 1, '创建普通用户', 'user:add:normal', 2);
INSERT INTO `menu` VALUES (5, 1, '删除', 'user:delete', 2);
INSERT INTO `menu` VALUES (7, 0, '漏洞管理', 'vul', 1);
INSERT INTO `menu` VALUES (8, 7, '提交漏洞', 'vul:submit', 2);
INSERT INTO `menu` VALUES (10, 7, '查看详情', 'vul:view', 2);
INSERT INTO `menu` VALUES (11, 7, '导出', 'vul:export', 2);
INSERT INTO `menu` VALUES (12, 7, '审核', 'vul:sh', 2);
INSERT INTO `menu` VALUES (13, 1, '编辑', 'user:edit', 2);
INSERT INTO `menu` VALUES (14, 1, '重置密码', 'user:reset:password', 2);
INSERT INTO `menu` VALUES (15, 0, '个人积分', 'self:score', 2);
INSERT INTO `menu` VALUES (16, 7, '重新提交', 'vul:resubmit', 2);
INSERT INTO `menu` VALUES (17, 0, '首页', 'shouye', 2);
INSERT INTO `menu` VALUES (18, 0, '任务管理', 'task', 1);
INSERT INTO `menu` VALUES (19, 18, '创建任务', 'task:create', 2);
INSERT INTO `menu` VALUES (20, 18, '查看任务', 'task:view', 2);
INSERT INTO `menu` VALUES (21, 18, '删除任务', 'task:delete', 2);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `tag` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色标识',
  `description` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', 'role:superadmin', '全部权限');
INSERT INTO `role` VALUES (2, '普通管理员', 'role:admin', '全部权限用户，由超级管理员创建');
INSERT INTO `role` VALUES (3, '审核员', 'role:sh', NULL);
INSERT INTO `role` VALUES (4, '普通用户', 'role:normal', '');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色菜单关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1);
INSERT INTO `role_menu` VALUES (1, 2);
INSERT INTO `role_menu` VALUES (1, 3);
INSERT INTO `role_menu` VALUES (1, 4);
INSERT INTO `role_menu` VALUES (1, 5);
INSERT INTO `role_menu` VALUES (1, 7);
INSERT INTO `role_menu` VALUES (1, 8);
INSERT INTO `role_menu` VALUES (1, 10);
INSERT INTO `role_menu` VALUES (1, 11);
INSERT INTO `role_menu` VALUES (1, 12);
INSERT INTO `role_menu` VALUES (1, 13);
INSERT INTO `role_menu` VALUES (1, 14);
INSERT INTO `role_menu` VALUES (1, 15);
INSERT INTO `role_menu` VALUES (1, 16);
INSERT INTO `role_menu` VALUES (1, 17);
INSERT INTO `role_menu` VALUES (1, 18);
INSERT INTO `role_menu` VALUES (1, 19);
INSERT INTO `role_menu` VALUES (1, 20);
INSERT INTO `role_menu` VALUES (1, 21);
INSERT INTO `role_menu` VALUES (2, 1);
INSERT INTO `role_menu` VALUES (2, 2);
INSERT INTO `role_menu` VALUES (2, 3);
INSERT INTO `role_menu` VALUES (2, 4);
INSERT INTO `role_menu` VALUES (2, 5);
INSERT INTO `role_menu` VALUES (2, 7);
INSERT INTO `role_menu` VALUES (2, 8);
INSERT INTO `role_menu` VALUES (2, 10);
INSERT INTO `role_menu` VALUES (2, 11);
INSERT INTO `role_menu` VALUES (2, 12);
INSERT INTO `role_menu` VALUES (2, 13);
INSERT INTO `role_menu` VALUES (2, 14);
INSERT INTO `role_menu` VALUES (2, 15);
INSERT INTO `role_menu` VALUES (2, 16);
INSERT INTO `role_menu` VALUES (2, 17);
INSERT INTO `role_menu` VALUES (2, 18);
INSERT INTO `role_menu` VALUES (2, 19);
INSERT INTO `role_menu` VALUES (2, 20);
INSERT INTO `role_menu` VALUES (2, 21);
INSERT INTO `role_menu` VALUES (3, 7);
INSERT INTO `role_menu` VALUES (3, 10);
INSERT INTO `role_menu` VALUES (3, 12);
INSERT INTO `role_menu` VALUES (3, 18);
INSERT INTO `role_menu` VALUES (3, 20);
INSERT INTO `role_menu` VALUES (4, 7);
INSERT INTO `role_menu` VALUES (4, 8);
INSERT INTO `role_menu` VALUES (4, 10);
INSERT INTO `role_menu` VALUES (4, 15);
INSERT INTO `role_menu` VALUES (4, 16);
INSERT INTO `role_menu` VALUES (4, 18);
INSERT INTO `role_menu` VALUES (4, 20);

-- ----------------------------
-- Table structure for task_info
-- ----------------------------
DROP TABLE IF EXISTS `task_info`;
CREATE TABLE `task_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务名称',
  `task_type` int(11) DEFAULT NULL COMMENT '1.排雷2.扫雷',
  `task_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务编号',
  `start_time` bigint(20) NOT NULL COMMENT '开始时间',
  `end_time` bigint(20) NOT NULL COMMENT '结束时间',
  `task_status` tinyint(4) DEFAULT NULL COMMENT '1.进行中2.已关闭',
  `create_user` bigint(20) NOT NULL,
  `modify_user` bigint(20) DEFAULT NULL,
  `gmt_create` bigint(20) NOT NULL,
  `gmt_modify` bigint(20) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task_info
-- ----------------------------
INSERT INTO `task_info` VALUES (1, '1', NULL, '1581237905192-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581237905192, 1581648759709, 0);
INSERT INTO `task_info` VALUES (2, '1', NULL, '1581575462826-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581575462826, 1581648759709, 0);
INSERT INTO `task_info` VALUES (4, '1', NULL, '1581575509233-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581575509233, 1581648759709, 0);
INSERT INTO `task_info` VALUES (5, '1', NULL, '1581575587963-PL', 1581240875090, 1581500076122, NULL, 0, 0, 1581575587963, 1581648759709, 0);
INSERT INTO `task_info` VALUES (6, '1', NULL, '1581575943102-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581575943102, 1581648759709, 0);
INSERT INTO `task_info` VALUES (7, '1', NULL, '1581575951277-PL', 1581240875090, 1581500076122, NULL, 0, 0, 1581575951277, 1581648759709, 0);
INSERT INTO `task_info` VALUES (8, '1', NULL, '1581575994246-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581575994246, 1581648759709, 0);
INSERT INTO `task_info` VALUES (9, '1', NULL, '1581576012112-PL', 1581240875090, 1581500076122, NULL, 0, 0, 1581576012112, 1581648759709, 0);
INSERT INTO `task_info` VALUES (10, '1', NULL, '1581578739084-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581578739084, 1581648759709, 0);
INSERT INTO `task_info` VALUES (11, '1', NULL, '1581578745618-SL', 1580549675090, 1580981676122, NULL, 0, 0, 1581578745618, 1581649983035, 0);
INSERT INTO `task_info` VALUES (12, '1', NULL, '1581578761147-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581578761147, 1581649985950, 0);
INSERT INTO `task_info` VALUES (13, '1', NULL, '1581578767303-PL', 1580486400000, 1581782399999, NULL, 0, 678927470698692608, 1581578767303, 1581931937804, 1);
INSERT INTO `task_info` VALUES (14, '1', NULL, '1581578932709-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581578932709, 1581648759709, 0);
INSERT INTO `task_info` VALUES (15, '1', NULL, '1581578941759-PL', 1581240875090, 1581500076122, NULL, 0, 0, 1581578941759, 1581648759709, 0);
INSERT INTO `task_info` VALUES (16, '1', NULL, '1581578950973-SL', 1581240875090, 1581586476122, NULL, 0, 0, 1581578950973, 1581653507133, 0);
INSERT INTO `task_info` VALUES (17, '1', NULL, '1581578961785-SL', 1580549675090, 1581500076122, NULL, 0, 0, 1581578961785, 1581653515890, 0);
INSERT INTO `task_info` VALUES (18, '1', NULL, '1581581561181-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581581561181, 1581648759709, 0);
INSERT INTO `task_info` VALUES (19, '1', NULL, '1581586403169-SL', 1581240875090, 1581672876122, NULL, 0, 0, 1581586403169, 1581663680988, 1);
INSERT INTO `task_info` VALUES (20, '1', NULL, '1581586423783-SL', 1581240875090, 1581586476122, NULL, 0, 0, 1581586423783, 1581664032568, 0);
INSERT INTO `task_info` VALUES (21, '1', NULL, '1581586439363-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581586439363, 1581649506008, 0);
INSERT INTO `task_info` VALUES (22, '1', NULL, '1581586459630-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581586459630, 1581664040902, 0);
INSERT INTO `task_info` VALUES (23, '1', NULL, '1581586471661-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581586471661, 1581649503072, 0);
INSERT INTO `task_info` VALUES (24, '1', NULL, '1581586478798-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581586478798, 1581648759709, 0);
INSERT INTO `task_info` VALUES (25, '1', NULL, '1581586505715-PL', 1581240875090, 1581500076122, NULL, 0, 0, 1581586505715, 1581648759709, 0);
INSERT INTO `task_info` VALUES (26, '1', NULL, '1581586629830-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581586629830, 1581648759709, 0);
INSERT INTO `task_info` VALUES (27, '1', NULL, '1581586664670-PL', 1581240875090, 1581500076122, NULL, 0, 0, 1581586664670, 1581648759709, 0);
INSERT INTO `task_info` VALUES (28, '1', NULL, '1581586687556-PL', 1581240875090, 1581500076122, NULL, 0, 0, 1581586687556, 1581648759709, 0);
INSERT INTO `task_info` VALUES (29, '1', NULL, '1581586723348-PL', 1581240875090, 1581500076122, NULL, 0, 0, 1581586723348, 1581648759709, 0);
INSERT INTO `task_info` VALUES (30, '1', NULL, '1581587133163-PL', 1581240875090, 1581500076122, NULL, 0, 0, 1581587133164, 1581648759709, 0);
INSERT INTO `task_info` VALUES (31, '1', NULL, '1581587273827-SL', 1581240875090, 1581500076122, NULL, 0, 0, 1581587273827, 1581648759709, 0);
INSERT INTO `task_info` VALUES (32, '1', NULL, '1581647327247-PL', 1581240875090, 1581500076122, NULL, 0, 0, 1581647327248, 1581648759709, 0);
INSERT INTO `task_info` VALUES (33, '1', NULL, '1581648507457-SL', 1581240875090, 1581845676122, NULL, 0, 0, 1581648507457, 1581663755389, 1);
INSERT INTO `task_info` VALUES (34, '测试1', 1, '1581664105938-SL', 1581577700398, 1581664103822, NULL, 0, NULL, 1581664105938, NULL, 1);
INSERT INTO `task_info` VALUES (35, '测试2', NULL, '1581664156740-PL', 1581491351421, 1581577753230, NULL, 0, 0, 1581664156740, 1581665656125, 1);
INSERT INTO `task_info` VALUES (36, '测试3', NULL, '1581664641992-PL', 1582355837799, 1582442239533, NULL, 0, 0, 1581664641992, 1581665516482, 1);
INSERT INTO `task_info` VALUES (37, '1', NULL, '1581665620772-PL', 1582184002886, 1582875205382, NULL, 0, 678927470698692608, 1581665620772, 1581931850518, 1);
INSERT INTO `task_info` VALUES (38, '333', NULL, '1581931228448-PL', 1581931217478, 1581931219054, NULL, 679013847146692608, 678927470698692608, 1581931228448, 1581931852448, 1);
INSERT INTO `task_info` VALUES (39, '666', 1, '1581931370159-SL', 1581868800000, 1581955199999, NULL, 679013847146692608, NULL, 1581931370159, NULL, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `business_id` bigint(20) NOT NULL COMMENT '业务编号',
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(600) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `department` int(11) NOT NULL COMMENT '所属单位部门',
  `idcard` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态 1、可用 2、锁定 3、禁用',
  `locked_time` bigint(20) DEFAULT NULL COMMENT '账号锁定时间',
  `error_count` int(11) DEFAULT NULL COMMENT '密码已输错次数',
  `last_login_time` bigint(20) DEFAULT NULL COMMENT '最后登录时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建用户',
  `gmt_create` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `modified_user` int(11) DEFAULT NULL COMMENT '修改用户',
  `gmt_modified` bigint(20) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 674713460738621440, 'admin', 'qBWzqgUZxbZ4bCLwsQA2Sw==', '刘三', 1, '510823199107147030', '18789092987', 1, NULL, 0, 1581931046915, 0, 1580905824610, NULL, NULL);
INSERT INTO `user` VALUES (2, 677581395559710720, 'admin2', 'Sy93OjPDF5vwNrkTfL9AyA==', '111', 5, NULL, '15800882246', 1, NULL, 0, 1581589606986, 1111, 1581589593555, NULL, NULL);
INSERT INTO `user` VALUES (3, 677623148866174976, 'admin3', 'Sy93OjPDF5vwNrkTfL9AyA==', '张三', 7, NULL, NULL, 1, NULL, 0, 1581655928183, 1111, 1581599548319, NULL, NULL);
INSERT INTO `user` VALUES (4, 677823457165049856, 'lj2312763', 'Sy93OjPDF5vwNrkTfL9AyA==', NULL, 1, '652901198703284033', '17360096217', 1, NULL, 0, 1581935366684, 1111, 1581647305539, NULL, NULL);
INSERT INTO `user` VALUES (5, 677869054702125056, 'normal', 'Sy93OjPDF5vwNrkTfL9AyA==', NULL, 5, NULL, '15800882246', 1, NULL, 0, 1581658203973, 1111, 1581658176839, NULL, NULL);
INSERT INTO `user` VALUES (6, 677870377233285120, 'normalUser', 'Sy93OjPDF5vwNrkTfL9AyA==', '张三', 5, NULL, '18010621052', 1, NULL, 0, 1581918885206, 1111, 1581658492155, NULL, NULL);
INSERT INTO `user` VALUES (7, 677870544044949504, 'normalUser2', 'Sy93OjPDF5vwNrkTfL9AyA==', '张三', 4, NULL, NULL, 1, NULL, NULL, NULL, 1111, 1581658531926, NULL, NULL);
INSERT INTO `user` VALUES (8, 677902600011513856, 'normalAdmin', 'Sy93OjPDF5vwNrkTfL9AyA==', 'liusan', 1, '2222222', '', 1, NULL, NULL, NULL, 1111, 1581666174664, NULL, NULL);
INSERT INTO `user` VALUES (9, 677940817368711168, 'baiyike', 'hmf/J+9sr235FF40vocwrg==', NULL, 1, NULL, NULL, 1, NULL, 0, 1581935343878, 1111, 1581675286392, NULL, NULL);
INSERT INTO `user` VALUES (10, 677949304924536832, 'jcqy', 'Sy93OjPDF5vwNrkTfL9AyA==', NULL, 6, '513902199402262345', NULL, 1, NULL, 0, 1581677323314, NULL, 1581677309983, NULL, NULL);
INSERT INTO `user` VALUES (11, 677951315669680128, 'normalAdminjcqy', 'Sy93OjPDF5vwNrkTfL9AyA==', '张三', 5, NULL, NULL, 1, NULL, 0, 1581931579393, 1111, 1581677789382, NULL, NULL);
INSERT INTO `user` VALUES (12, 678914128978378752, 'lvliang', 'qBWzqgUZxbZ4bCLwsQA2Sw==', '吕梁', 1, '510123199306233714', '13551185326', 1, NULL, 0, 1581907383569, 1111, 1581907341963, NULL, NULL);
INSERT INTO `user` VALUES (13, 678916900561879040, 'auditorjcqy', 'Sy93OjPDF5vwNrkTfL9AyA==', NULL, 4, NULL, NULL, 1, NULL, 0, 1581908026473, 1111, 1581908002760, NULL, NULL);
INSERT INTO `user` VALUES (14, 678920707152805888, 'liyongjiang', 'C446k7kuYFG4zVfuPFe75w==', NULL, 6, NULL, NULL, 1, NULL, 0, 1581937383565, NULL, 1581908910322, NULL, NULL);
INSERT INTO `user` VALUES (15, 678927166217388032, 'adminZYH', 'Sy93OjPDF5vwNrkTfL9AyA==', NULL, 4, NULL, NULL, 1, NULL, 0, 1581933811493, 1111, 1581910450283, NULL, NULL);
INSERT INTO `user` VALUES (16, 678927470698692608, 'shy', 'qBWzqgUZxbZ4bCLwsQA2Sw==', '审核员', 1, '510123199306233741', '13551185326', 1, NULL, 0, 1581932737994, 1111, 1581910522877, NULL, NULL);
INSERT INTO `user` VALUES (17, 678929798956843008, 'apple', 'C446k7kuYFG4zVfuPFe75w==', NULL, 22, '', NULL, 1, NULL, 0, 1581933265545, NULL, 1581911077977, NULL, NULL);
INSERT INTO `user` VALUES (18, 678971557057396736, 'baiyi', 'hmf/J+9sr235FF40vocwrg==', NULL, 1, NULL, NULL, 1, NULL, 0, 1581922339584, 1111, 1581921033884, NULL, NULL);
INSERT INTO `user` VALUES (19, 678978486903242752, 'hejianbo', '1ygfWGZIUskiL+HddlqdJw==', NULL, 1, NULL, NULL, 1, NULL, 0, 1581930726900, NULL, 1581922686088, NULL, NULL);
INSERT INTO `user` VALUES (20, 679000352778878976, 'lxq', 'C446k7kuYFG4zVfuPFe75w==', 'lxq', 1, '510322199300214', NULL, 1, NULL, 0, 1581935477407, 1111, 1581927899319, NULL, NULL);
INSERT INTO `user` VALUES (21, 679013847146692608, 'liyongjiang2', 'C446k7kuYFG4zVfuPFe75w==', NULL, 7, NULL, NULL, 1, NULL, 0, 1581932729092, 1111, 1581931116627, NULL, NULL);
INSERT INTO `user` VALUES (22, 679018398482432000, 'liyongjiang3', 'C446k7kuYFG4zVfuPFe75w==', NULL, 6, NULL, NULL, 1, NULL, 0, 1581932254939, 1111, 1581932201750, NULL, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (674713460738621440, 1);
INSERT INTO `user_role` VALUES (677581395559710720, 4);
INSERT INTO `user_role` VALUES (677623148866174976, 4);
INSERT INTO `user_role` VALUES (677823457165049856, 4);
INSERT INTO `user_role` VALUES (677869054702125056, 4);
INSERT INTO `user_role` VALUES (677870377233285120, 4);
INSERT INTO `user_role` VALUES (677870544044949504, 4);
INSERT INTO `user_role` VALUES (677902600011513856, 2);
INSERT INTO `user_role` VALUES (677940817368711168, 2);
INSERT INTO `user_role` VALUES (677949304924536832, 4);
INSERT INTO `user_role` VALUES (677951315669680128, 2);
INSERT INTO `user_role` VALUES (678914128978378752, 4);
INSERT INTO `user_role` VALUES (678916900561879040, 3);
INSERT INTO `user_role` VALUES (678920707152805888, 4);
INSERT INTO `user_role` VALUES (678927166217388032, 2);
INSERT INTO `user_role` VALUES (678927470698692608, 3);
INSERT INTO `user_role` VALUES (678929798956843008, 4);
INSERT INTO `user_role` VALUES (678971557057396736, 4);
INSERT INTO `user_role` VALUES (678978486903242752, 4);
INSERT INTO `user_role` VALUES (679000352778878976, 3);
INSERT INTO `user_role` VALUES (679013847146692608, 2);
INSERT INTO `user_role` VALUES (679018398482432000, 3);

-- ----------------------------
-- Table structure for vul_examine_info
-- ----------------------------
DROP TABLE IF EXISTS `vul_examine_info`;
CREATE TABLE `vul_examine_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `vul_id` int(11) NOT NULL COMMENT '漏洞id',
  `examiner` bigint(20) NOT NULL COMMENT '审批人',
  `result` int(11) NOT NULL COMMENT '2通过3未通过',
  `reason` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '审批理由',
  `examine_material_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '审批材料名',
  `examine_material_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '审批材料url',
  `examine_date` bigint(20) DEFAULT NULL COMMENT '审批日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vul_examine_info
-- ----------------------------
INSERT INTO `vul_examine_info` VALUES (1, 4, 674713460738621440, 2, '很好', 'gzdx.sql', 'd://file//ec08767f-2f1d-498b-96c2-14a4fc142f2a//gzdx.sql', 1581386177324);
INSERT INTO `vul_examine_info` VALUES (2, 4, 674713460738621440, 2, '很好', 'gzdx.sql', 'd://file//ec08767f-2f1d-498b-96c2-14a4fc142f2a//gzdx.sql', 1581386248453);
INSERT INTO `vul_examine_info` VALUES (3, 4, 674713460738621440, 2, '很好', 'gzdx.sql', 'd://file//ec08767f-2f1d-498b-96c2-14a4fc142f2a//gzdx.sql', 1581386248472);
INSERT INTO `vul_examine_info` VALUES (4, 4, 674713460738621440, 2, '很好', 'gzdx.sql', 'd://file//ec08767f-2f1d-498b-96c2-14a4fc142f2a//gzdx.sql', 1581386319440);
INSERT INTO `vul_examine_info` VALUES (5, 4, 674713460738621440, 2, '很好', 'gzdx.sql', 'd://file//ec08767f-2f1d-498b-96c2-14a4fc142f2a//gzdx.sql', 1581386395724);
INSERT INTO `vul_examine_info` VALUES (6, 4, 674713460738621440, 2, '很好', 'gzdx.sql', 'd://file//ec08767f-2f1d-498b-96c2-14a4fc142f2a//gzdx.sql', 1581386408387);
INSERT INTO `vul_examine_info` VALUES (7, 4, 674713460738621440, 2, '很好', 'gzdx.sql', 'd://file//ec08767f-2f1d-498b-96c2-14a4fc142f2a//gzdx.sql', 1581386497924);
INSERT INTO `vul_examine_info` VALUES (8, 4, 674713460738621440, 2, '很好', 'gzdx.sql', 'd://file//ec08767f-2f1d-498b-96c2-14a4fc142f2a//gzdx.sql', 1581386556437);
INSERT INTO `vul_examine_info` VALUES (9, 4, 674713460738621440, 2, '很好', 'gzdx.sql', 'd://file//ec08767f-2f1d-498b-96c2-14a4fc142f2a//gzdx.sql', 1581387247709);
INSERT INTO `vul_examine_info` VALUES (10, 11, 677951315669680128, 3, '1', '1', '1', 1581906100658);
INSERT INTO `vul_examine_info` VALUES (11, 11, 677951315669680128, 3, '1', '1', '1', 1581906171286);
INSERT INTO `vul_examine_info` VALUES (12, 11, 677951315669680128, 3, '1', '1', '1', 1581906264304);
INSERT INTO `vul_examine_info` VALUES (13, 11, 677951315669680128, 3, '1', '1', '1', 1581906339344);
INSERT INTO `vul_examine_info` VALUES (14, 11, 677951315669680128, 3, '1', '1', '1', 1581906378798);
INSERT INTO `vul_examine_info` VALUES (15, 11, 677951315669680128, 3, '1', '1', '1', 1581906430669);

-- ----------------------------
-- Table structure for vul_info
-- ----------------------------
DROP TABLE IF EXISTS `vul_info`;
CREATE TABLE `vul_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `vul_no` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '漏洞编号',
  `vul_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '漏洞名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '1.扫雷,2.排雷',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ip',
  `vul_port` int(11) NOT NULL COMMENT '漏洞端口',
  `vul_address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '漏洞地址',
  `vul_department` int(20) DEFAULT NULL COMMENT '提交人所属部门',
  `address_owner` int(11) NOT NULL COMMENT '漏洞归属部门',
  `vul_type` tinyint(20) NOT NULL COMMENT '1.Web应用漏洞2.主机系统漏洞3.移动APP漏洞4.弱口令类漏洞',
  `vul_level` tinyint(4) NOT NULL COMMENT '1高危漏洞，2中危漏洞3.低危漏洞',
  `event_level` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'A,B,C,D拼接',
  `event_level_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '事件等级详细',
  `vul_desc` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '漏洞描述',
  `repair_suggest` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修复建议',
  `vul_material_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '漏洞材料名称',
  `vul_material_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '漏洞材料url',
  `vul_status` tinyint(4) DEFAULT NULL COMMENT '1待审核2通过3未通过',
  `task_id` int(11) NOT NULL COMMENT '任务id',
  `system_type` tinyint(4) DEFAULT NULL COMMENT '1.普通系统2.重要或设计用户敏感信息系统',
  `create_user` bigint(20) DEFAULT NULL,
  `modify_user` bigint(20) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modify` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT 1 COMMENT '0删除1正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vul_info
-- ----------------------------
INSERT INTO `vul_info` VALUES (4, '2020WEB4', '扫雷漏洞001', 1, '192.168.17.25', 8282, 'http://192.168.12.35/kaka', 1, 1, 2, 1, 'A', '1', '大漏洞', '这是一个大漏洞', 'APP消息接口文档.docx', 'd://file//5fc790ee-44da-4357-bd64-a8bf803d982f//APP消息接口文档.docx', 3, 1, 1, 674713460738621440, 677951315669680128, 1581324312506, 1581906440399, 1);
INSERT INTO `vul_info` VALUES (5, '2020WEB5', 'eee', 1, '192.168.1.1', 10, 'www', NULL, 1, 1, 1, 'A,D', '1,26', NULL, NULL, 'APP消息接口文档.docx', 'd://file//4402fb88-bd04-40a4-aa1b-e6de878d222f//APP消息接口文档.docx', 3, 13, 1, 0, 677951315669680128, 1581664984176, 1581906440399, 1);
INSERT INTO `vul_info` VALUES (6, '2020WEB6', '测试', 1, '192.168.1.2', 10, '呜呜呜呜', NULL, 1, 1, 1, 'A,D', '1,26', NULL, NULL, 'APP消息接口文档.docx', 'd://file//bfa700d9-6834-4449-af58-aa5ddb076157//APP消息接口文档.docx', 3, 13, 1, 0, 677951315669680128, 1581665283396, 1581906440399, 1);
INSERT INTO `vul_info` VALUES (7, '2020WEB7', '111', 1, '192.168.1.1', 10, 'www', 1, 1, 1, 1, 'A,D', '1,26', NULL, NULL, NULL, NULL, 3, 13, 1, 677823457165049856, 677951315669680128, 1581665924554, 1581906440399, 1);
INSERT INTO `vul_info` VALUES (8, '2020WEB8', 'www', 1, '192.168.1.1', 10, 'www', 1, 1, 1, 1, 'A,C', '1,25', NULL, NULL, NULL, NULL, 3, 13, 1, 677823457165049856, 677951315669680128, 1581665983920, 1581906440399, 1);
INSERT INTO `vul_info` VALUES (9, '2020WEB9', 'www', 1, '192.168.1.1', 10, '1111', 1, 1, 1, 1, 'A,C', '1,22', NULL, NULL, NULL, NULL, 3, 13, 1, 677823457165049856, 677951315669680128, 1581666142543, 1581906440399, 1);
INSERT INTO `vul_info` VALUES (10, '2020WEB10', 'wwwwwwwww', 1, '192.168.1.1', 55, 'www', 1, 1, 1, 1, '', ',', NULL, NULL, 'APP消息接口文档.docx', 'd://file//6af655db-edca-4386-8439-f0b68f255493//APP消息接口文档.docx', 1, 13, 1, 677823457165049856, 677823457165049856, 1581667356424, 1581930356318, 1);
INSERT INTO `vul_info` VALUES (11, '2020HOSTSYS11', '比特币攻击', 1, '192.168.1.5', 501, '1', 1, 1, 2, 1, 'A,B,C,D', NULL, NULL, NULL, NULL, NULL, 3, 19, 1, 677951315669680128, 677951315669680128, 1581672436785, 1581906440399, 1);
INSERT INTO `vul_info` VALUES (12, '2020HOSTSYS12', '吕梁测试漏洞', 1, '192.168.3.5', 82, 'http', 1, 1, 2, 1, 'A,B,C', '1,2,3', 'big vul', '大漏洞', 'a', 'a', 1, 37, NULL, 678914128978378752, 678914128978378752, 1581907499497, NULL, 1);

-- ----------------------------
-- Table structure for vul_integral_info
-- ----------------------------
DROP TABLE IF EXISTS `vul_integral_info`;
CREATE TABLE `vul_integral_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `task_id` int(11) DEFAULT NULL COMMENT '任务id',
  `intergral_event` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '获得积分事项',
  `vul_id` int(11) NOT NULL COMMENT '漏洞id',
  `vul_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '漏洞名称',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '漏洞IP',
  `vul_port` int(11) NOT NULL COMMENT '漏洞端口',
  `commit_date` bigint(20) NOT NULL COMMENT '提交日期',
  `grade` int(11) NOT NULL COMMENT '获得积分',
  `commit_user` bigint(20) NOT NULL COMMENT '提交人',
  `department` int(11) NOT NULL COMMENT '所属部门',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vul_integral_info
-- ----------------------------
INSERT INTO `vul_integral_info` VALUES (4, 1, '提交漏洞', 4, '扫雷漏洞001', '192.168.17.25', 8282, 1581324312506, 1000, 0, 1);

SET FOREIGN_KEY_CHECKS = 1;
