package com.tang.bugger.controller;

import com.tang.bugger.service.impl.OrderStateService;
import com.tang.bugger.util.MessageEnum;
import com.tang.bugger.util.OrderStatusChangeEvent;
import com.tang.bugger.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lijingyao on 2017/11/8 16:04.
 */
@RestController
@RequestMapping("/orderState")
public class OrderController {

    @Autowired
    private OrderStateService orderStateService;

    /**
     * 列出所有的订单列表
     *
     * @return
     */
    @RequestMapping(method = {RequestMethod.GET})
    public ResultMessage<String> orders() {
        String orders = orderStateService.listDbEntries();
        return new ResultMessage<>(MessageEnum.SUCCESS.getValue(), MessageEnum.SUCCESS.getDesc(), orders);

    }


    /**
     * 通过触发一个事件，改变一个订单的状态
     * @param orderId
     * @param event
     * @return
     */
    @RequestMapping(value = "/{orderId}", method = {RequestMethod.GET})
    public ResultMessage<Boolean> processOrderState(@PathVariable("orderId") Integer orderId, @RequestParam("event") OrderStatusChangeEvent event) {
        Boolean result = orderStateService.change(orderId, event);
        return new ResultMessage<>(MessageEnum.SUCCESS.getValue(), MessageEnum.SUCCESS.getDesc(), result);
    }

}
