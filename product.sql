-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.0.67-community-nt - MySQL Community Edition (GPL)
-- 服务器OS:                        Win32
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for product
CREATE DATABASE IF NOT EXISTS `product` /*!40100 DEFAULT CHARACTER SET ucs2 COLLATE ucs2_unicode_ci */;
USE `product`;

-- Dumping structure for table product.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL auto_increment,
  `user` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table product.admin: ~1 rows (大约)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`, `user`, `password`, `type`) VALUES
	(6, 'root', 'root', 'admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- Dumping structure for table product.cart
CREATE TABLE IF NOT EXISTS `cart` (
  `id` int(11) NOT NULL auto_increment,
  `pro_name` varchar(32) collate ucs2_unicode_ci default NULL,
  `pro_count` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=ucs2 COLLATE=ucs2_unicode_ci;

-- Dumping data for table product.cart: ~0 rows (大约)
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;

-- Dumping structure for table product.order_msg
CREATE TABLE IF NOT EXISTS `order_msg` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(50) default NULL,
  `pro_name` varchar(50) default NULL,
  `number` varchar(50) default NULL,
  `moeny` float default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- Dumping data for table product.order_msg: ~29 rows (大约)
/*!40000 ALTER TABLE `order_msg` DISABLE KEYS */;
INSERT INTO `order_msg` (`id`, `username`, `pro_name`, `number`, `moeny`) VALUES
	(21, 'ysq', '小米', 'srmN4rtFcCn2', 12000),
	(23, 'ysq', '小米', 'A6HaQ1jQYSc7', 12000),
	(24, 'ysq', '小米', 'A6HaQ1jQYSc7', 12000),
	(25, 'ysq', '小米', 'A6HaQ1jQYSc7', 12000),
	(26, 'ysq', '小米', 'A6HaQ1jQYSc7', 12000),
	(27, 'ysq', '小米', 'A6HaQ1jQYSc7', 12000),
	(28, 'ysq', '小米', 'A6HaQ1jQYSc7', 12000),
	(29, 'ysq', '小米', 'A6HaQ1jQYSc7', 12000),
	(30, 'ysq', '小米', 'A6HaQ1jQYSc7', 12000),
	(31, 'ysq', '小米', 'A6HaQ1jQYSc7', 12000),
	(32, 'ysq', '小米', 'A6HaQ1jQYSc7', 12000),
	(33, 'ysq', '小米', 'A6HaQ1jQYSc7', 12000),
	(34, 'ysq', '小米', 'A6HaQ1jQYSc7', 12000),
	(35, 'ysq', '小米', 'A6HaQ1jQYSc7', 12000),
	(36, 'ysq', '小米', 'Wrp6ZGQK1F23', 12000),
	(37, 'ysq', '小米', 'ACz3Ji3BraAz', 1299),
	(38, 'ysq', '小米', 'P0147HeMRMFr', 1299),
	(43, 'ysq', '华为', 'B6XehyiKeY6Z', 3599),
	(44, 'ysq', '小米', '0zCPpkxD4KsE', 1299),
	(45, 'ysq', '小米', 'czpsa8zDwxmJ', 1299),
	(46, 'ysq', '小米', 'czpsa8zDwxmJ', 1299),
	(47, 'ysq', '小米', '8QiyW3Ym3pD3', 1299),
	(48, 'ysq', '小米', 'hsepz07y1QpR', 1299),
	(49, 'ysq', '小米', 'nmkfEB1Cs5NT', 1299),
	(50, 'ysq', '小米', 'x6n11x0y23AS', 1299),
	(51, 'ysq', '小米', 'JXNtthMm6619', 1299),
	(52, 'ysq', '小米', 'bk1kRQ83Gwzs', 1299),
	(53, 'ysq', '小米', 'khYHmcefbwCB', 1299),
	(54, 'ysq', 'apple', 'N9WR7fhQmzWp', 1799);
/*!40000 ALTER TABLE `order_msg` ENABLE KEYS */;

-- Dumping structure for table product.product
CREATE TABLE IF NOT EXISTS `product` (
  `pro_id` int(11) NOT NULL auto_increment,
  `pro_batch` varchar(4) NOT NULL,
  `pro_name` varchar(10) NOT NULL,
  `pro_hard` varchar(10) NOT NULL,
  `pro_soft` varchar(20) NOT NULL,
  `pro_time` datetime NOT NULL,
  `pro_count` int(11) NOT NULL,
  `pro_mac_min` varchar(17) NOT NULL,
  `pro_mac_max` varchar(17) NOT NULL,
  `pro_mac_format` varchar(11) NOT NULL,
  `pro_sn_min` varchar(32) NOT NULL,
  `pro_sn_max` varchar(32) NOT NULL,
  `pro_sn_format` varchar(32) NOT NULL,
  `pro_code_count` int(11) NOT NULL,
  `pro_remark` varchar(255) default NULL,
  PRIMARY KEY  (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- Dumping data for table product.product: ~30 rows (大约)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`pro_id`, `pro_batch`, `pro_name`, `pro_hard`, `pro_soft`, `pro_time`, `pro_count`, `pro_mac_min`, `pro_mac_max`, `pro_mac_format`, `pro_sn_min`, `pro_sn_max`, `pro_sn_format`, `pro_code_count`, `pro_remark`) VALUES
	(1, '1', '小米', 'MI8', 'v1.1.0', '2018-03-01 00:00:00', 1299, 'AB:CD:EF:01', 'AB:CD:EF:01:2E:E0', 'AB:CD:EF:01', 'J00017E230100001', 'J00017E230112000', 'J00017E2301', 12000, '无'),
	(2, '1', '苹果', '7plus', 'ios13.3', '2017-06-12 00:00:00', 2899, 'EA:CB:ED:23', 'CD:ED:12:CB:32:23', 'BE:DN:EF:12', 'B8347532B934841', 'A23017B24332423', 'A23213D1233', 18000, '无'),
	(3, '1', '华为', 'P20', 'v8.80', '2018-01-21 00:00:00', 3599, 'CD:CB:DD:23', 'AD:DE:EQ:93:2A:BD', 'CD:EQ:AB:23', 'F4832B9213812311', 'Q9553232B213121', 'F212B2131211', 35000, '无'),
	(4, '2', 'vivo', 'x27', 'v2.2.0', '2018-05-06 00:00:00', 1999, 'BE:DN:EF:12', 'CD:32:ED:12:2A:CE', 'AC:BC:AD:12', 'B34232C24213218', 'C23946732B21331', 'B3213E213217', 23000, '无'),
	(5, '1', 'oppp', 'r11', 'v1.2.3', '2017-02-03 00:00:00', 1599, 'CD:CB:DD:23', 'CD:DE:AB:11:2A:BC', 'BC:CD:AC:10', 'N23232C72343421 ', 'J211C21434324121', 'Q984534E433', 15000, '无'),
	(6, '2', '小米', 'MI9', 'v6.3.0', '2019-01-01 00:00:00', 3299, 'AB:CD:EF:01', 'BC:AQ:12:93:2A:AB', 'DE:AC:DE:53', 'E283474C8734212', 'B231278C21312311', 'B3434V23234', 32000, '无'),
	(7, '1', '三星', 's10', 'v9.0.2', '2016-02-01 00:00:00', 1699, 'ED:CB:DD:23', 'DC:65:EQ:23:2A:AC', 'AC:BC:AD:12', 'Q2173123B290831', 'Q238127C2131333', 'J8483243B85', 16000, '无'),
	(8, '2', 'apple', '6plus', 'ios11.2.0', '2016-11-11 00:00:00', 1799, 'BE:CE:CE:99', 'AD:DE:AB:11:2A:BC', 'AB:CD:EF:01', 'J2813453C723123', 'C2121C213534324', 'C3458374A471', 17000, '无'),
	(9, '1', '华为', 'mate30', 'v8.0.1', '2018-06-03 00:00:00', 5399, 'CD:CB:DD:23', 'CD:ED:12:CB:32:23', 'BE:DN:EF:12', 'E274324A27137121', 'P09348543B77211', 'D454N435343', 53000, '无'),
	(10, '3', '坚果', 'pro3', 'v7.3.0', '2017-03-12 00:00:00', 1999, 'BE:DN:EF:12', 'BD:32:ED:12:2A:CE', 'CD:EQ:AB:23', 'D72347B23784971', 'D87349A23761274', 'T7543B345742', 19000, '无'),
	(11, '3', '华为', 'mate10', 'v9.0.1', '2019-06-08 00:00:00', 2599, 'CD:CB:DD:23', 'CD:DE:AB:11:2A:BC', 'BC:CD:AC:10', 'Q437328E2341231', 'B732C7237234512', 'J3455B834759', 25000, '无'),
	(12, '1', '三星', 's9', 'v8.0.2', '2017-09-09 00:00:00', 5899, 'BE:DN:EF:12', 'CD:ED:12:CB:32:23', 'CD:EQ:AB:23', 'B7382423E218312', 'C23946732B21331', 'J8483243B85', 58000, '无'),
	(13, '2', '红米', 'k30pro', 'v10.1.0', '2019-10-12 00:00:00', 3899, 'CD:CB:DD:23', 'AB:CD:EF:01:2E:E0', 'BE:DN:EF:12', 'A8372432B324212', 'Q9553232B213121', 'A08815D8788', 38000, '无'),
	(14, '2', '苹果', '11pro', 'ios9.3.3', '2019-07-01 00:00:00', 2399, 'BE:DN:EF:12', 'CD:ED:12:CB:32:23', 'CD:EQ:AB:88', 'C834214321B8923', 'A27421E2301E7678', 'Q984534E433', 23000, '无'),
	(15, '1', '华为', 'p30pro', 'v6.5.0', '2016-06-08 00:00:00', 1599, 'CD:CB:DD:23', 'AD:DE:EQ:93:2A:AC', 'DE:AC:DE:53', 'J2813453C723123', 'Q238127C2131333', 'J00017E2301', 15000, '无'),
	(16, '3', 'oppo', 'A53', 'v7.3.0', '2016-12-12 00:00:00', 2899, 'BE:DN:EF:12', 'BD:32:ED:12:2A:CE', 'AB:CD:EF:01', 'A27421E2301ES321 ', 'C2121C213534324', 'A08815D8788', 28000, '无'),
	(17, '1', 'vivo', 'nex3', 'v9.2.0', '2017-05-08 00:00:00', 2799, 'BE:DN:EF:12', 'AD:DE:EQ:93:2A:AC', 'BE:DN:EF:12', 'B34232C24213218', 'J211C21434324121', 'B3434V23234', 27000, '无'),
	(18, '2', '华为', 'mate30', 'v6.0.2', '2018-10-21 00:00:00', 1699, 'BE:CE:CE:99', 'AB:CD:EF:01:2E:E0', 'CD:EQ:AB:23', 'D72347B23784971', 'B231278C21312311', 'Q984534E433', 16000, '无'),
	(19, '1', '红米', 'k20', 'v8.2.1', '2019-03-10 00:00:00', 3699, 'CD:CB:DD:23', 'CD:ED:12:CB:32:23', 'DE:AC:DE:42', 'Q2173123B290831', 'A27421E2301E7678', 'D454N435343', 36000, '无'),
	(20, '3', '中兴', 'Axon10', 'v8.2.3', '2017-04-06 00:00:00', 2799, 'BE:DN:EF:12', 'AD:DE:EQ:93:2A:AC', 'BE:DN:EF:72', 'A27421E2301ES321 ', 'P09348543B77211', 'C3458374A471', 27000, '无'),
	(21, '1', 'apple', '8plus', 'ios9.0.0', '2017-10-12 00:00:00', 1799, 'CD:CB:DD:23', 'CD:DE:AB:11:2A:BC', 'CD:EQ:AB:23', 'E274324A27137121', 'A27421E2301E7678', 'J00017E2301', 17000, '无'),
	(22, '2', '联想', 'Z6pro', 'v5.1.2', '2017-09-09 00:00:00', 2899, 'BE:DN:EF:12', 'BD:32:ED:12:2A:CE', 'BE:DN:EF:12', 'A27421E2301ES321 ', 'C23946732B21331', 'A08815D8788', 28000, '无'),
	(23, '1', '华为', 'p9', 'v9.0.2', '2016-10-21 00:00:00', 1699, 'CD:CB:DD:23', 'AB:CD:EF:01:2E:E0', 'AB:CD:EF:01', 'C834214321B8923', 'Q238127C2131333', 'Q984534E433', 16000, '无'),
	(24, '3', '荣耀', 'v20', 'v9.2.1', '2018-09-02 00:00:00', 2799, 'BE:CE:CE:99', 'CD:ED:12:CB:32:23', 'BE:DN:EF:12', 'C834214321B8923', 'C23946732B21331', 'D454N435343', 27000, '无'),
	(25, '1', '华为', 'p30', 'v5.2.1', '2019-08-01 00:00:00', 2999, 'BE:DN:EF:12', 'AD:DE:EQ:93:2A:AC', 'CD:EQ:AB:88', 'A27421E2301ES321 ', 'A27421E2301E7678', 'B3434V23234', 29000, '无'),
	(26, '2', '三星', 'note10', 'v9.0.0', '2016-10-11 00:00:00', 3599, 'CD:CB:DD:23', 'BD:32:ED:12:2A:CE', 'BE:DN:EF:12', 'J2813453C723123', 'A23017B24332423', 'A08815D8788', 35000, '无'),
	(27, '1', 'vivo', 's5', 'v6.3.3', '2019-12-10 00:00:00', 4299, 'CD:CB:DD:23', 'AD:DE:EQ:93:2A:AC', 'CD:EQ:AB:23', 'C834214321B8923', 'C23946732B21331', 'B3213E213217', 42000, '无'),
	(28, '2', '小米', 'Mix3', 'v8.0.0', '2017-09-18 00:00:00', 4199, 'BE:DN:EF:12', 'AB:CD:EF:01:2E:E0', 'BE:DN:EF:12', 'B34232C24213218', 'Q9553232B213121', 'J00017E2301', 41000, '无'),
	(29, '1', '苹果', 'se', 'ios8.2.0', '2018-08-18 00:00:00', 5599, 'BE:CE:CE:99', 'EQ:DE:EQ:93:2A:AC', 'DE:AC:DE:53', 'J2813453C723123', 'P09348543B77211', 'D454N435343', 55000, '无'),
	(30, '3', '三星', 'note9', 'v10.1.0', '2017-10-10 00:00:00', 3999, 'CD:CB:DD:23', 'CD:32:ED:12:2A:CE', 'AC:AB:QF:69', 'E274324A27137121', 'C2121C213534324', 'C3458374A471', 39000, '无');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping structure for table product.review
CREATE TABLE IF NOT EXISTS `review` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `main` varchar(2000) NOT NULL,
  `true_id` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`true_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- Dumping data for table product.review: ~6 rows (大约)
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` (`id`, `username`, `main`, `true_id`) VALUES
	(1, 'siming', '手机拿到手上第一感觉就是很轻便，颜色看着让人有一种惊艳的感觉，颜值很高，打开相机拍照很清楚，听音乐音质很好，果然是千元机的首选，一如既往的支持小米，京东快递服务很好，快递速度快，值得表扬一下', 2),
	(3, 'dehua', '货都发错了', 3),
	(1, '123', '非常的满意。宝贝很不错，物美价廉很喜欢。实惠又划算。国际大品牌，大容量，大电池。太爱了，非常的漂亮。黑色高端大气，戴了壳也很好看。续航超级给力。服务好，物流快。6000mAh的电池，不重也不轻。拿着很舒适。充电也OK、拍照也可以。小米手机性价比超高的，红米价格也亲民。非常的棒哦！希望小米未来前途一片光明，做得越来越好、走上国际巅峰。必须五星好评！赞赞赞！！！', 15),
	(2, 'ysq', '跟预想的一样好', 17),
	(6, 'ysq', '垃圾的要死', 19),
	(1, 'ysq', '挺好的', 22);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;

-- Dumping structure for table product.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(50) NOT NULL default '0',
  `pwd` varchar(50) NOT NULL default '0',
  `moeny` float default '0',
  `address` varchar(100) default '0',
  `phone` varchar(50) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Dumping data for table product.user: ~3 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `pwd`, `moeny`, `address`, `phone`) VALUES
	(1, 'ysq', 'ysq', 27130, '海南软件职业技术学院10栋206', '12345678901'),
	(2, 'csm', '123456', 10000, '海南软件职业技术学院', '13189147258'),
	(3, '张三', '123456', 20000, '海南', '12345678901');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
