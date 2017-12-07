# springboot 多模块项目(lightning-root)

##模块
- lightning-app:提供闪电花金APP接口
- lightning-common:提供公用组建支持
- lightning-data:数据操作层
- lightning-pojo:提供公共PO、VO、BO、DTO支持
- lightning-service-approve:审核相关服务
- lightning-service-loan:借款相关服务
- lightning-service-rabbitmq:提供消息队列相关服务
- lightning-service-redis:提供Redis缓存相关服务
- lightning-service-sms:短信相关服务
- lightning-service-tongdun:同盾相关服务
- lightning-service-user:用户相关服务
- lightning-service-zhima:芝麻信用相关服务
- lightning-utils:公共工具支持


## 技术集成
- 最佳实践的项目结构、配置文件、精简的POM
- 集成MyBatis、Mybatis plus，实现单表业务零SQL
- 采用高效稳定数据库连接池Druid
- 集成Swagger2(RESTFUL接口的文档在线自动生成+功能测试功能软件)
- 统一异常处理
- 统一响应结果封装及生成工具
- 统一系统业务操作日志处理
- 系统日志采用log4j2
- 系统缓存采用Redis
- 系统消息中间件RabbitMQ
- 定时器采用Spring自带的Schedule

## 快速开始（环境修改）
1. 启动开始前需要根据自身环境情况修改lightning-app中的application.yml数据库连接地址
2. 修改Redis地址信息
3. 修改RabbitMQ地址信息
4. 对开发环境配置文件,采用可读性、简洁性更好的yaml配置<br>
	```application.yml```<br>
	```application-dev.yml```<br>
	```application-test.yml```<br>
	```application-prod.yml```<br>
    进行配置，启动项目！

## 开发建议
- 【创建表】表名建议使用小写，多个单词使用下划线拼接，新表表字段统一采用驼峰式命名，旧表保持原来用户"_"分隔
- 【对象使用】生成的实体对象不可当业务对象使用po,bo,dto,pojo等,Entity内成员变量建议与表字段数量对应，如需扩展成员变量（比如连表查询）建议创建DTO，否则需在扩展的成员变量上加```@Transient```注解
- 【业务代码位置】涉及到非查询操作业务请放业务实现类中
- 【事物使用】在业务层实现类中存在非查询操作请添加相应事务
- 【API数据传递格式】所有API接口请求响应数据都采用JSON格式(除特殊情况)
- 【业务异常处理】建议业务失败直接使用```ServiceException("message")```抛出，由统一异常处理器来封装业务失败的响应结果，比如```throw new ServiceException("该手机号已被注册")```，会直接被封装为```{"code":400,"message":"该手机号已被注册"}```返回，无需自己处理，尽情抛出
- 【公共工具使用】需要工具类的话建议先从```lightning-utils```中找，实在没有再造轮子或引入类库，尽量精简项目
- 【代码规范】开发规范建议遵循阿里巴巴Java开发手册（[最新版下载](https://github.com/lihengming/shared-files/blob/master/%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8Cv1.2.0.pdf))
- 【API文档】建议在公司内部使用[ShowDoc](https://github.com/star7th/showdoc)、[SpringFox-Swagger2](https://github.com/springfox/springfox) 、[RAP](https://github.com/thx/RAP)等开源项目来编写、管理API文档
- 【系统状态码】除HttpStatus所有状态,系统业务状态码从1000开始,不同的业务代码请以100递增（如：1100，1200等）


## 技术选型&文档
- SpringBoot 快速的java开发框架，大大提高程序员的开发效率（[官方文档](http://projects.spring.io/spring-boot/)）
- MyBatis Plus（[官方中文文档](http://baomidou.oschina.io/mybatis-plus-doc/#/)）
- Swagger2 （[项目地址](https://github.com/springfox/springfox)）
- Memcached 免费和开放源代码的高性能分布式内存对象缓存系统 （[官方文档](http://memcached.org/)）
- 通用Mapper（[插件文档说明](https://mapperhelper.github.io/docs/2.use/)）

### 在线小工具
- [在线Cron表达式生成器](http://cron.qqe2.com/ "在线Cron表达式生成器")
- [在线工具-程序员的工具箱](http://tool.lu/ "在线工具 - 程序员的工具箱")
- [spring boot官方脚手架](https://start.spring.io/ "spring boot官方脚手架")



- 项目构成
- 使用技术
- 项目导入
- 代码规范
- 使用演示
- 便捷工具
- 收集意见

