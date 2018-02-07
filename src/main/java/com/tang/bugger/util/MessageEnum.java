package com.tang.bugger.util;

 /**
  *<p>类描述：共通项目组的返回消息枚举</p>
  * @author 李凯 [peter]
  * @version: v1.0.0.1
  * @since JDK1.8
  *<p>创建日期：2016年5月25日 下午2:45:50</p>
  * Copyright 【新智泛能网络科技有限公司】 2016 
  */
 
public enum MessageEnum {

	/**
	 * 操作成功
	 */
	SUCCESS(200,"请求已成功处理"),
	
	/*--------------------------------数据库类---------------------*/
	/**
	 * 查询失败
	 */
	QUERY_FAILURE(300,"查询失败"), 
	/**
	 * 添加失败
	 */
	ADD_FAILURE(301,"添加失败"),

	/**
	 * 更新失败
	 */
	UPDATE_FAILURE(302,"更新失败"),
	
	 /**
	 * 删除失败
	 */
	DELETE_FAILURE(303,"删除失败"),

	 /**
	  * 删除失败
	  */
	 QUERY_EMPTY(304,"结果为空"),

	/*-----------------------------------消息类--------------------*/
	/**
	 * 邮件发送失败
	 */
	EMAIL_SEND_FAILURE(400,"邮件发送失败"),
	/**
	 * 消息推送失败
	 */
	MESSAGE_SEND_FAILURE(401,"消息推送失败"),
	/**
	 * 消息推送失败
	 */
	SMS_SEND_FAILURE(402,"短信发送失败"),
	
	
	/*-----------------------------------师傅派工类--------------------*/
	
	/**
	 * 释放档期失败
	 */
	RELEASE_FAILE(204,"释放档期失败"),
	/**
	 * 下班后预约
	 */
	AFTER_WORK_SUBSCRIBE(500,"下班后预约"),
	/**
	 * 当天预约已满
	 */
	SUBSCRIBE_IS_FULL(501,"当天预约已满"),
	/**
	 * 时间段内无师傅
	 */
	TIME_PERIOD_NO_MASTER(502,"时间段内无师傅"),
	/**
	 * 无服务区
	 */
	NO_SERVICEAREAINFO(503,"超出服务范围，创建订单失败"),
	
    //师傅此时间段，没有空闲时间了   
	QUERY_EMP_FAILURE(504,"此时间段没有空闲的师傅了，请换个时间!"), 
	
	
	NO_SCHEDULE (505,"无排班师傅占用档期成功"), 
	
	
	NO_RELEASE (506,"无排班师傅释放档期成功"), 
	
	LOCK_OTHER (507,"档期已被其他用户锁定"), 
	
	ALREADY_USED (508,"档期已被占用"), 
	
	NO_TIME (509,"没有足够档期"), 
	
	DISABLED_TIME (510,"时间不可用"), 
	
	NO_EMP (511,"没有搜到师傅"),
	
	EMP_DIS_MAX_ORDER_NUM(512,"员工最大派工单超限"),
	
	CANNOT_CHANGE_BECAUSE_CLOSED(513,"订单状态已改变，改约失败"),
	
	EMP_NORESOURCE(516,"无可用师傅资源"),
	
	REPEAT_ORDER_TIP(9003, "当前地址和品类存在未支付的订单哦~"),
	
	SHOPORDERNO_ISEXIST(9004, "商城订单号已存在"),
	
	/*-----------------------------------SAP主数据类--------------------*/
	
	/*-----------------------------------阶梯计费类--------------------*/
	
