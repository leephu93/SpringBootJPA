Create database QUANLYBANHANG;

Use QUANLYBANHANG;

Drop database QUANLYBANHANG;

Create table NHANVIEN(
	ID				int identity(1,1),
	FULLNAME		nvarchar(200),
	AGE				int,
	PHONE			varchar(20),
	Primary key (ID)
);

Create table XE(
	ID				int identity(1,1),
	NAME			nvarchar(200),
	NHANVIEN_ID		int,
	Primary key (ID),
	Constraint FK_DELETE_NHANVIEN foreign key (NHANVIEN_ID) references NHANVIEN(ID) on delete cascade,
	Constraint FK_UPDATE_NHANVIEN foreign key (NHANVIEN_ID) references NHANVIEN(ID) on update cascade
);

Create table SANPHAM(
	ID				int identity(1,1),
	NAME			nvarchar(200),
	PRICE			float,
	QUANTITY		int,
	Primary key (ID)
);

Create table NHANVIEN_SANPHAM(
	ID_NHANVIEN		int,
	ID_SANPHAM		int,
	Constraint FK_MTM_DELETE_NHANVIEN foreign key (ID_NHANVIEN) references NHANVIEN(ID) on delete cascade,
	Constraint FK_MTM_UPDATE_NHANVIEN foreign key (ID_NHANVIEN) references NHANVIEN(ID) on update cascade,
	Constraint FK_MTM_DELETE_SANPHAM foreign key (ID_SANPHAM) references SANPHAM(ID) on delete cascade,
	Constraint FK_MTM_UPDATE_SANPHAM foreign key (ID_SANPHAM) references SANPHAM(ID) on update cascade
);

Insert into NHANVIEN(FULLNAME,AGE,PHONE) values(N'John Terry',22,'0935212102');
Insert into NHANVIEN(FULLNAME,AGE,PHONE) values(N'Raymon Knight',45,'0935643643');
Insert into NHANVIEN(FULLNAME,AGE,PHONE) values(N'Jerry Marry',21,'0934364646');
Insert into NHANVIEN(FULLNAME,AGE,PHONE) values(N'David Beckham',27,'0547547547');
Insert into NHANVIEN(FULLNAME,AGE,PHONE) values(N'Raul Golzalet',25,'0954757575');

Insert into XE(NAME,NHANVIEN_ID) values(N'Yamaha Sirius 150cc',2);
Insert into XE(NAME,NHANVIEN_ID) values(N'Yahama Noza 100cc',5);
Insert into XE(NAME,NHANVIEN_ID) values(N'Honda AirBlade 150cc',3);
Insert into XE(NAME,NHANVIEN_ID) values(N'Suzuki Fx',2);
Insert into XE(NAME,NHANVIEN_ID) values(N'Piagio Vespa 160cc',4);

Insert into SANPHAM(NAME,PRICE,QUANTITY) values(N'Bánh Chocobite',45000,10);
Insert into SANPHAM(NAME,PRICE,QUANTITY) values(N'Kem Đánh Răng PS',26700,50);
Insert into SANPHAM(NAME,PRICE,QUANTITY) values(N'Áo Quần H&M',159000,99);

Select * from NHANVIEN;
Select * from XE;
Select * from SANPHAM;
Select * from NHANVIEN_SANPHAM;