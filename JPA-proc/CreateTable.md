CREATE TABLE `stock` (
  `STOCK_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `STOCK_CODE` varchar(10) NOT NULL,
  `STOCK_NAME` varchar(20) NOT NULL,
  PRIMARY KEY (`STOCK_ID`) USING BTREE,
  UNIQUE KEY `UNI_STOCK_NAME` (`STOCK_NAME`),
  UNIQUE KEY `UNI_STOCK_ID` (`STOCK_CODE`) USING BTREE
)



stockCREATE TABLE `category` (
  `CATEGORY_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(10) NOT NULL,
  `DESC` varchar(255) NOT NULL,
  PRIMARY KEY (`CATEGORY_ID`) USING BTREE
)


CREATE TABLE  `stock_category` (
  `STOCK_ID` int(10) unsigned NOT NULL,
  `CATEGORY_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`STOCK_ID`,`CATEGORY_ID`),
  CONSTRAINT `FK_CATEGORY_ID` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `category` (`CATEGORY_ID`),
  CONSTRAINT `FK_STOCK_ID` FOREIGN KEY (`STOCK_ID`) REFERENCES `stock` (`STOCK_ID`)
)
==================
CREATE TABLE `id_gen` (
	`gen_name` VARCHAR(45) NOT NULL,
	`gen_val` VARCHAR(45) NULL DEFAULT NULL,
	PRIMARY KEY (`gen_name`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `desk_gen` (
	`gen_name` VARCHAR(45) NOT NULL,
	`gen_value` VARCHAR(45) NULL DEFAULT NULL,
	PRIMARY KEY (`gen_name`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `employee` (
	`idemployee` INT(11) NOT NULL,
	`firstname` VARCHAR(45) NULL DEFAULT NULL,
	`lastname` VARCHAR(45) NULL DEFAULT NULL,
	`email` VARCHAR(45) NULL DEFAULT NULL,
	`iddesk` INT(11) NULL DEFAULT NULL,
	`iddepartment` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`idemployee`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `desk` (
	`iddesk` INT(11) NOT NULL,
	`number` VARCHAR(45) NULL DEFAULT NULL,
	`location` VARCHAR(45) NULL DEFAULT NULL,
	PRIMARY KEY (`iddesk`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
