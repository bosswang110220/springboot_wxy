/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : bigdata

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-07-03 16:48:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `uuid` varchar(255) DEFAULT NULL COMMENT '唯一标识 -- uuid -- VARCHAR(255) -- ',
  `seller_uuid` varchar(255) DEFAULT NULL COMMENT '商家uuid',
  `name` varchar(64) NOT NULL COMMENT '类目名称',
  `code` int(11) NOT NULL COMMENT '类目代码',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类目表';

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for `food`
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `uuid` varchar(255) DEFAULT NULL COMMENT '唯一标识 -- uuid -- VARCHAR(255) -- ',
  `seller_uuid` varchar(255) DEFAULT NULL COMMENT '商家uuid',
  `category_uuid` varchar(255) DEFAULT NULL COMMENT '所属类目uuid',
  `name` varchar(64) NOT NULL COMMENT '商品名称',
  `price` decimal(10,2) NOT NULL COMMENT '商品单价',
  `specialPrice` decimal(10,2) NOT NULL COMMENT '商品特价（优惠价）',
  `stock` int(11) NOT NULL COMMENT '库存',
  `desc` varchar(64) DEFAULT NULL COMMENT '描述',
  `icon` varchar(512) DEFAULT NULL COMMENT '产品图标',
  `categoryCode` int(11) NOT NULL COMMENT '类目代码',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of food
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `uuid` varchar(255) DEFAULT NULL COMMENT '唯一标识 -- uuid -- VARCHAR(255) -- ',
  `seller_uuid` varchar(255) DEFAULT NULL COMMENT '商家uuid',
  `account_uuid` varchar(255) DEFAULT NULL COMMENT '用户uuid',
  `food_uuid` varchar(255) DEFAULT NULL COMMENT '用户uuid',
  `amount` decimal(10,2) NOT NULL COMMENT '订单总金额',
  `orderStatus` tinyint(3) NOT NULL DEFAULT '0' COMMENT '订单状态，默认为已下单',
  `payStatus` tinyint(3) NOT NULL DEFAULT '0' COMMENT '支付状态, 默认未支付',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '商家ID',
  `uuid` varchar(255) DEFAULT NULL COMMENT '唯一标识 ',
  `name` varchar(32) NOT NULL,
  `remark` varchar(32) NOT NULL,
  `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '运营状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='卖家信息表';

-- ----------------------------
-- Records of shop
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `uuid` varchar(255) DEFAULT NULL COMMENT '唯一标识 ',
  `seller_uuid` varchar(255) DEFAULT NULL COMMENT '商家uuid',
  `phone` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `address` varchar(128) NOT NULL COMMENT '买家地址',
  `email` varchar(32) NOT NULL,
  `opend_id` varchar(64) NOT NULL COMMENT '微信openid',
  `reg_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `login_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户(买家)信息表';

-- ----------------------------
-- Records of user
-- ----------------------------
