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

 Date: 19/02/2019 09:14:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for formcontrolcontent
-- ----------------------------
DROP TABLE IF EXISTS `formcontrolcontent`;
CREATE TABLE `formcontrolcontent`  (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `templateID` int(11) NOT NULL DEFAULT 0 COMMENT '模板id',
  `controlType` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '控件类型',
  `controlID` int(11) NOT NULL DEFAULT 0 COMMENT '控件id',
  `labelName` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '控件名称',
  `controlValue` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '控件值',
  `defaultValue` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '控件默认值',
  `props` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '其他属性值',
  `options` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT 'select的options数据源',
  `placeholder` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '占位提示文字',
  `readOnly` tinyint(1) NULL DEFAULT 0 COMMENT '只读',
  `required` tinyint(1) NULL DEFAULT 1 COMMENT '必填',
  `createTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `createUser` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'system' COMMENT '创建人',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '控件顺序',
  PRIMARY KEY (`pid`) USING BTREE,
  INDEX `idx_createTime`(`createTime`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '模板业务数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of formcontrolcontent
-- ----------------------------
INSERT INTO `formcontrolcontent` VALUES (0, 1, 'input', 0, '事由', '', '', '', '', '请输入事由', 0, 1, '2019-02-17 12:31:37', 'system', 0);
INSERT INTO `formcontrolcontent` VALUES (1, 1, 'input', 1, '金额', '', '', '', '', '请输入金额', 0, 1, '2019-02-17 12:32:09', 'system', 1);
INSERT INTO `formcontrolcontent` VALUES (2, 1, 'datetimepicker', 2, '预计还款时间', '', '', '', '', '请输入还款时间', 0, 1, '2019-02-17 12:32:47', 'system', 2);

SET FOREIGN_KEY_CHECKS = 1;
