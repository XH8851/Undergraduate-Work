/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50649
Source Host           : localhost:3306
Source Database       : db_schoolrecru

Target Server Type    : MYSQL
Target Server Version : 50649
File Encoding         : 65001

Date: 2020-12-24 11:18:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_admin`
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(32) NOT NULL,
  `admin_password` varchar(32) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1', 'admin', '123');

-- ----------------------------
-- Table structure for `tb_apply`
-- ----------------------------
DROP TABLE IF EXISTS `tb_apply`;
CREATE TABLE `tb_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Ino` varchar(32) NOT NULL,
  `Snoemployee` varchar(32) NOT NULL,
  `AppStatus` varchar(32) NOT NULL,
  `AppTime` varchar(32) NOT NULL,
  `AppReport` varchar(255) DEFAULT NULL,
  `AppReportFb` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_apply
-- ----------------------------
INSERT INTO `tb_apply` VALUES ('5', '1', '1', '面试成功', '2020-12-23', null, null);
INSERT INTO `tb_apply` VALUES ('6', '1', '1', '投递成功', '2020-12-23', null, null);

-- ----------------------------
-- Table structure for `tb_employee`
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Snoemployee` varchar(32) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `Email` varchar(32) NOT NULL,
  `Tel` varchar(32) NOT NULL,
  `Name` varchar(32) NOT NULL,
  `Gender` varchar(32) NOT NULL,
  `College` varchar(32) NOT NULL,
  `Major` varchar(32) NOT NULL,
  `GPA` varchar(32) DEFAULT NULL,
  `Awards` varchar(255) DEFAULT NULL,
  `Skill` varchar(255) DEFAULT NULL,
  `Experience` varchar(255) DEFAULT NULL,
  `Comments` varchar(255) DEFAULT NULL,
  `Istatus` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_employee
-- ----------------------------
INSERT INTO `tb_employee` VALUES ('1', 'M1', '123', '@2', '1383', '王刚1', '女', '软件4', '计算机5', '6', '7', '8', '9', '0', '是');
INSERT INTO `tb_employee` VALUES ('3', '1', '1', '1', '1', '1', '男', '1', '1', '', '', '', '', '', '是');

-- ----------------------------
-- Table structure for `tb_employer`
-- ----------------------------
DROP TABLE IF EXISTS `tb_employer`;
CREATE TABLE `tb_employer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Snoemployer` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `Email` varchar(32) NOT NULL,
  `Tel` varchar(32) NOT NULL,
  `Name` varchar(32) NOT NULL,
  `Gender` varchar(32) NOT NULL,
  `Jno` varchar(32) NOT NULL,
  `Firm` varchar(32) NOT NULL,
  `Position` varchar(32) NOT NULL,
  `Responsibility` varchar(255) NOT NULL,
  `Industry` varchar(32) NOT NULL,
  `Comments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_employer
-- ----------------------------
INSERT INTO `tb_employer` VALUES ('6', 'N1', '123', '@3', '1382', '1', '女', 'N984', '大连5', '软件6', 'OK8', '计算机7', '好9');
INSERT INTO `tb_employer` VALUES ('8', '12345', '12345', '1', '1', '1', '男', '1', '1', '1', '1', '1', 'test');
INSERT INTO `tb_employer` VALUES ('9', '2', '2', '2', '2', '22', '女', '2', '2', '2', '2', '2', '2');

-- ----------------------------
-- Table structure for `tb_evaluation`
-- ----------------------------
DROP TABLE IF EXISTS `tb_evaluation`;
CREATE TABLE `tb_evaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Ino` varchar(32) NOT NULL,
  `Snoemployee` varchar(32) NOT NULL,
  `InternRate` varchar(32) DEFAULT NULL,
  `EmployeeRate` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_evaluation
-- ----------------------------
INSERT INTO `tb_evaluation` VALUES ('7', '1', '1', '公司牛逼啊快上市了', '工作态度认真\r\n还可以吧\r\n可以哈哈哈');

-- ----------------------------
-- Table structure for `tb_internship`
-- ----------------------------
DROP TABLE IF EXISTS `tb_internship`;
CREATE TABLE `tb_internship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Ino` varchar(32) NOT NULL,
  `Ifirm` varchar(32) NOT NULL,
  `Iindustry` varchar(32) NOT NULL,
  `Idpt` varchar(32) NOT NULL,
  `Ipst` varchar(32) NOT NULL,
  `Ilocation` varchar(32) NOT NULL,
  `Irqmt` varchar(255) NOT NULL,
  `Ihours` int(11) NOT NULL,
  `Ibonus` varchar(32) NOT NULL,
  `PostTime` varchar(32) NOT NULL,
  `Snoemployer` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_internship
-- ----------------------------
INSERT INTO `tb_internship` VALUES ('6', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2020-12-23 :07:53:16', '12345');
