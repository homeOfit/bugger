package com.tang.bugger.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getTableAlias() {
        return TABLE_ALIAS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(Integer logLevel) {
        this.logLevel = logLevel;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getLogNo() {
        return logNo;
    }

    public void setLogNo(String logNo) {
        this.logNo = logNo;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInfo0() {
        return info0;
    }

    public void setInfo0(String info0) {
        this.info0 = info0;
    }

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1;
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2;
    }

    public String getInfo3() {
        return info3;
    }

    public void setInfo3(String info3) {
        this.info3 = info3;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public List<String> getLogNoList() {
        return logNoList;
    }

    public void setLogNoList(List<String> logNoList) {
        this.logNoList = logNoList;
    }

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

    @Override
    public String toString() {
        return "OrderExceptionInfo{" +
                "id=" + id +
                ", businessNo='" + businessNo + '\'' +
                ", businessName='" + businessName + '\'' +
                ", logLevel=" + logLevel +
                ", logInfo='" + logInfo + '\'' +
                ", requestIp='" + requestIp + '\'' +
                ", requestParam='" + requestParam + '\'' +
                ", requestTime=" + requestTime +
                ", logNo='" + logNo + '\'' +
                ", delFlag=" + delFlag +
                ", createTime=" + createTime +
                ", info0='" + info0 + '\'' +
                ", info1='" + info1 + '\'' +
                ", info2='" + info2 + '\'' +
                ", info3='" + info3 + '\'' +
                ", deliveryId='" + deliveryId + '\'' +
                ", logNoList=" + logNoList +
                '}';
    }
}

