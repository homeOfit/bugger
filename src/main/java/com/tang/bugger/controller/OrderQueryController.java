package com.tang.bugger.controller;



import com.ecej.order.unified.gateway.api.dto.MultiUnifiedOrderDTO;
import com.ecej.order.unified.gateway.api.unifiedorder.MultiUnifiedOrderService;
import com.ecej.order.unified.gateway.api.unifiedorder.SupplementMultiUnifiedOrderService;
import com.ecej.order.unified.gateway.api.vo.*;

import com.tang.bugger.util.MessageEnum;
import com.tang.bugger.util.ResultMessage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: tangqia@ecej.com
 * @Description: 订单查询控制类
 * @Date: Create in 18:00 2017/7/5
 * @Modified by:
 */

@RestController
@RequestMapping("/orderQuery")
public class OrderQueryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderQueryController.class);


    @Autowired
    private MultiUnifiedOrderService multiUnifiedOrderService;

    @Autowired
    private SupplementMultiUnifiedOrderService supplementMultiUnifiedOrderService;


    @ApiOperation(value = "多品类多数量下单", notes = "单品类单数量")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/orderTest", method = RequestMethod.GET)
    public ResultMessage<String> getMultiCreateOrder() {
        try {
            List<MultiServiceOrderEntity> multiServiceOrderEntityList = new ArrayList<>();
            for (int i=0; i< 1; i++) {
                List<MultiServiceItemEntity> multiServiceItemEntities = new ArrayList<>();
                MerchantEntity merchantEntity = new MerchantEntity();
                merchantEntity.setBearTheCost(0);
                merchantEntity.setMerchantId("12");
                MultiServiceItemEntity multiServiceItemEntity = new MultiServiceItemEntity();
                multiServiceItemEntity.setMerchantEntity(merchantEntity);
                multiServiceItemEntity.setNum(1);
                multiServiceItemEntity.setServiceClassId(1144);
                multiServiceItemEntity.setServiceItemId(159);
                multiServiceItemEntity.setCompanyId(123);
                multiServiceItemEntities.add(multiServiceItemEntity);
                MultiServiceOrderEntity multiServiceOrderEntity = new MultiServiceOrderEntity();
                multiServiceOrderEntity.setAppointmentTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-02-08 12:00:00"));
                multiServiceOrderEntity.setNightModel(1);
                multiServiceOrderEntity.setDispatchingCompanyId(1);
                multiServiceOrderEntity.setGuid(String.valueOf(new Random().nextLong()));
                multiServiceOrderEntity.setMultiServiceItemEntities(multiServiceItemEntities);
                multiServiceOrderEntityList.add(multiServiceOrderEntity);
            }

            MultiUnifiedOrderReqParam multiUnifiedOrderReqParam = new MultiUnifiedOrderReqParam();
            multiUnifiedOrderReqParam.setMultiServiceOrderEntities(multiServiceOrderEntityList);
            multiUnifiedOrderReqParam.setOrderSource(15);
            multiUnifiedOrderReqParam.setUserId(2014381);
            multiUnifiedOrderReqParam.setUserAddressId(2161429);
            multiUnifiedOrderReqParam.setContactsName("订单中心测试1");
            multiUnifiedOrderReqParam.setContactsMobile("15801081021");
            multiUnifiedOrderReqParam.setCityId(2088);
            multiUnifiedOrderReqParam.setCityName("石家庄");
            multiUnifiedOrderReqParam.setCommunityName("卓达玫瑰园11");
            multiUnifiedOrderReqParam.setDetailAddress("123131313123");
            multiUnifiedOrderReqParam.setLatitude(12.121212120000000);
            multiUnifiedOrderReqParam.setLongitude(121.121212120000000);
            multiUnifiedOrderReqParam.setSecMarks("订单组测试");
            multiUnifiedOrderReqParam.setOperId(1);
            multiUnifiedOrderReqParam.setOperUser("test");
            com.ecej.order.model.baseResult.ResultMessage<Map<String, com.ecej.order.model.baseResult.ResultMessage<MultiUnifiedOrderDTO>>>  resultMessage = multiUnifiedOrderService.multiUnifiedCreateOrder(multiUnifiedOrderReqParam);
            return new ResultMessage<>(MessageEnum.SUCCESS.getValue(), MessageEnum.SUCCESS.getDesc(), com.alibaba.fastjson.JSON.toJSONString(resultMessage));
        } catch (ParseException e) {
            return new ResultMessage<>(MessageEnum.QUERY_FAILURE.getValue(), MessageEnum.QUERY_FAILURE.getDesc(), null);
        }
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParam(name = "SupplementMultiUnifiedOrderReqParam", value = "用户详细实体user", required = true, dataType = "SupplementMultiUnifiedOrderReqParam")
    @RequestMapping(value = "/orderSupplementTest", method = RequestMethod.GET)
    public ResultMessage<String> orderSupplymentTest(@RequestBody SupplementMultiUnifiedOrderReqParam SupplementMultiUnifiedOrderReqParam) {
        try {
            SupplementMultiUnifiedOrderReqParam supplementMultiUnifiedOrderReqParam = new SupplementMultiUnifiedOrderReqParam();
            supplementMultiUnifiedOrderReqParam.setParentWorkOrderNo("A208801180125889942");
            List<SupplementMultiServiceOrderEntity> supplementMultiServiceOrderEntities = new ArrayList<>();
            SupplementMultiServiceOrderEntity supplementMultiServiceOrderEntity = new SupplementMultiServiceOrderEntity();
            supplementMultiServiceOrderEntity.setAppointmentTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-01-25 12:00:00"));
            supplementMultiServiceOrderEntity.setDispatchingCompanyId(10);
            supplementMultiServiceOrderEntity.setGuid("000000000");
            supplementMultiServiceOrderEntity.setOldGuid("-4884343868602781824");
            supplementMultiServiceOrderEntity.setNightModel(0);
            supplementMultiServiceOrderEntities.add(supplementMultiServiceOrderEntity);
            supplementMultiUnifiedOrderReqParam.setSupplementMultiServiceOrderEntityList(supplementMultiServiceOrderEntities);
            com.ecej.order.model.baseResult.ResultMessage<Map<String, com.ecej.order.model.baseResult.ResultMessage<MultiUnifiedOrderDTO>>>  resultMessage = supplementMultiUnifiedOrderService.supplementMultiUnifiedCreateOrder(supplementMultiUnifiedOrderReqParam);
            return new ResultMessage<>(MessageEnum.SUCCESS.getValue(), MessageEnum.SUCCESS.getDesc(), com.alibaba.fastjson.JSON.toJSONString(resultMessage));
        } catch (ParseException e) {
            return new ResultMessage<>(MessageEnum.QUERY_FAILURE.getValue(), MessageEnum.QUERY_FAILURE.getDesc(), null);
        }
    }

}
