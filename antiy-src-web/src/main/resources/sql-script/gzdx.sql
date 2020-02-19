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

CREATE  database
IF NOT  EXISTS  `gzdx` DEFAULT  CHARACTER
SET utf8mb4 COLLATE  utf8mb4_unicode_ci;

use gzdx ;
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
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

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
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (1, 1);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (1, 2);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (2, 3);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (2, 4);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (2, 7);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (2, 10);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (2, 11);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (2, 18);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (2, 19);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (2, 20);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (2, 21);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (3, 7);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (3, 10);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (3, 12);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (3, 18);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (3, 20);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (4, 7);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (4, 8);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (4, 10);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (4, 15);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (4, 16);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (4, 18);
INSERT INTO `role_menu`(`role_id`, `menu_id`) VALUES (4, 20);


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
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task_info
-- ----------------------------

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
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 674713460738621440, 'admin', 'qBWzqgUZxbZ4bCLwsQA2Sw==', '刘三', 1, '510823199107147030', '18789092987', 1, NULL, 0, 1581931046915, 0, 1580905824610, NULL, NULL);

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
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vul_examine_info
-- ----------------------------

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
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vul_info
-- ----------------------------
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
) ENGINE = InnoDB  CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vul_integral_info
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
