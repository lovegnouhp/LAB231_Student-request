USE [master]
GO
/****** Object:  Database [J3.L.P0010_Student-request-admin]    Script Date: 07/21/2021 10:26:15 ******/
CREATE DATABASE [J3.L.P0010_Student-request-admin] ON  PRIMARY 
( NAME = N'J3.L.P0010_Student-request-admin', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\J3.L.P0010_Student-request-admin.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'J3.L.P0010_Student-request-admin_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\J3.L.P0010_Student-request-admin_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [J3.L.P0010_Student-request-admin].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET ANSI_NULLS OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET ANSI_PADDING OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET ARITHABORT OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET  DISABLE_BROKER
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET  READ_WRITE
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET RECOVERY SIMPLE
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET  MULTI_USER
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [J3.L.P0010_Student-request-admin] SET DB_CHAINING OFF
GO
USE [J3.L.P0010_Student-request-admin]
GO
/****** Object:  Table [dbo].[Department]    Script Date: 07/21/2021 10:26:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Department] ON
INSERT [dbo].[Department] ([ID], [Name]) VALUES (1, N'Academic Department')
INSERT [dbo].[Department] ([ID], [Name]) VALUES (2, N'Student Relation Office')
INSERT [dbo].[Department] ([ID], [Name]) VALUES (3, N'Student Service Office')
INSERT [dbo].[Department] ([ID], [Name]) VALUES (4, N'Organization and Administration Department')
INSERT [dbo].[Department] ([ID], [Name]) VALUES (5, N'Information Technology Room')
INSERT [dbo].[Department] ([ID], [Name]) VALUES (6, N'Financial Department')
INSERT [dbo].[Department] ([ID], [Name]) VALUES (7, N'Examination Office')
SET IDENTITY_INSERT [dbo].[Department] OFF
/****** Object:  Table [dbo].[Account]    Script Date: 07/21/2021 10:26:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[Username] [nvarchar](100) NOT NULL,
	[Password] [nvarchar](100) NOT NULL,
	[Name] [nvarchar](10) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([Username], [Password], [Name]) VALUES (N'admin', N'admin', N'Admin')
INSERT [dbo].[Account] ([Username], [Password], [Name]) VALUES (N'DuyDT', N'123', N'Duy')
INSERT [dbo].[Account] ([Username], [Password], [Name]) VALUES (N'phuong', N'123', N'Phuong')
/****** Object:  Table [dbo].[Student]    Script Date: 07/21/2021 10:26:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Student](
	[ID] [varchar](8) NOT NULL,
	[Name] [varchar](100) NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Student] ([ID], [Name]) VALUES (N'HA123456', N'Nguyen Van A')
INSERT [dbo].[Student] ([ID], [Name]) VALUES (N'HE140784', N'Ngo Van Phuong')
INSERT [dbo].[Student] ([ID], [Name]) VALUES (N'SE0000', N'Dao Trong Duy')
INSERT [dbo].[Student] ([ID], [Name]) VALUES (N'SE066666', N'Nguyen Van B')
/****** Object:  Table [dbo].[Request]    Script Date: 07/21/2021 10:26:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Request](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[DepartmentID] [int] NOT NULL,
	[StudentID] [varchar](8) NOT NULL,
	[DateCreated] [date] NOT NULL,
	[Title] [nvarchar](150) NOT NULL,
	[Content] [nvarchar](300) NOT NULL,
	[State] [int] NOT NULL,
	[CloseDate] [date] NULL,
	[SolvedBy] [nvarchar](100) NULL,
	[AttachedURL] [nvarchar](200) NULL,
	[Solution] [nvarchar](300) NULL,
 CONSTRAINT [PK_Request] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Request] ON
INSERT [dbo].[Request] ([ID], [DepartmentID], [StudentID], [DateCreated], [Title], [Content], [State], [CloseDate], [SolvedBy], [AttachedURL], [Solution]) VALUES (1, 1, N'SE0000', CAST(0x453B0B00 AS Date), N'inquery for PE result', N'In query for the result of PRJ321-PE (1st time). I wanna check my solution again', -1, NULL, NULL, NULL, NULL)
INSERT [dbo].[Request] ([ID], [DepartmentID], [StudentID], [DateCreated], [Title], [Content], [State], [CloseDate], [SolvedBy], [AttachedURL], [Solution]) VALUES (2, 4, N'HE140784', CAST(0xA73F0B00 AS Date), N'request to change class', N'I wanna change my class Thunderbolt 23 (slot 4) to Thunderbolt 4 (slot 1).', 0, CAST(0xA93F0B00 AS Date), N'admin', NULL, N'Nhà trường không đồng ý.')
INSERT [dbo].[Request] ([ID], [DepartmentID], [StudentID], [DateCreated], [Title], [Content], [State], [CloseDate], [SolvedBy], [AttachedURL], [Solution]) VALUES (5, 7, N'HE140784', CAST(0x6E410B00 AS Date), N'Don dang ki thi cai thien diem', N'Em muon dang ki thi cai thien diem mon PRO192 a, em xin cam on thay/co.', -1, NULL, NULL, NULL, NULL)
INSERT [dbo].[Request] ([ID], [DepartmentID], [StudentID], [DateCreated], [Title], [Content], [State], [CloseDate], [SolvedBy], [AttachedURL], [Solution]) VALUES (8, 7, N'HE140784', CAST(0xAA410B00 AS Date), N'Don dang ki thi cai thien diem', N'Em xin phep thay/ co cho em duoc thi cai thien mon WED201c ca hai phan thi TE va PE a. Em xin cam on.', -1, NULL, NULL, N'/files/don dang ki thi cai thien WED201c.doc', NULL)
INSERT [dbo].[Request] ([ID], [DepartmentID], [StudentID], [DateCreated], [Title], [Content], [State], [CloseDate], [SolvedBy], [AttachedURL], [Solution]) VALUES (10, 7, N'HE140784', CAST(0x7B420B00 AS Date), N'Don dang ki thi cai thien diem', N'Em xin phep thay/ co cho em duoc thi cai thien mon PRJ321 a. Em xin cam on.', -1, NULL, NULL, NULL, NULL)
INSERT [dbo].[Request] ([ID], [DepartmentID], [StudentID], [DateCreated], [Title], [Content], [State], [CloseDate], [SolvedBy], [AttachedURL], [Solution]) VALUES (11, 7, N'HE140784', CAST(0x82420B00 AS Date), N'Don dang ki thi tham dinh mon online', N'Em xin phep thay/ co cho em dang ki thi tham dinh mon NWC203c do dot thi vua roi em chua du dieu kien qua mon a.', -1, NULL, NULL, N'/files/dang-ky-thi-lan-3-NWC203c.doc', NULL)
INSERT [dbo].[Request] ([ID], [DepartmentID], [StudentID], [DateCreated], [Title], [Content], [State], [CloseDate], [SolvedBy], [AttachedURL], [Solution]) VALUES (12, 4, N'HE140784', CAST(0xBB3F0B00 AS Date), N'Don xin tam dung hoc song song', N'Em khong muon hoc song song tieng anh TRS6 cung chuyen nganh trong ki toi a. Em cam on.', -1, NULL, NULL, NULL, NULL)
INSERT [dbo].[Request] ([ID], [DepartmentID], [StudentID], [DateCreated], [Title], [Content], [State], [CloseDate], [SolvedBy], [AttachedURL], [Solution]) VALUES (14, 4, N'HA123456', CAST(0xC1420B00 AS Date), N'Don xin tam dung hoc song song', N'Em khong muon hoc song song tieng anh TRS6 cung chuyen nganh trong ki toi a. Em cam on.', -1, NULL, NULL, NULL, NULL)
INSERT [dbo].[Request] ([ID], [DepartmentID], [StudentID], [DateCreated], [Title], [Content], [State], [CloseDate], [SolvedBy], [AttachedURL], [Solution]) VALUES (16, 5, N'HE140784', CAST(0xC1420B00 AS Date), N'Don xin dang ki lai dia chi MAC laptop', N'Em xin phep duoc cap nhat lai dia chi MAC dang ki voi nha truong do em moi doi laptop khac a. Em cam on.', 0, CAST(0xC2420B00 AS Date), N'admin', NULL, N'Nha truong dong y.')
INSERT [dbo].[Request] ([ID], [DepartmentID], [StudentID], [DateCreated], [Title], [Content], [State], [CloseDate], [SolvedBy], [AttachedURL], [Solution]) VALUES (18, 5, N'SE066666', CAST(0xC2420B00 AS Date), N'Don dang ki thi tham dinh mon online', N'Em xin phep thay/ co cho em dang ki thi tham dinh mon NWC203c do dot thi vua roi em chua du dieu kien qua mon a.', 1, CAST(0xC1420B00 AS Date), N'admin', N'/files/dang-ky-thi-lan-3-NWC203c.doc', N'Nha truong dong y.')
INSERT [dbo].[Request] ([ID], [DepartmentID], [StudentID], [DateCreated], [Title], [Content], [State], [CloseDate], [SolvedBy], [AttachedURL], [Solution]) VALUES (21, 1, N'HA123456', CAST(0xC2420B00 AS Date), N'inquery for PE result', N'In query for the result of PRN292-PE (1st time). I wanna check my solution again', -1, NULL, NULL, NULL, NULL)
INSERT [dbo].[Request] ([ID], [DepartmentID], [StudentID], [DateCreated], [Title], [Content], [State], [CloseDate], [SolvedBy], [AttachedURL], [Solution]) VALUES (22, 6, N'HE140784', CAST(0xC2420B00 AS Date), N'Don xin rut tien du tai khoan FAP', N'Em hien khong co nhu cau su dung so du tai khoan tren FAP, em muon tien ve a.', -1, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Request] OFF
/****** Object:  ForeignKey [FK_Request_Account]    Script Date: 07/21/2021 10:26:16 ******/
ALTER TABLE [dbo].[Request]  WITH CHECK ADD  CONSTRAINT [FK_Request_Account] FOREIGN KEY([SolvedBy])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Request] CHECK CONSTRAINT [FK_Request_Account]
GO
/****** Object:  ForeignKey [FK_Request_Department]    Script Date: 07/21/2021 10:26:16 ******/
ALTER TABLE [dbo].[Request]  WITH CHECK ADD  CONSTRAINT [FK_Request_Department] FOREIGN KEY([DepartmentID])
REFERENCES [dbo].[Department] ([ID])
GO
ALTER TABLE [dbo].[Request] CHECK CONSTRAINT [FK_Request_Department]
GO
/****** Object:  ForeignKey [FK_Request_Student]    Script Date: 07/21/2021 10:26:16 ******/
ALTER TABLE [dbo].[Request]  WITH CHECK ADD  CONSTRAINT [FK_Request_Student] FOREIGN KEY([StudentID])
REFERENCES [dbo].[Student] ([ID])
GO
ALTER TABLE [dbo].[Request] CHECK CONSTRAINT [FK_Request_Student]
GO
