
DROP DATABASE IF EXISTS QUANLYTHITOTNGHIEP;
CREATE DATABASE QUANLYTHITOTNGHIEP;

USE QUANLYTHITOTNGHIEP;


CREATE TABLE TRUONG (
	MATRG CHAR(3) NOT NULL UNIQUE,
	TENTRUONG VARCHAR(30),
    
	CONSTRAINT TRUONG_PK PRIMARY KEY(MATRG)
);

CREATE TABLE THISINH (
	SOBD CHAR(5), 
	HOTEN VARCHAR(50), 
	NGAYSINH DATE, 
	NOISINH VARCHAR(20),
	MATRG CHAR(3),
    
    CONSTRAINT THISINH_PK PRIMARY KEY(SOBD),
    CONSTRAINT THISINH_MATRG_FK FOREIGN KEY(MATRG) REFERENCES TRUONG(MATRG)
    
);

CREATE TABLE MONTHI(
	MAMT CHAR(2),
    TENMT VARCHAR(20),
    
    CONSTRAINT MONTHI_PK PRIMARY KEY(MAMT)
);

CREATE TABLE KETQUA(
	SOBD CHAR(5),
    MAMT CHAR(2),
    DIEMTHI FLOAT,
    GHICHU VARCHAR(20),
    
    CONSTRAINT KETQUA_PK PRIMARY KEY(SOBD,MAMT),
    CONSTRAINT KETQUA_SOBD_FK FOREIGN KEY(SOBD) REFERENCES THISINH(SOBD),
    CONSTRAINT KETQUA_MAMT_FK FOREIGN KEY(MAMT) REFERENCES MONTHI(MAMT)
    
);



# THÊM DỮ LIỆU VÀO BẢNG TRUONG
INSERT INTO TRUONG VALUES ('016','Lê Hồng Phong');
INSERT INTO TRUONG VALUES ('017','Nguyễn Thị Minh Khai');
INSERT INTO TRUONG VALUES ('018','Nguyễn Khuyến');
INSERT INTO TRUONG VALUES ('019','Nguyễn Thị Một');


# THÊM DỮ LIỆU VÀO BẢNG THISINH
INSERT INTO THISINH VALUES('19101', 'Nguyễn Lan Anh', '2005-02-16','HCM','016');
INSERT INTO THISINH VALUES('19102', 'Lê Hoài Thương', '2005-04-21','HCM','016');
INSERT INTO THISINH VALUES('19103', 'Nguyễn Trung Hiếu', '2005-06-08','HCM','017');
INSERT INTO THISINH VALUES('19104', 'Phạm Minh Chính', '2005-07-11','Long An','018');
INSERT INTO THISINH VALUES('19105', 'Lê Phước Hậu', '2005-11-29','Long An','018');
INSERT INTO THISINH VALUES('19106', 'Bùi Thị Trọng', '2005-12-14','Cần Thơ','019');
	


# THÊM DỮ LIỆU VÀO BẢNG MONTHI
INSERT INTO MONTHI VALUES ('DL','Địa lý');
INSERT INTO MONTHI VALUES ('HH','Hóa học');
INSERT INTO MONTHI VALUES ('VL','Vật lý');
INSERT INTO MONTHI VALUES ('NN','Ngoại ngữ');
INSERT INTO MONTHI VALUES ('SH','Sinh học');
INSERT INTO MONTHI VALUES ('LS','Lịch sử');
INSERT INTO MONTHI VALUES ('TH','Toán học');
INSERT INTO MONTHI VALUES ('VH','Văn học');



# THÊM DỮ LIỆU VÀO BẢNG KETQUA
INSERT INTO KETQUA VALUES ('19101','DL',5,'');
INSERT INTO KETQUA VALUES ('19101','HH',5,'');	
INSERT INTO KETQUA VALUES ('19101','VL',5,'');
INSERT INTO KETQUA VALUES ('19101','LS',5,'');
INSERT INTO KETQUA VALUES ('19101','TH',5,'');
INSERT INTO KETQUA VALUES ('19101','VH',5,'');
INSERT INTO KETQUA VALUES ('19102','DL',8,'');
INSERT INTO KETQUA VALUES ('19102','HH',8,'');	
INSERT INTO KETQUA VALUES ('19102','VL',8,'');
INSERT INTO KETQUA VALUES ('19102','LS',8,'');
INSERT INTO KETQUA VALUES ('19102','TH',8,'');
INSERT INTO KETQUA VALUES ('19102','VH',9,'');
INSERT INTO KETQUA VALUES ('19103','DL',0,'VT');
INSERT INTO KETQUA VALUES ('19103','HH',0,'VT');	
INSERT INTO KETQUA VALUES ('19103','VL',0,'VT');
INSERT INTO KETQUA VALUES ('19103','LS',0,'VT');
INSERT INTO KETQUA VALUES ('19103','TH',0,'VT');
INSERT INTO KETQUA VALUES ('19103','VH',0,'VT');
INSERT INTO KETQUA VALUES ('19104','DL',9,'');
INSERT INTO KETQUA VALUES ('19104','HH',7,'');	
INSERT INTO KETQUA VALUES ('19104','VL',7,'');
INSERT INTO KETQUA VALUES ('19104','LS',9,'');
INSERT INTO KETQUA VALUES ('19104','TH',9,'');
INSERT INTO KETQUA VALUES ('19104','VH',9,'');
INSERT INTO KETQUA VALUES ('19105','DL',5,'VT');
INSERT INTO KETQUA VALUES ('19105','HH',1,'');	
INSERT INTO KETQUA VALUES ('19105','VL',2,'');
INSERT INTO KETQUA VALUES ('19105','LS',5,'');
INSERT INTO KETQUA VALUES ('19105','TH',0,'');
INSERT INTO KETQUA VALUES ('19105','VH',6,'');
INSERT INTO KETQUA VALUES ('19106','DL',0,'VT');
INSERT INTO KETQUA VALUES ('19106','HH',10,'');	
INSERT INTO KETQUA VALUES ('19106','VL',10,'');
INSERT INTO KETQUA VALUES ('19106','LS',10,'');
INSERT INTO KETQUA VALUES ('19106','TH',10,'');
INSERT INTO KETQUA VALUES ('19106','VH',10,'');


#....




