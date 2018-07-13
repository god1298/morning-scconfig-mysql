create table mn_config_info
(
  id             BIGINT(19) auto_increment
    primary key,
  app_name       VARCHAR(30) default ''       not null
  comment '应用名称',
  config_key     VARCHAR(100) default ''      not null
  comment '配置key',
  config_value   VARCHAR(1500)                not null
  comment '配置value',
  config_profile VARCHAR(20) default ''       null
  comment '配置属性',
  config_label   VARCHAR(20) default ''       null
  comment '配置标签标识环境',
  remark         VARCHAR(200) default ''      not null
  comment '备注',
  gmt_created    DATETIME(19)                 null
  comment '创建时间',
  gmt_modified   DATETIME(19)                 null
  comment '修改时间',
  creator        VARCHAR(30) default 'SYSTEM' not null
  comment '创建人',
  modifier       VARCHAR(30) default 'SYSTEM' not null
  comment '修改人',
  is_deleted     TINYINT(3) default 0         null
  comment '是否删除0未删 1删除'
);