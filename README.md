# BNUCourseCommunity
课程评价社区对外服务的源码  
---  
  
## 日志
日期|时间|事件  
---|:--:|:--:  
2020.03.23|11：11|创建此仓库  
2020.03.23|13：41|六大实体建设完毕  
  
## 备注  
1.DBScripts：用于存放数据库脚本  
2.resource：用于存放前端文件，其中template存HTML；static存图片、JS、CSS等文件
3.嘤运行CourseCommunityApplication就可以自动建表，但是外键写成自动的好麻烦啊，所以存在DBScripts里了，需自动建表完毕后跑一趟foreignKey.sql就可以了  
4.点赞和踩的实体还没建，因为要求用户只能点赞一次，需要另建表，下次建  
