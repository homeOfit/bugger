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

    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRES_NEW)
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

        OrderExceptionInfo orderExceptionInfo2 = new OrderExceptionInfo();
        orderExceptionInfo2.setId(1);
        orderExceptionInfo2 = dataSource.selectOne(orderExceptionInfo2);
        System.out.println("333333" + orderExceptionInfo2);
        System.out.println("33333333 " + (orderExceptionInfo==orderExceptionInfo2));

        OrderExceptionInfo orderExceptionInfo1 = new OrderExceptionInfo();
        orderExceptionInfo1.setBusinessName("99");
        orderExceptionInfo1 = dataSource.selectOne(orderExceptionInfo1);
        System.out.println("2222222" + orderExceptionInfo1);
        //System.out.println(1/0);
        System.out.println("222222222 " + (orderExceptionInfo==orderExceptionInfo1));
    }


   @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRES_NEW)
    public void update() {
        OrderExceptionInfo orderExceptionInfo = new OrderExceptionInfo();
        orderExceptionInfo.setId(1);
        orderExceptionInfo.setBusinessName("99");
        orderExceptionInfo.setCreateTime(new Date());
        dataSource.update(orderExceptionInfo);
        //System.out.println(1/0);
    }

}
