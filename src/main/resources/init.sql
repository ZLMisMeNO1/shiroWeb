
-- 如果使用的是mysql 注意中文乱码问题。
-- 项目运行前，创建数据库
drop database if exists shiro;
create database shiro;

--项目运行后
select * from t_user;
-- 添加用户 admin 密码 123
insert into t_user(userId,username,password,salt) values ('8a8a9c4160a0552b0160a05543a90000','admin','6bd359c51b87c1dc99ae67b6aafd467b','b6c4a53524d6715892459f1ef17c1c3a') ;

-- 添加角色
insert into t_role(roleId,createUsername,descMsg,roleName) values('9a8a9c4160a0552b0160a05543a90000','admin','系统管理员，系统拥有者','administrator');

-- 为admin添加角色
insert into t_user_roles(id,descMsg,roleId,sortNumber,userId) values ('1a8a9c4160a0552b0160a05543a90000','系统管理员，系统拥有者','9a8a9c4160a0552b0160a05543a90000',1,'8a8a9c4160a0552b0160a05543a90000');

update t_role set currentStatus=0

-- 添加权限
insert into t_permission(permsId,descMsg,permission) values ('2a8a9c4160a0552b0160a05543a90000','权限-测试权限','/system/test');
delete from t_permission where permission='/system/test';
-- 为角色添加权限
insert into t_role_perms(id,descMsg,permsId,roleId,sortNumber) values ('3a8a9c4160a0552b0160a05543a90000','角色-权限-测试权限','2a8a9c4160a0552b0160a05543a90000','9a8a9c4160a0552b0160a05543a90000',1);