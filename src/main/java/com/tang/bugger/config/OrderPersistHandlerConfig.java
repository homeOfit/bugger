package com.tang.bugger.config;

import com.tang.bugger.service.impl.OrderStateService;
import com.tang.bugger.stateMachine.OrderPersistStateChangeListener;
import com.tang.bugger.stateMachine.PersistStateMachineHandler;
import com.tang.bugger.util.OrderStatus;
import com.tang.bugger.util.OrderStatusChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;

/**
 * Created by lijingyao on 2017/11/24 10:40.
 */
@Configuration
public class OrderPersistHandlerConfig {

    @Autowired
    private StateMachine<OrderStatus, OrderStatusChangeEvent> stateMachine;


    @Bean
    public OrderStateService persist() {
        PersistStateMachineHandler handler = persistStateMachineHandler();
        handler.addPersistStateChangeListener(persistStateChangeListener());
        return new OrderStateService(handler);
    }

    @Bean
    public PersistStateMachineHandler persistStateMachineHandler() {
        return new PersistStateMachineHandler(stateMachine);
    }

    @Bean
    public OrderPersistStateChangeListener persistStateChangeListener(){
        return new OrderPersistStateChangeListener();
    }


}
