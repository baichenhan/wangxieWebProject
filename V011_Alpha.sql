/*
 Navicat Premium Data Transfer

 Source Server         : wangxiesql
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : wangxietest2

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 19/01/2021 13:11:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动名称',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '活动内容',
  `department` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参与部门',
  `start_time` datetime(0) NOT NULL COMMENT '活动开始时间',
  `end_time` datetime(0) NOT NULL COMMENT '活动结束时间',
  `leader_user` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '负责人',
  `participant_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '参与者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for auth
-- ----------------------------
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `url` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限对应url',
  `desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限内容描述',
  `status` tinyint(1) NOT NULL COMMENT '1启用0禁用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of auth
-- ----------------------------
INSERT INTO `auth` VALUES (1, '/user', '成员管理', 1);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `status` tinyint(1) NOT NULL COMMENT '1启用0禁用',
  `recruit` tinyint(1) NOT NULL COMMENT '1招新0不招新',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cate_id` tinyint(4) NOT NULL COMMENT '所属分类id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源路径',
  `upload_time` datetime(0) NOT NULL COMMENT '上传时间',
  `downloads` int(11) NOT NULL DEFAULT 0 COMMENT '下载数',
  `upload_user` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '上传人',
  `role_id` int(2) NOT NULL COMMENT '角色id',
  `status` tinyint(1) NOT NULL COMMENT '1展示0撤销',
  `sorting` tinyint(4) NOT NULL COMMENT '排序',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` int(11) NOT NULL COMMENT '父id 0表示学院',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业/学院名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (1, 0, '信息科学与工程学院');
INSERT INTO `major` VALUES (2, 1, '软件工程');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` int(11) NOT NULL COMMENT '父级主键',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '导航菜单名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '提交人',
  `cate_id` tinyint(4) NOT NULL COMMENT '分类id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  `create_time` datetime(0) NOT NULL COMMENT '上传时间',
  `status` tinyint(1) NOT NULL COMMENT '1展出0撤销',
  `sorting` tinyint(4) NOT NULL COMMENT '排序',
  `delete_time` tinyint(4) NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for onduty
-- ----------------------------
DROP TABLE IF EXISTS `onduty`;
CREATE TABLE `onduty`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mon_time` date NOT NULL COMMENT '值班周周一的日期',
  `week` tinyint(4) NOT NULL COMMENT '学期内第几周',
  `date` tinyint(4) NOT NULL COMMENT '当周内星期几',
  `class` tinyint(4) NOT NULL COMMENT '当天内节数1/2/3/4',
  `arranger` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '安排人',
  `user` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '值班人员',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注记录',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for recruit
-- ----------------------------
DROP TABLE IF EXISTS `recruit`;
CREATE TABLE `recruit`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` tinyint(1) NOT NULL COMMENT '性别',
  `student_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `major_id` tinyint(4) NOT NULL COMMENT '所属专业id',
  `department1` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主意向部门',
  `department2` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '次意向部门',
  `adjust` tinyint(1) NOT NULL COMMENT '1服从调剂0不服从',
  `answer1` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题1答案',
  `answer2` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题2答案',
  `answer3` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题3答案',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for recruit_question
-- ----------------------------
DROP TABLE IF EXISTS `recruit_question`;
CREATE TABLE `recruit_question`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `question` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题内容',
  `status` tinyint(4) NOT NULL COMMENT '1启用0禁用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` tinyint(4) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  `auth_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所拥有权限id，逗号隔开',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '部长', '1');
INSERT INTO `role` VALUES (2, '部员', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role_id` tinyint(4) NOT NULL COMMENT '对应角色id',
  `grade` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年级',
  `sex` tinyint(1) NOT NULL COMMENT '性别',
  `major_id` tinyint(4) NOT NULL COMMENT '专业id',
  `student_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `department` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属部门',
  `status` tinyint(1) NOT NULL COMMENT '1启用0禁用',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `ban_deadline` datetime(0) NOT NULL COMMENT '封禁时间',
  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'bch', 'mryshididi', 2, '2016', 1, 2, '160120010073', '运维部', 1, '白晨晗', '2021-01-17 22:13:24', NULL);
INSERT INTO `user` VALUES (2, 'xly', 'mryshididi', 1, '2017', 1, 2, '160120010073', '运维部', 1, '萧亮羽', '2021-01-17 22:13:24', NULL);
INSERT INTO `user` VALUES (3, 'mry', 'mryshididi', 2, '2020', 0, 2, '160120010073', '运维部', 1, '马睿遥', '2021-01-17 22:13:24', NULL);
INSERT INTO `user` VALUES (4, 'sjx', 'mryshididi', 1, '2018', 1, 2, '160120010073', '运维部', 1, '邵静轩', '2021-01-17 22:13:24', NULL);
INSERT INTO `user` VALUES (5, 'wh', 'mryshididi', 2, '2020', 1, 2, '160120010073', '运维部', 1, '王晗', '2021-01-17 22:13:24', NULL);

SET FOREIGN_KEY_CHECKS = 1;
