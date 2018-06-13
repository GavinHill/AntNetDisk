/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.49 : Database - antnetdisk
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`antnetdisk` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `antnetdisk`;

/*Table structure for table `file` */

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
  `file_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `file_uuid` varchar(100) NOT NULL,
  `file_name` varchar(100) NOT NULL,
  `file_path` varchar(100) NOT NULL,
  `parent_id` varchar(20) NOT NULL,
  `file_type` varchar(10) NOT NULL,
  `upload_date` date NOT NULL,
  `isshare` int(1) NOT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `file` */

insert  into `file`(`file_id`,`user_id`,`file_uuid`,`file_name`,`file_path`,`parent_id`,`file_type`,`upload_date`,`isshare`) values (1,'1','3261eae0-d316-42f1-a9c7-45fff10f98b3_test.txt','test.txt','F:\\JavaWorkSpace\\AntNetDisk\\src\\main\\webapp\\WEB-INF\\upload/8/e/1/3/a/4/7/7','0','File','2018-05-08',0),(2,'1','cd8b1714-bee9-4117-97e8-909385253d8b_aaa','aaa','F:\\JavaWorkSpace\\AntNetDisk\\src\\main\\webapp\\WEB-INF\\upload','0','Folder','2018-05-08',0),(3,'1','154089dd-f853-4311-97dc-c9aa544ab1d5_test2.txt','test2.txt','F:\\JavaWorkSpace\\AntNetDisk\\src\\main\\webapp\\WEB-INF\\upload/c/d/0/6/5/b/b/8','0','File','2018-05-16',0);

/*Table structure for table `share` */

DROP TABLE IF EXISTS `share`;

CREATE TABLE `share` (
  `share_id` int(100) NOT NULL AUTO_INCREMENT,
  `file_id` int(100) DEFAULT NULL,
  `sou_account` varchar(50) DEFAULT NULL,
  `dir_account` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`share_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `share` */

insert  into `share`(`share_id`,`file_id`,`sou_account`,`dir_account`) values (1,1,'1','2');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(100) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(20) NOT NULL,
  `user_psword` varchar(20) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `user_tel` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`user_account`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_account`,`user_psword`,`user_name`,`user_tel`) values (1,'1','123','a',123456789);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
