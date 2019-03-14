/*
Navicat MySQL Data Transfer

Source Server         : 192.168.234.129
Source Server Version : 50641
Source Host           : 39.108.68.29:3306
Source Database       : school_score

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2018-10-18 16:01:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_fe0i52si7ybu0wjedj6motiim` (`email`),
  UNIQUE KEY `UK_7pb8owoegbhhcrpopw4o1ykcr` (`name`),
  UNIQUE KEY `UK_eag8dtw4cchwjjpyb8a90ahs6` (`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '北京市海淀区', '18', 'zhangsan@163.com', '张三');
