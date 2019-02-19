/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : dev

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 19/02/2019 09:14:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for formtemplate
-- ----------------------------
DROP TABLE IF EXISTS `formtemplate`;
CREATE TABLE `formtemplate`  (
  `templateID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `templateName` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '模板名称',
  `createTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `createUser` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'system' COMMENT '创建人',
  `company` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '创建公司',
  `isDeleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`templateID`) USING BTREE,
  INDEX `idx_createTime`(`createTime`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '模板表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of formtemplate
-- ----------------------------
INSERT INTO `formtemplate` VALUES (1, '暂支单', '2019-02-17 12:29:32', 'system', 'maxwell', 0);
INSERT INTO `formtemplate` VALUES (2, '还款单', '2019-02-17 12:29:41', 'system', 'maxwell', 0);

SET FOREIGN_KEY_CHECKS = 1;
