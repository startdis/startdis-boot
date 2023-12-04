<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">Startdis Boot</h1>
<h4 align="center">基于Spring Boot 单体微服务架构</h4>

## 平台简介

Startdis Boot (启迪) 是一款企业级单体架构的开发平台，是采用领域驱动模型(DDD)设计思想的、遵循SpringBoot 编程思想，高度模块化和可配置化。 基于[Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0)协议，毫无保留给个人及企业免费使用，由[江苏点九科技有限公司](https://dianjiu.cc)提供技术支持。

## 相关链接
### 项目源码
Gitee：https://gitee.com/startdis/sdt-cms  
Github：https://github.com/startdis/sdt-cms  
Gitlab：https://gitlab.com/startdis/sdt-cms

### 关于启迪
启迪平台：https://startdis.com

项目文档：https://startdis.com/docs/cms

体验地址：https://cms.startdis.top
- startdis/startdis2022

## 系统架构（）

<img src=""/>

## 功能菜单
~~~
Startdis Boot    
├── 欢迎页：（已完成）                                                
├── 集团管理（已完成）                                                  
│       └── 公司管理：配置集团公司结构，树结构展现集团及子公司数据
│       └── 部门管理：配置公司组织结构，树结构展现部门、小组数据
│       └── 岗位管理：配置公司岗位职责，一键分配公司员工所担任的职务
├── 权限管理（已完成）                                                  
│       └── 用户管理：配置公司人员信息，扁平化展示员工信息及归属（部门、岗位、角色）
│       └── 角色管理：配置公司角色信息，一键分配角色的数据范围、菜单权限、用户角色
│       └── 菜单管理：配置公司菜单信息，一键分配菜单权限、操作权限、按钮权限、角色菜单
├── 权限管理（已完成）                                                  
│       └── 用户管理：配置公司人员信息，扁平化展示员工信息及归属（部门、岗位、角色）
│       └── 角色管理：配置公司角色信息，一键分配角色的数据范围、菜单权限、用户角色
│       └── 菜单管理：配置公司菜单信息，一键分配菜单权限、操作权限、按钮权限、角色菜单
├── 系统管理（已完成）                                                  
│       └── 公告设置：配置公司公告信息，先审核后发布，公司后台实时全员推送
│       └── 敏感过滤：配置公司敏感词，全局过滤拦截员工危险言论
│       └── 全局变量：配置公司全局信息，动态配置公司的主题色、公司logo等新信息
│       └── 字典管理：配置公司字典信息，对系统中经常使用的一些较为固定的数据进行维护
│       └── 文件管理：配置公司文件仓库，支持文件上传、下载、复制、分享、删除、图列切换
├── 系统日志（已完成）                                                  
│       └── 登陆日志：记录人员登陆日志，支持员工登陆日志的查询和统计分析（开发中）
│       └── 操作日志：配置公司角色信息，一键分配角色的数据范围、菜单权限、用户角色（开发中）
├── 系统监控（开发中）                                                  
│       └── 在线用户：实时展示公司在线人数，登陆设备、IP等信息
│       └── 服务监控：监控当前系统服务器运行状态（硬盘、内存、CPU等）
│       └── 数据监控：监控当前系统关系数据库运行状态（硬盘、内存、CPU等）
│       └── 缓存监控：监控当前系统缓存数据库运行状态（硬盘、内存、CPU等）
~~~

## 系统模块

~~~
startdis-boot     
├── docker                                        // 容器部署
├── docs                                          // 说明文档
│   └── drawio                                    // 流程图设计
│   └── pdman                                     // 数据库设计
│   └── sqls                                      // 数据库脚本
│   └── envs                                      // 多环境配置
├── startdis-api                                  // 服务间门面接口模块
├── startdis-app                                  // H5、小程序、App等C端门面接口模块 [18082]
├── startdis-comm                                 // 通用模块(领域模型、异常模块、工具类等)
├── startdis-domain                               // 领域实体模块，包含实体、值对象、聚合、事件等
├── startdis-infra                                // 领域基础设施模块，包含持久化
├── startdis-gen                                  // 基础数据代码生成模块
├── startdis-job                                  // 分布式任务实现模块
├── startdis-server                               // 业务服务实现模块
├── startdis-web                                  // B端门户接口模块 [18081]
├── pom.xml                                       // 公共依赖
~~~

