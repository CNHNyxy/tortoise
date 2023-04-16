CREATE TABLE User (
                      UserID INT PRIMARY KEY AUTO_INCREMENT,
                      UserName VARCHAR(50) NOT NULL,
                      Password VARCHAR(50) NOT NULL,
                      Email VARCHAR(50) NOT NULL
) COMMENT='用户表';
ALTER TABLE User MODIFY COLUMN UserID INT COMMENT '用户ID';
ALTER TABLE User MODIFY COLUMN UserName VARCHAR(50) COMMENT '用户名';
ALTER TABLE User MODIFY COLUMN Password VARCHAR(50) COMMENT '密码';
ALTER TABLE User MODIFY COLUMN Email VARCHAR(50) COMMENT '电子邮件地址';


CREATE TABLE AssetCategory (
                               CategoryID INT PRIMARY KEY AUTO_INCREMENT,
                               CategoryName VARCHAR(50) NOT NULL
) COMMENT='资产分类表';
ALTER TABLE AssetCategory MODIFY COLUMN CategoryID INT COMMENT '资产分类ID';
ALTER TABLE AssetCategory MODIFY COLUMN CategoryName VARCHAR(50) COMMENT '资产分类名称';

CREATE TABLE Asset (
                       AssetID INT PRIMARY KEY AUTO_INCREMENT,
                       AssetName VARCHAR(50) NOT NULL,
                       CategoryID INT NOT NULL,
                       Amount DECIMAL(10,2) NOT NULL,
                       Currency VARCHAR(10) NOT NULL,
                       Date DATE NOT NULL,
                       Remarks VARCHAR(255)
) COMMENT='资产表';
ALTER TABLE Asset MODIFY COLUMN AssetID INT COMMENT '资产ID';
ALTER TABLE Asset MODIFY COLUMN AssetName VARCHAR(50) COMMENT '资产名称';
ALTER TABLE Asset MODIFY COLUMN CategoryID INT COMMENT '资产分类ID';
ALTER TABLE Asset MODIFY COLUMN Amount DECIMAL(10,2) COMMENT '资产金额';
ALTER TABLE Asset MODIFY COLUMN Currency VARCHAR(10) COMMENT '货币类型';
ALTER TABLE Asset MODIFY COLUMN Date DATE COMMENT '购买日期';
ALTER TABLE Asset MODIFY COLUMN Remarks VARCHAR(255) COMMENT '备注';

CREATE TABLE Budget (
                        BudgetID INT PRIMARY KEY AUTO_INCREMENT,
                        CategoryID INT NOT NULL,
                        Amount DECIMAL(10,2) NOT NULL,
                        StartDate DATE NOT NULL,
                        EndDate DATE NOT NULL,
                        Remarks VARCHAR(255)
) COMMENT='预算表';
ALTER TABLE Budget MODIFY COLUMN BudgetID INT COMMENT '预算ID';
ALTER TABLE Budget MODIFY COLUMN CategoryID INT COMMENT '资产分类ID';
ALTER TABLE Budget MODIFY COLUMN Amount DECIMAL(10,2) COMMENT '预算金额';
ALTER TABLE Budget MODIFY COLUMN StartDate DATE COMMENT '开始日期';
ALTER TABLE Budget MODIFY COLUMN EndDate DATE COMMENT '结束日期';
ALTER TABLE Budget MODIFY COLUMN Remarks VARCHAR(255) COMMENT '备注';

CREATE TABLE Expense (
                         ExpenseID INT PRIMARY KEY AUTO_INCREMENT,
                         CategoryID INT NOT NULL,
                         Amount DECIMAL(10,2) NOT NULL,
                         Currency VARCHAR(10) NOT NULL,
                         Date DATE NOT NULL,
                         Remarks VARCHAR(255)
) COMMENT='支出表';
ALTER TABLE Expense MODIFY COLUMN ExpenseID INT COMMENT '支出ID';
ALTER TABLE Expense MODIFY COLUMN CategoryID INT COMMENT '资产分类ID';
ALTER TABLE Expense MODIFY COLUMN Amount DECIMAL(10,2) COMMENT '支出金额';
ALTER TABLE Expense MODIFY COLUMN Currency VARCHAR(10) COMMENT '货币类型';
ALTER TABLE Expense MODIFY COLUMN Date DATE COMMENT '支出日期';
ALTER TABLE Expense MODIFY COLUMN Remarks VARCHAR(255) COMMENT '备注';

CREATE TABLE InvestmentAdvice (
                                  InvestmentAdviceID INT PRIMARY KEY AUTO_INCREMENT,
                                  InvestmentType VARCHAR(50) NOT NULL,
                                  Description VARCHAR(255) NOT NULL
) COMMENT='投资建议表';
ALTER TABLE InvestmentAdvice MODIFY COLUMN InvestmentAdviceID INT COMMENT '投资建议';
