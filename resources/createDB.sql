DROP DATABASE IF EXISTS webdeli;
CREATE DATABASE webdeli DEFAULT CHARACTER SET utf8;
USE webdeli;

DROP TABLE IF EXISTS dish;
CREATE TABLE dish (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO dish VALUES 
('1','Fish Fillet in Sichuan Style','9'),
('2','Fried Cumin Pork with Vegetables','9'),
('3','Chicken in Chestnut Plum Sauce','9'),
('4','Fried Chicken with Hot Pepper','9'),
('5','Spicy Stir-Fired Hot Pot','10'),
('6','Three Cup Sauces Chicken', '10'),
('7','Fried pickel bean with minced pork','8');


DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `userName` varchar(45) DEFAULT NULL,
  `dishName` varchar(200) DEFAULT NULL,
  `dishId` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `cell` varchar(45) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  `place` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `payment` varchar(45) DEFAULT NULL,
  `isPaid` tinyint(1) DEFAULT NULL,
  `isPicked` tinyint(1) DEFAULT NULL, 
  `note` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

INSERT INTO `order` VALUES 
('Wenxin','Fish Fillet in Sichuan Style','1','wfang33@gatech.edu','4047290784','12:00','student center','10','venmo',1,'1','no onion'),
('Ryan','Fried pickel bean with minced pork','7','ryan@gatech.edu','4042312354','11:30','tech square','8','debit card',0,'0','super spicy'),
('Keidy','Fried Chicken with Hot Pepper','4','keidy@gatech.edu','4049992351','12:00','glc/10th','9','paypal',0,'0',''),
('Shin','Fried Cumin Pork with Vegetables','2','shin@gatech.edu','4048924812','12:00','100Midtown','9','venmo',0,'0','no garlic please!');
#('id','userName','dishName','dishId','email','cell','time','place','price','payment','isPaid','isPicked','note'),
