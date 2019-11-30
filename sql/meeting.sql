# Host: localhost  (Version: 5.7.26)
# Date: 2019-11-30 22:18:46
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "account"
#

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0-管理员，1-教师，2-学生',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

#
# Data for table "account"
#

INSERT INTO `account` VALUES (1,'asd','asd',0),(2,'asd','asd',0),(3,'asd','asd',0),(4,'asd','asd',0),(5,'accmina','123456',0);

#
# Structure for table "department"
#

CREATE TABLE `department` (
  `departmentid` int(11) NOT NULL AUTO_INCREMENT,
  `departmentname` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`departmentid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

#
# Data for table "department"
#

INSERT INTO `department` VALUES (1,'gh');

#
# Structure for table "meeting_info"
#

CREATE TABLE `meeting_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) NOT NULL DEFAULT '0',
  `booker_type` tinyint(3) NOT NULL DEFAULT '0',
  `booker_id` int(11) NOT NULL DEFAULT '0',
  `theme` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `scale` int(11) DEFAULT NULL,
  `book_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `start_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

#
# Data for table "meeting_info"
#

INSERT INTO `meeting_info` VALUES (8,0,0,1,'是的',10,'2019-11-28 20:34:36','2019-11-20 19:59:19','2019-11-15 20:48:30'),(10,0,0,1,'啥是发到',23,'2019-11-29 22:21:01','2019-11-30 20:23:56','2019-11-29 22:20:57'),(11,0,0,1,'卡三大势',23,'2019-11-29 22:34:09','2019-11-13 20:48:27','2019-11-27 20:54:52'),(12,3,0,1,'minabakaba',23,'2019-11-29 22:40:58','2019-11-13 20:48:27','2019-11-27 20:54:52'),(13,4,0,1,'dw',38,'2019-11-30 22:15:03','2019-11-14 20:49:23','2019-11-15 20:49:26');

#
# Structure for table "meeting_room"
#

CREATE TABLE `meeting_room` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `rno` char(8) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '房间号',
  `capacity` int(11) DEFAULT '0',
  `status` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

#
# Data for table "meeting_room"
#

INSERT INTO `meeting_room` VALUES (3,'222',100,0),(4,'333',10,2),(8,'666',66,0),(9,'342',15,0);

#
# Structure for table "user"
#

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `acc_id` int(11) NOT NULL DEFAULT '0',
  `type` tinyint(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'mina',5,0);
