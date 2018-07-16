使用说明：
1、执行server sql/ddl.sql创建表
2、更改server bootstrap.yml的mysql配置


纯配置写法：
1、server端的bootstrap.yml 改成如下
server:
  port: 8080
spring:
  application:
    name: morningweb
  profiles:
    active: jdbc
  cloud:
    config:
      server:
        default-label: master
        jdbc:
          sql: SELECT CONFIG_KEY, CONFIG_VALUE FROM MN_CONFIG_INFO WHERE APP_NAME=? AND CONFIG_PROFILE=? and CONFIG_LABEL=?
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://ip:port/db
    username: test
    password: test

2、注释类 DbEnvironmentRepository。