	/*-----------------------------------网络异常类--------------------*/
	/**
	 * 建立FastDfs上传服务器连接失败
	 */
	CONNECT_FASTDFS_FAILURE(800,"建立FastDfs上传服务器连接失败"),
	/*-----------------------------------文件异常类--------------------*/
	/**
	 * 获取文件路径失败
	 */
	GET_FILE_FAILURE(900,"获取文件路径失败"),
	/**
	 * 文件上传失败
	 */
	FILE_UPLOAD_FAILURE(901,"文件上传失败"),
	/**
	 * 图片上传失败
	 */
	IMAGE_UPLOAD_FAILURE(902,"图片上传失败"),
	/**
	 * 缩略图生成失败
	 */
	ZOOM_IMAGE_CREATE_FAILURE(903,"缩略图生成失败"),
	/**
	 * 缩略图片上传失败
	 */
	ZOOM_IMAGE_UPLOAD_FAILURE(904,"缩略图片上传失败"),
	/**
	 * 添加水印文字失败
	 */
	WATER_ADD_TEXT_FAILURE(905,"添加水印文字失败"),
	/**
	 * 添加水印图片失败
	 */
	WATER_ADD_IMAGE_FAILURE(906,"添加水印图片失败"),
	/**
	 * 配置文件读取异常
	 */
	PROPERTIES_READ_FAILURE(907,"配置文件读取异常"),
	
	
	/*-----------------------------------通用类--------------------*/
	/**
	 * 参数异常
	 */
	PARAMETER_EXCEPTION(1000,"参数异常"),
	/**
	 * 参数异常
	 */
	SYSTEM_EXCEPTION(1011,"系统异常"),
	
	THROWABLE_EXCEPTION(1012,"Throwable异常"),
	/*-----------------------------------订单中心专用--------------------*/
	
	/**
	 * 订单创建失败
	 */
	CREAT_ORDER_ERROR(1001,"订单创建失败"),
	
	/**
	 * 订单创建异常
	 */
	CREAT_ORDER_FAILURE(1002,"订单创建异常"),
	
	/**
	 * 方法校验异常
	 */
	REFLECT_CHECK_FAILURE(1003,"方法校验异常"),
	
	REFLECT_CHECK_NOT_CONFIG(1004,"方法校验规则未配置"),
	
	SERVICE_ITEM_ERROR(1005,"项目信息错误"),
	
	/**
	 * 订单取消
	 */
	CANCEL_ORDER_ERROR(1006,"订单取消失败"),
	
	CANCEL_ORDER_FAILURE(1007,"订单取消异常"),
	
	
	/**
	 * 订单改约
	 */
	RESCHEDULE_ORDER_ERROR(1008,"订单改约失败"),
	RESCHEDULE_ORDER_FAILURE(1009,"订单改约异常"),
	
	
	/**
	 * 订单改约
	 */
	REDISPATCH_ORDER_ERROR(1010,"订单改派失败"),
	REDISPATCH_ORDER_FAILURE(1011,"订单改派异常"),

	 /**
	  * 多品类下单订单数量
	  */
	 MULTI_ORDER_MAX_NUM(1012,"订单数量超过阀值"),

	 /**
	  * 多品类下单 服务项目数量
	  */
	 MULTI_ORDER_ITEM_MAX_NUM(1013,"订单的服务项目总数超过阀值"),
	 /**
	  * 补单次数
	  */
	 SUPPLEMENT_MULTI_ORDER_NUM(1014, "单位时间内，补单次数超过阀值"),

	 STATUS_NOT_SUPPORT_ACTION(9005,"当前订单状态不支持此操作"),
	 SOURCE_NOT_SUPPORT_ACTION(9006, "当前订单的订单来源和订单状态不允许此操作来源执行此操作"),
	
	/**
	 * 调用派工RPC返回错误
	 */
	RPC_DISPATCHING_ERROR(2000,"调用派工RPC返回错误"),
	
	
	DATABASE_CONNECT_FAILURE(9999,"数据库连接异常"),
	
	/*-----------------------------------订单来源--------------------*/
	ORDERSOURCE_DENY(1100,"订单来源不合法"),
	ORDERSTATUS_DENY(1101,"订单状态不合法"),

	/*---------------------------图片上传类-----------------------------------*/
	IMAGE_UPLOAD_ERROR(1200, "图片上传失败"),
	
	
	CREATE_ORDER_NO_ERROR(5000, "订单编号获取失败");


	/**
	 * code码
	 */
	private final Integer value;  
	 /**
	 * 描述
	 */
	private final String desc;
	    
	  /**
	 * @param value
	 */
	private MessageEnum(Integer value,String desc){  
	      this.value = value;  
	      this.desc = desc;
	  }

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}  
}
