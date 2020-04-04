# BNUCourseCommunity API 约定      
## 1. 主模块   
*  /login：登录   
>GET   获取登录界面   
>POST  登录（跳转到index）   
>>username：学号（嘤这个确实故意名字内容对应不上）   
>>password：密码   
>>remenber-me：是否记住我   
*  /logout：登出   
>GET 登出（跳转到/login）   
*  /index：首页   
>GET：获取页面   
*  /register：注册   
>GET：获取页面   
>POST：注册（跳转到/login）   
>>username：用户昵称   
>>account：学号   
>>password：密码   
orgId：学院   
*  /active：激活账号   
>GET：激活账号，并跳转到/login   
>>account：账号   
>>code：激活码   
*  /checkAccount：检测账号是否已被注册   
>GET：检测，返回JSON数据   
>>account：学号   
>>返回数据示例(status=200)：
```   
{   
    "success": true,   
    "message": "恭喜您！该账号可以使用！",   
    "body": null   
}   
{   
    "success": false,   
    "message": "该账号已被注册!",   
    "body": null   
}   
```
## 2. 用户空间模块（有且仅有当前用户有权访问） /userSpace   
*  / >GET 获取用户空间首页   
*  /{account}/profile：用户信息（account是学号，如/201711260105/profile）   
>GET 获取用户个人信息页   
>POST 修改个人信息（将刷新页面）   
>>username：用户昵称   
>>orgId：   学院ID   
>>password：密码   
*  /{account}/avatar：用户头像（存入头像连的是另一个服务器QAQ，过程有点难以描述，这部分JS到时候留给后端写叭）   
>GET 获取用户头像地址   
>POST 修改用户头像（将刷新页面）   
>>avatar：头像地址   
*  /favor：查看与管理关注的课程   
>GET 获取页面   
>DELETE 取消关注（将刷新页面）   
>>courseId：课程ID   
*  /{account}/evaluation：我的评价   
>GET：获取页面   
>>pageSize：每页显示多少个结果   
>>pa>GETh：页码   
*  /{account}/comment：我的消息：我的评论、回复啥的   
>GET：获取页面   
>>pageSize：每页显示多少个结果   
>>pageth：页码   
## 3. 课程管理模块 /course   
*  /search：模糊查询   
>GET 获取结果页   
>>keyword：关键词（不可为空）   
*  /adSearch：精确查询   
>GET 获取结果页（无参数则显示空的高级检索页面）   
>>courseName：   
>>teacherName：   
*  /{courseId}/detail：课程详细信息（courseId是详细信息）   
*  /{courseId}/favor：关注该课程   
>POST：关注（自动刷新本页）   
这个部分API设计不全，等数据来了咱们再商量   
## 4. 管理员模块（这个备用模块，有时间再完善，有且仅有管理员有权访问）/admin   
### 管理用户/user   
### 管理课程/course   
### 管理评价/evaluation   
### 管理评论/course   
### 统计信息可视化/data   

