/*
SQLyog Ultimate v8.71 
MySQL - 5.1.62-community : Database - db_equip
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_equip` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_danish_ci */;

USE `db_equip`;

/*Table structure for table `t_equip_borrow_return` */

DROP TABLE IF EXISTS `t_equip_borrow_return`;

CREATE TABLE `t_equip_borrow_return` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equip_info_id` int(11) NOT NULL COMMENT '设备id',
  `type_id` int(11) NOT NULL COMMENT '设备类型id',
  `borrower` varchar(20) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '借用人',
  `borrow_time` datetime DEFAULT NULL COMMENT '借用日期',
  `borrow_day` decimal(10,0) DEFAULT NULL COMMENT '借用天数',
  `return_time` datetime DEFAULT NULL COMMENT '归还日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;

/*Data for the table `t_equip_borrow_return` */

insert  into `t_equip_borrow_return`(`id`,`equip_info_id`,`type_id`,`borrower`,`borrow_time`,`borrow_day`,`return_time`) values (1,2,2,'柳传志','2018-05-11 00:00:00','100',NULL),(2,2,2,'柳传志',NULL,NULL,NULL),(3,2,2,'柳传志','2018-05-11 00:00:00','5',NULL),(4,2,2,'柳传志',NULL,NULL,'2018-05-11 00:00:00'),(5,1,1,'柳传志','2018-05-11 00:00:00','20','2018-05-11 00:00:00'),(6,4,1,'小丽','2018-05-15 00:00:00','3',NULL);

/*Table structure for table `t_equip_info` */

DROP TABLE IF EXISTS `t_equip_info`;

CREATE TABLE `t_equip_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备ID',
  `name` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '设备名称',
  `type_no` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '设备型号',
  `serial_no` int(30) DEFAULT NULL COMMENT '设备序列号',
  `factory_time` datetime DEFAULT NULL COMMENT '出厂日期',
  `file_data` text COLLATE utf8_danish_ci COMMENT '图片',
  `type_id` int(11) DEFAULT NULL COMMENT '设备类型',
  `brand` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '设备品牌',
  `factory` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '生产厂家',
  `buy_time` datetime DEFAULT NULL COMMENT '购买时间',
  `crate_time` datetime DEFAULT NULL COMMENT '添加日期',
  `update_time` datetime DEFAULT NULL COMMENT '修改日期',
  `remark` varchar(200) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '备注',
  `status` int(11) DEFAULT '1' COMMENT '设备状态(1:空闲，2：报废，3：维修，4：借出)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;

/*Data for the table `t_equip_info` */

insert  into `t_equip_info`(`id`,`name`,`type_no`,`serial_no`,`factory_time`,`file_data`,`type_id`,`brand`,`factory`,`buy_time`,`crate_time`,`update_time`,`remark`,`status`) values (1,'华为手机','P20',2020,'2018-05-11 00:00:00','null18-05-11 105215.jpg',1,'华为','华为','2018-05-11 10:52:15','2018-05-11 10:52:15','2018-05-11 10:52:15','',1),(2,'联想手机','20',202020,'2018-05-11 00:00:00','null18-05-11 105306.jpg',2,'联想','联想','2018-05-11 10:53:06','2018-05-11 10:53:06','2018-05-11 10:53:06','',1),(3,'小米','2020',2020,'2018-05-14 00:00:00','',1,'小米','小米','2018-05-14 16:31:56','2018-05-14 16:31:56','2018-05-14 16:31:56','',2),(4,'苹果','苹果6',220,'2018-05-14 00:00:00','',1,'苹果','苹果','2018-05-14 16:33:53','2018-05-14 16:33:53','2018-05-14 16:33:53','',4),(5,'VOVO','2020',2020,'2018-05-14 00:00:00','F:/123/springboot-mybatis/src/main/resources/static/image18-05-14 163558.jpg',2,'VOVO','VOVO','2018-05-14 16:35:58','2018-05-14 16:35:58','2018-05-14 16:35:58','',3),(6,'小米手机','小米max',2020,'2018-05-15 00:00:00','',3,'小米','小米','2018-05-15 09:44:50','2018-05-15 09:44:50','2018-05-15 09:44:50','',1);

/*Table structure for table `t_equip_repair` */

DROP TABLE IF EXISTS `t_equip_repair`;

CREATE TABLE `t_equip_repair` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `equip_info_id` int(11) NOT NULL COMMENT '设备信息id',
  `type_id` int(11) NOT NULL COMMENT '设备类型id',
  `repair_point` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '送修处',
  `repairer` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '维修人员',
  `repair_time` datetime DEFAULT NULL COMMENT '送修日期',
  `failure_cause` varchar(200) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '故障原因',
  `remark` varchar(200) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;

/*Data for the table `t_equip_repair` */

insert  into `t_equip_repair`(`id`,`equip_info_id`,`type_id`,`repair_point`,`repairer`,`repair_time`,`failure_cause`,`remark`) values (1,1,1,'苹果研发中心','任正非','2018-05-11 10:54:36','太像了',''),(2,5,2,'深圳','晓丽','2018-05-15 09:45:51','屏幕不亮','');

/*Table structure for table `t_equip_scrap` */

DROP TABLE IF EXISTS `t_equip_scrap`;

CREATE TABLE `t_equip_scrap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equip_info_id` int(11) NOT NULL COMMENT '设备id',
  `type_id` int(11) NOT NULL COMMENT '设备类型id',
  `scrap_time` datetime DEFAULT NULL COMMENT '报废日期',
  `scrap_cause` varchar(200) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '报废原由',
  `io_cost` decimal(10,0) DEFAULT NULL COMMENT '折旧金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;

/*Data for the table `t_equip_scrap` */

insert  into `t_equip_scrap`(`id`,`equip_info_id`,`type_id`,`scrap_time`,`scrap_cause`,`io_cost`) values (9,2,2,'2018-05-11 00:00:00','','1000'),(10,1,1,'2018-05-11 00:00:00','太贵了','2000'),(11,3,1,'2018-05-15 00:00:00','','200');

/*Table structure for table `t_type` */

DROP TABLE IF EXISTS `t_type`;

CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL COMMENT '设备类型名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;

/*Data for the table `t_type` */

insert  into `t_type`(`id`,`name`) values (1,'常用类'),(2,'普通类'),(3,'闲杂类'),(4,'处理类'),(5,'销毁类'),(9,'博宏01'),(10,'李波红007');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `ctm` datetime DEFAULT NULL COMMENT '创建时间',
  `contact_address` varchar(100) DEFAULT NULL COMMENT '联系地址',
  `status` int(11) DEFAULT '0' COMMENT '0:普通用户，1：管理员  默认新增用户为0',
  `password` varchar(50) DEFAULT '888888' COMMENT '密码，默认888888',
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`user_name`,`age`,`ctm`,`contact_address`,`status`,`password`,`email`) values (1,'王佳佳',NULL,'2018-03-15 09:30:53',NULL,1,'888888','13686456546@163.com'),(2,'张馨予',29,'2018-03-09 15:45:09','深圳',1,'888888','13686456546@163.com'),(4,'王五',19,'2018-03-09 15:45:09','深圳',1,'789456','13686456546@163.com'),(6,'张馨予',29,'2018-03-10 14:22:13','深圳',1,'888888',NULL),(25,'liubbei',NULL,'2018-05-15 14:22:57',NULL,0,'666688','3333@163.com'),(26,'李波',NULL,'2018-05-15 16:39:48',NULL,0,'6665522','1368645@630.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
