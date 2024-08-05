DROP DATABASE IF EXISTS MovieKiosk;

CREATE DATABASE MovieKiosk;

USE MovieKiosk;

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
	`mo_num`	int primary key auto_increment	NOT NULL,
	`mo_title`	varchar(255)	NULL,
	`mo_content`	longtext	NULL,
	`mo_time`	int	NULL,
	`mo_age`	varchar(20)	NULL,
	`mo_date`	date	NULL
);

DROP TABLE IF EXISTS `theater`;

CREATE TABLE `theater` (
	`th_name`	varchar(30)	primary key not NULL,
	`th_screen`	int	NULL,
	`th_seat`	int	NULL,
	`th_address`	varchar(255)	NULL,
	`th_region`	varchar(10)	NULL
);

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
	`sd_num`	int primary key auto_increment	NOT NULL,
	`sd_time`	time	NULL,
	`sd_date`	date	NULL,
	`sd_mo_num`	int	NOT NULL,
	`sd_sc_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `screen`;

CREATE TABLE `screen` (
	`sc_num`	int primary key auto_increment	NOT NULL,
	`sc_name`	varchar(30)	NULL,
	`sc_seat`	int	NULL,
	`sc_th_name`varchar(30)	NOT NULL
);

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
	`se_num`	int primary key auto_increment	NOT NULL,
	`se_name`	int	NULL,
	`se_sc_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(15)  primary key	NOT NULL,
	`me_pw`	varchar(255)	NULL,
	`me_authority`	varchar(5)	NULL,
	`me_point`	int	NULL
);

DROP TABLE IF EXISTS `ticket`;

CREATE TABLE `ticket` (
	`ti_num`	int primary key auto_increment	NOT NULL,
	`ti_me_id`	varchar(15)	NOT NULL,
	`ti_sd_num`	int	NOT NULL
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_movie_TO_schedule_1` FOREIGN KEY (
	`sd_mo_num`
)
REFERENCES `movie` (
	`mo_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_screen_TO_schedule_1` FOREIGN KEY (
	`sd_sc_num`
)
REFERENCES `screen` (
	`sc_num`
);

ALTER TABLE `screen` ADD CONSTRAINT `FK_theater_TO_screen_1` FOREIGN KEY (
	`sc_th_name`
)
REFERENCES `theater` (
	`th_name`
);

ALTER TABLE `seat` ADD CONSTRAINT `FK_screen_TO_seat_1` FOREIGN KEY (
	`se_sc_num`
)
REFERENCES `screen` (
	`sc_num`
);

ALTER TABLE `ticket` ADD CONSTRAINT `FK_member_TO_ticket_1` FOREIGN KEY (
	`ti_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `ticket` ADD CONSTRAINT `FK_schedule_TO_ticket_1` FOREIGN KEY (
	`ti_sd_num`
)
REFERENCES `schedule` (
	`sd_num`
);

ALTER TABLE `moviekiosk`.`member` 
CHANGE COLUMN `me_pw` `me_pw` VARCHAR(255) NOT NULL ,
CHANGE COLUMN `me_point` `me_point` INT NULL DEFAULT 0 ;

ALTER TABLE `moviekiosk`.`movie` 
CHANGE COLUMN `mo_title` `mo_title` VARCHAR(255) NOT NULL ,
CHANGE COLUMN `mo_content` `mo_content` LONGTEXT NOT NULL ,
CHANGE COLUMN `mo_time` `mo_time` INT NOT NULL ,
CHANGE COLUMN `mo_age` `mo_age` VARCHAR(20) NOT NULL ,
CHANGE COLUMN `mo_date` `mo_date` DATE NOT NULL ;
