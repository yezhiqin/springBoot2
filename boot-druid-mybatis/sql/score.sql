/*
Navicat MySQL Data Transfer

Source Server         : 192.168.234.129
Source Server Version : 50641
Source Host           : 39.108.68.29:3306
Source Database       : school_score

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2018-10-18 16:01:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` varchar(255) NOT NULL,
  `chinese_score` double NOT NULL,
  `english_score` double NOT NULL,
  `math_score` double NOT NULL,
  `sid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '88', '96', '78', '1');
