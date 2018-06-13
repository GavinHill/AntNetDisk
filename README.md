### 项目说明（project description）
基于JSP + Servlet + c3p0的简单网盘  
Simple NetDisk based on JSP + Servlet + c3p0
### 运行环境
1. 配置JDK版本1.8
2. 配置Maven版本3.5.2
3. 配置Tomcat版本7.0.52
4. 配置MySQL 账号root 密码admin
5.其余JRE包无需导入，Maven将自动联网下载

注：若运行环境非上述设定请在项目中的pom.xml中进行修改；数据库账号密码非上述设定请在c3p0-config.xml中进行修改
### 项目启动
1. 打开Eclipse，File->Import->Existing Maven Projects->Next->Browse->选择本项目
2. 右键该项目，Run as->maven build，无报错信息即为启动项目（请于有网络连接时启动，以便Maven自动配置JRE包）
3. 请使用谷歌浏览器访问：http://localhost:8080/AntNetDisk/index.js