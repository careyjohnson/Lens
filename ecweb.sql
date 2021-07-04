drop database if exists ecweb;
create database ecweb;
use ecweb;

create table Users(
id int auto_increment primary key,
username varchar(20) not null unique,
password varchar(20) not null,
email varchar(50),
phone varchar(13),
address varchar(200)
-- created_by bigint,
-- created_time datetime,
-- update_by bigint,
-- update_time datetime
);

create table Category(
id int primary key,
name varchar(20) not null
-- description varchar(500)
-- category_id varchar(10)
-- created_by bigint,
-- created_time datetime,
-- update_by bigint,
-- update_time datetime
);

create table Products(
id int auto_increment primary key ,
code varchar(20) not null unique,
name varchar(20) not null,
price float,
description varchar(500),
-- inventory bigint,
category_id int references Category(category_id)
-- created_by bigint,
-- created_time datetime,
-- update_by bigint,
-- update_time datetime,
);

create table PaymentMethod(
id bigint auto_increment primary key,
name varchar(20) not null,
PaymentMethod_id varchar(10)
-- created_by bigint,
-- created_time datetime,
-- update_by bigint,
-- update_time datetime
);

-- drop table ShoppingCart;
create table ShoppingCart(
id varchar(10) primary key,
user_id int not null references Users(id) ,
payment_method varchar(10) references PaymentMethod(PaymentMethod_id),
status varchar(30)
-- created_by bigint,
-- created_time datetime,
-- update_by bigint,
-- update_time datetime,
-- FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- drop table ShoppingCart_Product;
create table ShoppingCart_Product(
id int auto_increment primary key,
product_id varchar(10) references Products(id),
shoppingcart_id varchar(10) references ShoppingCart(id),
price float,
name varchar(20),
description varchar(500),
total_price float not null,
-- promotion decimal(10,2),
-- Inventory bigint,
category_id int references Category(id)
-- created_by bigint,
-- created_time datetime,
-- update_by bigint,
-- update_time datetime,
-- FOREIGN KEY (product_id) REFERENCES Products (id) ON DELETE CASCADE ON UPDATE CASCADE,
-- FOREIGN KEY (shoppingcart_id) REFERENCES ShoppingCart (id) ON DELETE CASCADE ON UPDATE CASCADE,
-- FOREIGN KEY (category_id) REFERENCES Category (id) ON DELETE CASCADE ON UPDATE CASCADE
);

create table Staff(
id bigint auto_increment primary key,
username varchar(20) not null unique,
password varchar(20) not null,
email varchar(20)
-- created_by bigint,
-- created_time datetime,
-- update_by bigint,
-- update_time datetime
);

select*from Staff;
insert into Staff (username,password,email) values
('admin','123','admin@admin');
insert Users (username,password,email,phone,address) values
('mai','123','careyjohnson2091@gmail.com','0973425671','Ha Noi'),
('linh','456','linh60725@gmail.com','0919496558','Ha Noi'),
('nam','abc','namnguyen@gmail.com','0394562143','Ha Nam'),
('minh','xyz','minh2901@gmail.com','0976567898','Nam Dinh');
select * from users;

select*from Category;
insert Category values
(1,'Lens mau'),
(2,'Lens nhu'),
(3,'Lens trong suot'),
(4,'Lens cho mat tho'),
(5,'Coc rua lens'),
(6,'Nuoc ngam lens'),
(7,'May rua lens'),
(8,'Thuoc nho mat lens');

select*from Products;
insert Products (code,name,price,description,category_id)
values	('P01',	'Sapa Gray',		329000 ,	N'Thành phần nước: 45 %,Đường kính: 14.2 mm,Độ giãn tròng: 13.4mm ,Bán kính cong: 8.7 mm,Độ cận: 0 - 8',1),
		('P02',	'Phu Quoc Gray',	329000 ,	N'Thành phần nước: 45 %,Đường kính: 14.2 mm,Độ giãn tròng: 13.4mm ,Bán kính cong: 8.7 mm,Độ cận: 0 - 8',1),
        ('P03',	'Hoi An Brown',		329000 ,	N'Thành phần nước: 45 %,Đường kính: 14.2 mm,Độ giãn tròng: 13.4mm ,Bán kính cong: 8.7 mm,Độ cận: 0 - 8',2),
        ('P04',	'Purple Star ',		329000 ,	N'Thành phần nước: 45 %,Đường kính: 14.2 mm,Độ giãn tròng: 13.4mm ,Bán kính cong: 8.7 mm,Độ cận: 0 - 8',2),
        ('P05',	'Elegant ',			329000 ,	N'Thành phần nước: 45 %,Đường kính: 14.2 mm,Độ giãn tròng: 13.4mm ,Bán kính cong: 8.7 mm,Độ cận: 0 - 8',2),
        ('P06',	'Whinky whinky',	329000 ,	N'Thành phần nước: 45 %,Đường kính: 14.2 mm,Độ giãn tròng: 13.4mm ,Bán kính cong: 8.7 mm,Độ cận: 0 - 8',3),
        ('P07',	'Sexy Gray',		329000 ,	N'Thành phần nước: 45 %,Đường kính: 14.2 mm,Độ giãn tròng: 13.4mm ,Bán kính cong: 8.7 mm,Độ cận: 0 - 8',3),
        ('P08',	'Pixe ',			329000 ,	N'Thành phần nước: 45 %,Đường kính: 14.2 mm,Độ giãn tròng: 13.4mm ,Bán kính cong: 8.7 mm,Độ cận: 0 - 8',4),
		('P09',	'Cherry Moon',		329000 ,	N'Thành phần nước: 45 %,Đường kính: 14.2 mm,Độ giãn tròng: 13.4mm ,Bán kính cong: 8.7 mm,Độ cận: 0 - 8',4),
		('P10',	'Sophie Black',		329000 ,	N'Thành phần nước: 45 %,Đường kính: 14.2 mm,Độ giãn tròng: 13.4mm ,Bán kính cong: 8.7 mm,Độ cận: 0 - 8',4),
        ('P11', 'Coc rua lens',		50000,		N' Chất liệu: Nhựa cao cấp, Thiết kế: Cốc, tròn,  Loại máy: Rửa bằng tay, Công dụng: Rửa lens; cất giữ, bảo quản lens',5),
        ('P12', 'Nuoc ngam lens',	125000,		N' ISO 13485: tiêu chuẩn chất lượng cho sản phẩm y tế, Đủ tiêu chuẩn xuất khẩu châu Âu (chứng nhận CE)',6),
		('P13', 'May rua lens',		125000,		N' Chất liệu: nhựa dẻo, Kích thước: 63 * 34 * 28mm, Cân nặng: 31g, Thời gian làm sạch: , Chạy bằng pin',7),
		('P14', 'Thuoc nho mat lens',	125000,	N' Thành phần: Dung dịch Acid Hyaluronic đã được sử lý tiệt trùng, Tác dụng: Cung cấp độ ẩm cho mắt, giúp bạn không bị mỏi hay khô mắt. Ngoài ra, dung dịch còn có khả năng làm ẩm kính áp tròng trong khi sử dụng.',8);
     
select*from PaymentMethod;
insert PaymentMethod(name,PaymentMethod_id) values 
(' tien mat','PM01'),
(' the tin dung','PM02');

select*from ShoppingCart;
insert ShoppingCart values 
('SC01',1,'PM01','Thanh toan bang tien mat'),
('SC02',2,'PM01','Thanh toan bang tien mat'),
('SC03',3,'PM02','Thanh toan bang the tin dung'),
('SC04',4,'PM02','Thanh toan bang the tin dung');

-- select*from ShoppingCart_Product;
-- insert ShoppingCart_Product(product_id,shoppingcart_id,price,total_price,category_id) values












