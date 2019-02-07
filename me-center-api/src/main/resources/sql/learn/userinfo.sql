/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 5.7.24-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

/**
建测试表
 */
create table `userinfo` (
	`userId` integer,
	`username` varchar (6000),
	`password` varchar (3000)
);
/**
插入测试数据
 */
INSERT INTO dev.userInfo (userId,username,PASSWORD)VALUES(1,"jack","12345678");