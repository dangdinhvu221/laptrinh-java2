﻿CREATE DATABASE QLSV1
GO

USE QLSV1
GO

CREATE TABLE USERS(
	username NVARCHAR(50) NOT NULL,
	password NVARCHAR(50) NOT NULL,
	role NVARCHAR(50) NOT NULL,

	CONSTRAINT PK_USER PRIMARY KEY(username)
)
GO

CREATE TABLE STUDENTS(
	MaSV NVARCHAR(25) NOT NULL,
	HoTen NVARCHAR(50) NOT NULL,
	Email NVARCHAR(100) NOT NULL,
	SoDT NVARCHAR(11) NOT NULL,
	GioiTinh NVARCHAR(5) NOT NULL,
	DiaChi NVARCHAR(200) NOT NULL,
	Images NVARCHAR(100) NOT NULL,

	CONSTRAINT PK_STUDENTS PRIMARY KEY(MaSV)
)
GO

CREATE TABLE GRADE(
	ID INT IDENTITY(1,1) NOT NULL,
	MaSV NVARCHAR(25) NOT NULL,
	TiengAnh FLOAT NOT NULL,
	TinHoc FLOAT NOT NULL,
	GDTC FLOAT NOT NULL,

	CONSTRAINT PK_GRADE PRIMARY KEY(ID),
	CONSTRAINT FK_GRADE_STUDENTS FOREIGN KEY(MaSV) REFERENCES STUDENTS(MaSV)
)

INSERT INTO USERS
VALUES('hainam4536','1234567','GV'),
('thinhsuy', '88888888', 'CTSV')
GO

INSERT INTO STUDENTS
VALUES('SV001', N'Hoàng Xuân Hải', 'haihxph12231@fpt.edu.vn', '0975395955', N'Nam', N'Ngõ 59 Mễ Trì Hạ, Nam Từ Liêm, Hà Nội', 'C:\Users\ADMIN\tailieu\Agile\Agile\Images\balenciagaBlack.jpg')
INSERT INTO STUDENTS
VALUES('SV002', N'Lê Thu Thảo', 'thaoltph23231@fpt.edu.vn', '0868195314', N'Nữ', N'Ngõ 59 Xuân Phương, Nam Từ Liêm, Hà Nội', 'C:\Users\ADMIN\tailieu\Agile\Agile\Images\balenciagaPink.jpg')
INSERT INTO STUDENTS
VALUES('SV003', N'Quân Anh Hào', 'haoqaph12212@fpt.edu.vn', '0975483845', N'Nam', N'Ngõ 123 Quan Hoa, Cầu Giấy, Hà Nội', 'C:\Users\ADMIN\tailieu\Agile\Agile\Images\balenciagaGreen.jpg')
INSERT INTO STUDENTS
VALUES('SV004', N'Lê Hồng Tiến', 'tienlhph122222@fpt.edu.vn', '0954656435', N'Nam', N'Ngõ 89 Mễ tri thượng, Nam Từ Liêm, Hà Nội', 'C:\Users\ADMIN\tailieu\Agile\Agile\Images\balenciagaTripSOfBlack.jpg')

select * from STUDENTS
--DELETE FROM STUDENTS
--WHERE MaSV = 'SV002'

--INSERT INTO GRADE
--VALUES('SV001', 8, 8, 9),
--('SV002', 9, 9, 9),
--('SV003', 8, 8, 8),
--('SV004', 8, 7, 7)
--SELECT * FROM STUDENTS
--INNER JOIN GRADE ON GRADE.MaSV = STUDENTS.MaSV
--WHERE GRADE.MaSV = 'SV001'
--SELECT * FROM GRADE LIMIT 3
--WHERE username = 'quangkhai2308' s

--SELECT TOP 3 ID, GRADE.MaSV, TiengAnh, TinHoc, GDTC FROM GRADE INNER JOIN STUDENTS ON STUDENTS.MaSV = GRADE.MaSV
--WHERE STUDENTS.MaSV = 'SV002'
--GROUP BY ID, GRADE.MaSV, TiengAnh, TinHoc, GDTC 
--ORDER BY AVG(TiengAnh + TinHoc + GDTC) DESC

--SELECT ID, GRADE.MaSV, TiengAnh, TinHoc, GDTC FROM GRADE INNER JOIN STUDENTS ON STUDENTS.MaSV = GRADE.MaSV
--WHERE STUDENTS.MaSV = 'SV002'