create database IT_KB;
USE IT_KB;

CREATE TABLE `user`
(
    `user_number`   bigint(20)  NOT NULL auto_increment primary key,
    `user_id`       varchar(20) NULL,
    `user_password` varchar(20) NULL,
    `name`          varchar(20) NULL
);

CREATE TABLE `product`
(
    `product_id`   bigint(20)   NOT NULL auto_increment primary key,
    `product_type` char(1)      NULL,
    `product_name` varchar(255) NULL,
    `image_path`   varchar(255) NULL,
    `product_url`  varchar(255) NULL
);

CREATE TABLE `custom_page`
(
    `user_number` bigint(20)   NOT NULL primary KEY,
    `page_name`   varchar(255) NULL,
    `layout_data` json         NULL,
    'image_url'   varchar(255) NULL,
    FOREIGN KEY (user_number) REFERENCES user (user_number)
);

#   layout_data_column
#   `위젯ID`
# 	`x좌표`
# 	`y좌표`
# 	`세로길이`
# 	`가로길이`
# 	`다중페이지번호`
# 	`위젯이미지`
# 	`위젯설정`

CREATE TABLE `custom_community`
(
    `user_number` bigint(20) NOT NULL primary KEY,
    `heart`       bigint(20) NULL,
    FOREIGN KEY (user_number) REFERENCES custom_page (user_number)
);

CREATE TABLE `account`
(
    `account_number` bigint(20) NOT NULL primary KEY,
    `user_number`    bigint(20) NOT NULL,
    `account_type`   bigint(20) NULL,
    `balance`        bigint(20) NULL,
    FOREIGN KEY (user_number) REFERENCES user (user_number)
);


CREATE TABLE `widget`
(
    `widget_id` bigint(20)   NOT NULL auto_increment primary key,
    `name`      varchar(255) NULL,
    `type`      varchar(255) NULL
);
