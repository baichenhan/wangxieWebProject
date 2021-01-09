/*
 Navicat Premium Data Transfer

 Source Server         : wangxiesql
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : wangxietest1

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 10/01/2021 02:07:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `grade` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `identity` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('xiaoliangyu', 'maruiyaoshigedidi', '研一', '白晨晗', 'male', 'technical support');
INSERT INTO `user` VALUES ('gaosheng', 'gs123', '大四', '高升', 'male', '野人');

SET FOREIGN_KEY_CHECKS = 1;
