CREATE TABLE `t_log_error` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `log_no` varchar(36) DEFAULT NULL COMMENT '日志编号，程序自动生成',
  `business_no` varchar(45) DEFAULT NULL COMMENT '业务编号',
  `business_name` varchar(45) DEFAULT NULL COMMENT '项目名称+业务名称',
  `log_level` int(11) DEFAULT NULL COMMENT '日志等级',
  `log_info` text COMMENT '错误日志信息',
  `request_ip` varchar(45) DEFAULT NULL COMMENT '请求ip地址 ',
  `request_param` varchar(10000) DEFAULT NULL COMMENT '请求参数',
  `request_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '请求时间',
  `del_flag` tinyint(2) DEFAULT '0' COMMENT '删除标记 0=未删除 1=已删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `info0` varchar(254) DEFAULT NULL,
  `info1` varchar(254) DEFAULT NULL,
  `info2` varchar(254) DEFAULT NULL,
  `info3` varchar(254) DEFAULT NULL,
  `delivery_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=526 DEFAULT CHARSET=utf8mb4;

