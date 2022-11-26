/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : crud

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 26/11/2022 14:19:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '2f083ecc483a84083439b1a998b22256', '123123@qq.com', '00000000000', '2022-10-18 19:10:08', '2022-10-18 19:10:08');
INSERT INTO `admin` VALUES (2, 'admin123456', '2f083ecc483a84083439b1a998b22256', '8124814814@qq.com', '13311111111', '2022-10-18 19:37:32', '2022-10-18 20:21:16');
INSERT INTO `admin` VALUES (3, 'admin666', '25a6856525aa134bf990451616e916d7', 'q344@qq.com', '13111111111', '2022-10-20 11:16:26', '2022-10-20 11:16:26');
INSERT INTO `admin` VALUES (4, 'admin66', '2f083ecc483a84083439b1a998b22256', NULL, '13113111111', '2022-10-20 11:51:10', '2022-10-20 11:51:09');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (2, '顺丰小哥', 'aeggae', 19, '男', '10012348888', '江西省南昌市昌东镇', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (3, 'adgga', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (4, 'sdvsvb', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (5, 'sbsb', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (6, 'bsbs', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (7, 'rhsrhrh', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (8, 'sr', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (9, 'sb', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (10, 'sdb', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (11, 'sdfbdfb', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (12, 'fndfndfn', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (13, 'ndfdfn', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (14, 'nndfdfndfn', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (15, 'ndfdfn', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (16, 'dfn', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (17, 'dfnndf', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (18, 'ndfdfn', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (19, 'dfnn', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (20, 'dfndnf', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (21, 'admin', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (22, 'admin', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (23, 'admin', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (24, 'admin', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (25, 'admin', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (26, 'admin', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (27, 'admin', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (28, 'admin', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (29, 'admin', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (30, 'admin', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (31, 'admin', 'root', 19, '男', '10012348888', '江西南昌', '2022-09-30 18:14:06', '2022-09-30 18:14:06');
INSERT INTO `user` VALUES (37, '测试000', '205936970', 12, '男', '12332111111', '阿达的', '2022-10-01 15:53:27', '2022-10-01 15:53:27');
INSERT INTO `user` VALUES (39, '按照', '2116523034', 15, '男', '12345671234', '那里', '2022-10-01 16:17:06', '2022-10-01 16:17:06');
INSERT INTO `user` VALUES (40, '123123', '623391412', 12, '男', '131313', '131331', '2022-10-18 14:47:29', '2022-10-18 14:47:28');
INSERT INTO `user` VALUES (41, '123123', '821580842', 1231, '男', '123', '123', '2022-10-18 14:48:03', '2022-10-18 14:48:03');

SET FOREIGN_KEY_CHECKS = 1;
