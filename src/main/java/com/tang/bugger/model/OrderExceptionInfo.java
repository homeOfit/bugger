package com.tang.bugger.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderExceptionInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    //alias
    public static final String TABLE_ALIAS = "LogError";

    //columns START
    /**
     * 主键自增       db_column: id
     */
    private Integer id;
    /**
     * 业务编号（前四位项目编号+后四位业务编号）       db_column: business_no
     */
    private String businessNo;
    /**
     * 项目名称+业务名称       db_column: business_name
     */
    private String businessName;
    /**
     * 日志等级       db_column: log_level
     */
    private Integer logLevel;
    /**
     * 错误日志信息       db_column: log_info
     */
    private String logInfo;
    /**
     * 请求ip地址        db_column: request_ip
     */
    private String requestIp;
    /**
     * 请求参数       db_column: request_param
     */
    private String requestParam;

    /**
     * 请求时间       db_column: request_time
     */
    private java.util.Date requestTime;
    /**
     * 日志编号，程序自动生成       db_column: log_no
     */
    private String logNo;
    /**
     * 删除标记 0=未删除 1=已删除       db_column: del_flag
     */
    private Integer delFlag;
    /**
     * 创建时间       db_column: create_time
     */
    private java.util.Date createTime;

    private String info0;
    private String info1;
    private String info2;
    private String info3;
    //columns END
    /**
     * 业务执行链条ID
     */
    private String deliveryId;

    private List<String> logNoList;

}

