/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tang.bugger.service.impl;


import com.tang.bugger.dao.impl.OrderTestDao;
import com.tang.bugger.model.OrderTest;
import com.tang.bugger.util.OrderStatus;
import com.tang.bugger.util.OrderStatusChangeEvent;
import com.tang.bugger.stateMachine.PersistStateMachineHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.StringJoiner;

@Component
public class OrderStateService {

    private PersistStateMachineHandler handler;


    public OrderStateService(PersistStateMachineHandler handler) {
        this.handler = handler;
    }

    @Autowired
    private OrderTestDao repo;


    public String listDbEntries() {
        OrderTest orderTest = new OrderTest();
        List<OrderTest> orderTests = repo.selectList(orderTest);
        StringJoiner sj = new StringJoiner(",");
        for (OrderTest o : orderTests) {
            sj.add(o.toString());
        }
        return sj.toString();
    }


    public boolean change(int order, OrderStatusChangeEvent event) {
        OrderTest test = new OrderTest();
        test.setOrderId(order);
        OrderTest o = repo.selectOne(test);
        return handler.handleEventWithState(MessageBuilder.withPayload(event).setHeader("order", order).build(), OrderStatus.valueOf(o.getStatus()));
    }




}
