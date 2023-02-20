# DepartmentManagement

Creating DepartmentManagement RestAPI using springboot 3 , JPA and Swagger

Database configuration

CREATE DATABASE `employeemanagement`

CREATE TABLE `department` (
  `ID` int(11) NOT NULL,
  `deptname` varchar(255) NOT NULL,
  `depttype` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
)


Adding Junit + Mockito test cases for the Application
