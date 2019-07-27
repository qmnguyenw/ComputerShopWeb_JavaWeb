create database [ComputerShopManagement]
go
use [ComputerShopManagement]
go
create table [account]
(
	  [id] int not null,
      [username] varchar(20) primary key,
      [password] varchar(20) not null,
	  [email] varchar(30),
	  [role] varchar(20) not null,
	  [address] varchar(90),
)
go
insert into [account] values(1,'sa','sa','sa','owner','')
insert into [account] values(2,'admin','admin','admin@admin.com','admin','')
insert into [account] values(3,'quang','123','abc@def.com','staff','hanoi')
insert into [account] values(4,'huy','456','def@abc.com','customer','hanoi')
go
create table [categories]
(
   [id] varchar(6) primary key,
   [name] nvarchar(30) ,
   [describe] nvarchar(50), 
)
go
insert into [categories] values('1','Dell',N'gọn nhẹ, pin lâu')
insert into [categories] values('2','Lenovo',N'dáng đẹp, nhiều chức năng')
insert into [categories] values('3','MSI',N'sang trọng, thời thượng')

go
create table [products]
(
   [id] varchar(8)  primary key,
   [name] varchar(30) not null,
   [cat_ID] varchar(6) references Categories(ID),
   [price] float,
   [quantity] int,
   [describe] nvarchar(50),
   [adddate] datetime, 
)
go

insert into products values('D8','Dell G7','1',7000,12,N'core i7','8/5/2019')
insert into products values('D7','Dell G8','1',7522,34,N'core i9','8/5/2019')
insert into products values('L2','Lenovo L2','2',6000,30,N'core i5','10/5/2019')
insert into products values('M2','MSI G2','3',9000,10,N'core i7','11/5/2019')

go
