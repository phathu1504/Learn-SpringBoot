-- Tao user
-- Create user câu lệnh tạo user
-- 'spring'@'%' Cách xác định người dùng mới và phạm vi spring: ten nguoi dung va % la quyen truy cap moi thu
-- IDENTIFIED BY 'spring' xác định mật khẩu 
CREATE USER 'spring'@'%' IDENTIFIED BY 'spring';
GRANT ALL PRIVILEGES ON * . * TO 'spring'@'%';

-- Tao Database
CREATE DATABASE 
IF NOT EXISTS `Student_ms` 
CHARACTER SET utf8mb4 
COLLATE utf8mb4_general_ci;

-- Tạo Table
CREATE TABLE `students` (
 `id` int NOT NULL AUTO_INCREMENT,
 `last_name` varchar(45) DEFAULT NULL,
 `first_name` varchar(45) DEFAULT NULL,
 `email` varchar(45) DEFAULT NULL,
 PRIMARY KEY (`id`) USING BTREE
) 
ENGINE=INNODB 
AUTO_INCREMENT=1 
DEFAULT CHARSET=UTF8MB4 
COLLATE=UTF8MB4_UNICODE_CI;


-- Them data
INSERT INTO `students` (`last_name`, `first_name`, `email`)
VALUES
  ('Nguyễn', 'Văn A', 'vana@gmail.com'),
  ('Trần', 'Thị B', 'thib@gmail.com'),
  ('Lê', 'Văn C', 'vanc@gmail.com'),
  ('Phạm', 'Thị D', 'thid@gmail.com'),
  ('Huỳnh', 'Văn E', 'vane@gmail.com'),
  ('Nguyễn', 'Thị F', 'thif@gmail.com'),
  ('Trần', 'Văn G', 'vang@gmail.com'),
  ('Lê', 'Thị H', 'thih@gmail.com'),
  ('Phạm', 'Văn I', 'vani@gmail.com'),
  ('Huỳnh', 'Thị K', 'thik@gmail.com');
  
  Create table users(
	`username` varchar(50) primary key,
    `password` varchar(100) not null,
    `enabled` tinyint not null  -- Xem table co hoat dong hay khong
  );
  
  Create table authorities (
	username varchar(50) not null,
    authority varchar(50) not null,
    unique key(username, authority),
    constraint fk_username foreign key (username) references users(username)
  );
  




