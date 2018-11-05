DROP TABLE STUDENT;
CREATE TABLE STUDENT(
	SNO VARCHAR2(20),
	SNAME VARCHAR2(20),
	SSEX VARCHAR2(20),
	SAGE INT,
	SDEPT VARCHAR2(20),
	CNO VARCHAR2(20),
	GRADE INT,
	PRIMARY KEY(SNO,CNO)
);

INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'CS', '1', 92);
INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'CS', '2', 85);
INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'CS', '3', 88);
INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'CS', '4', 92);
INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'CS', '5', 85);
INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'CS', '6', 88);
INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'CS', '7', 92);
INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'BS', '8', 85);
INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'BS', '9', 88);
INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'BS', '10', 92);
INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'BS', '11', 85);
INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'BS', '12', 88);
INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'BS', '13', 92);
INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'BS', '14', 85);
INSERT INTO STUDENT VALUES('201215121', '李勇', '男', 20, 'BS', '15', 88);
INSERT INTO STUDENT VALUES('201215122', '刘晨', '女', 19, 'BS', '1', 90);
INSERT INTO STUDENT VALUES('201215122', '刘晨', '女', 19, 'BS', '2', 80);
INSERT INTO STUDENT VALUES('201215122', '刘晨', '女', 19, 'BS', '3', 90);
INSERT INTO STUDENT VALUES('201215122', '刘晨', '女', 19, 'BS', '4', 80);
INSERT INTO STUDENT VALUES('201215122', '刘晨', '女', 19, 'BS', '5', 90);
INSERT INTO STUDENT VALUES('201215122', '刘晨', '女', 19, 'BS', '6', 80);
INSERT INTO STUDENT VALUES('201215122', '刘晨', '女', 19, 'CS', '7', 90);
INSERT INTO STUDENT VALUES('201215122', '刘晨', '女', 19, 'CS', '8', 80);
INSERT INTO STUDENT VALUES('201215122', '刘晨', '女', 19, 'CS', '9', 90);
INSERT INTO STUDENT VALUES('201215122', '刘晨', '女', 19, 'CS', '10', 80);
INSERT INTO STUDENT VALUES('201215122', '刘晨', '女', 19, 'CS', '11', 90);
INSERT INTO STUDENT VALUES('201215122', '刘晨', '女', 19, 'CS', '12', 80);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'MA', '1', 85);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'MA', '2', 97);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'MA', '3', 85);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'MA', '4', 97);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'MA', '5', 85);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'MA', '6', 97);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'MA', '7', 85);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'MA', '8', 97);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'IS', '9', 85);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'IS', '10', 97);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'IS', '11', 85);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'IS', '12', 97);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'IS', '13', 85);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'IS', '14', 97);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'IS', '15', 85);
INSERT INTO STUDENT VALUES('201215123', '王敏', '女', 18, 'IS', '16', 97);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'IS', '1', 89);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'IS', '2', 68);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'IS', '3', 89);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'IS', '4', 68);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'IS', '5', 89);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'IS', '6', 68);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'IS', '7', 89);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'IS', '8', 68);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'IS', '9', 89);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'CS', '10', 68);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'CS', '11', 89);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'CS', '12', 68);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'CS', '13', 89);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'CS', '14', 68);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'CS', '15', 89);
INSERT INTO STUDENT VALUES('201215125', '张立', '男', 19, 'CS', '16', 68);