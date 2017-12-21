package com.tang.bugger.service.impl;

import com.tang.bugger.config.DataSource;
import com.tang.bugger.model.OrderExceptionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service("testService")
public class TestServiceImpl {

    @Autowired
    private TestServiceImpl self;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void test() throws InterruptedException {
        self.process();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void process() {
        OrderExceptionInfo orderExceptionInfo = new OrderExceptionInfo();
        orderExceptionInfo.setId(1);
        orderExceptionInfo = dataSource.selectOne(orderExceptionInfo);
        System.out.println("11111111" + orderExceptionInfo);
        new Thread(()->{
            self.update();
        }).start();

        try{
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        OrderExceptionInfo orderExceptionInfo1 = new OrderExceptionInfo();
        orderExceptionInfo1.setId(1);
        orderExceptionInfo1 = dataSource.selectOne(orderExceptionInfo1);
        System.out.println("2222222" + orderExceptionInfo1);
        //System.out.println(1/0);

        selectOne();
    }


    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public void update() {
        OrderExceptionInfo orderExceptionInfo = new OrderExceptionInfo();
        orderExceptionInfo.setId(1);
        orderExceptionInfo.setBusinessName("99999999");
        orderExceptionInfo.setCreateTime(new Date());
        dataSource.update(orderExceptionInfo);

        OrderExceptionInfo orderExceptionInfo1 = new OrderExceptionInfo();
        orderExceptionInfo1.setId(1);
        orderExceptionInfo1 = dataSource.selectOne(orderExceptionInfo1);
        System.out.println("2222222---1  " + orderExceptionInfo1);
    }


    private void selectOne() {
        OrderExceptionInfo orderExceptionInfo1 = new OrderExceptionInfo();
        orderExceptionInfo1.setId(1);
        orderExceptionInfo1 = dataSource.selectOne(orderExceptionInfo1);
        System.out.println("33333" + orderExceptionInfo1);
    }


}
