package com.tang.bugger;

import com.tang.bugger.util.OrderStatus;
import com.tang.bugger.util.OrderStatusChangeEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.EnumSet;

@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(value = { "com.tang" })
public class BuggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuggerApplication.class, args);
	}

	@Configuration
	@EnableStateMachine
	static class StateMachineConfig
			extends StateMachineConfigurerAdapter<OrderStatus, OrderStatusChangeEvent> {
		@Override
		public void configure(StateMachineStateConfigurer<OrderStatus, OrderStatusChangeEvent> states)
				throws Exception {
			states
					.withStates()
					// 定义初始状态
					.initial(OrderStatus.WAIT_PAYMENT)
					// 定义所有状态集合
					.states(EnumSet.allOf(OrderStatus.class));
		}

		@Override
		public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderStatusChangeEvent> transitions)
				throws Exception {
			transitions
					.withExternal()
					.source(OrderStatus.WAIT_PAYMENT).target(OrderStatus.WAIT_DELIVER)
					.event(OrderStatusChangeEvent.PAYED)
					.and()
					.withExternal()
					.source(OrderStatus.WAIT_DELIVER).target(OrderStatus.WAIT_RECEIVE)
					.event(OrderStatusChangeEvent.DELIVERY)
					.and()
					.withExternal()
					.source(OrderStatus.WAIT_RECEIVE).target(OrderStatus.FINISH)
					.event(OrderStatusChangeEvent.RECEIVED);
		}

	}

}
