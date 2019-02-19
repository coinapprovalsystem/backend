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

 Date: 19/02/2019 09:13:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basecontrolconfig
-- ----------------------------
DROP TABLE IF EXISTS `basecontrolconfig`;
CREATE TABLE `basecontrolconfig`  (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `controlType` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '控件类型',
  `labelName` tinyint(1) NULL DEFAULT 1 COMMENT '控件名称',
  `controlID` int(11) NOT NULL COMMENT '控件id',
  `controlValue` tinyint(1) NULL DEFAULT 1 COMMENT '控件值',
  `defaultValue` tinyint(1) NULL DEFAULT 1 COMMENT '控件默认值',
  `props` tinyint(1) NULL DEFAULT 1 COMMENT '其他属性值',
  `options` tinyint(1) NULL DEFAULT 1 COMMENT 'select的options数据源',
  `placeholder` tinyint(1) NULL DEFAULT 1 COMMENT '占位提示文字',
  `readOnly` tinyint(1) NULL DEFAULT 1 COMMENT '只读',
  `required` tinyint(1) NULL DEFAULT 1 COMMENT '必填',
  `createTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`pid`) USING BTREE,
  INDEX `idx_createTime`(`createTime`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '控件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basecontrolconfig
-- ----------------------------
INSERT INTO `basecontrolconfig` VALUES (0, 'input', 1, 0, 1, 1, 1, 1, 1, 1, 1, '2019-02-17 11:42:45');
INSERT INTO `basecontrolconfig` VALUES (1, 'textarea', 1, 1, 1, 1, 1, 1, 1, 1, 1, '2019-02-17 11:43:09');
INSERT INTO `basecontrolconfig` VALUES (2, 'select', 1, 2, 1, 1, 1, 1, 1, 1, 1, '2019-02-17 11:44:24');
INSERT INTO `basecontrolconfig` VALUES (3, 'mulselect', 1, 3, 1, 1, 1, 1, 1, 1, 1, '2019-02-17 11:44:39');
INSERT INTO `basecontrolconfig` VALUES (4, 'datepicker', 1, 4, 1, 1, 1, 1, 1, 1, 1, '2019-02-17 11:45:00');
INSERT INTO `basecontrolconfig` VALUES (5, 'datetimepicker', 1, 5, 1, 1, 1, 1, 1, 1, 1, '2019-02-17 11:45:10');
INSERT INTO `basecontrolconfig` VALUES (6, 'upload', 1, 6, 1, 1, 1, 1, 1, 1, 1, '2019-02-17 11:46:44');

SET FOREIGN_KEY_CHECKS = 1;
