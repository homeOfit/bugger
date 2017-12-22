package com.tang.bugger.service.impl;

import com.tang.bugger.config.DataSource;
import com.tang.bugger.model.OrderExceptionInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service("testService")
public class TestServiceImpl {

    @Autowired
    private TestServiceImpl self;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @PostConstruct
    public void test() throws InterruptedException {
        self.process();
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRES_NEW)
    public void process() {
//        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
//        def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
//        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            OrderExceptionInfo orderExceptionInfo = new OrderExceptionInfo();
            orderExceptionInfo.setId(1);
            orderExceptionInfo = dataSource.selectOne(orderExceptionInfo);
            System.out.println("11111111" + orderExceptionInfo);
            new Thread(() -> {
                self.update();
            }).start();
            try {
                Thread.sleep(3 * 1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("我要查询啦，那货提交了吗？？？？" + System.currentTimeMillis());
            OrderExceptionInfo orderExceptionInfo2 = new OrderExceptionInfo();
            orderExceptionInfo2.setId(1);
            orderExceptionInfo2 = dataSource.selectOne(orderExceptionInfo2);
            System.out.println("2222" + orderExceptionInfo2);

        } catch (Exception e) {
//            transactionManager.rollback(status);
        }
//        transactionManager.commit(status);
        //System.out.println("我先提交啦！！！！" + System.currentTimeMillis());
    }

    //    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)
    public void update() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            OrderExceptionInfo orderExceptionInfo = new OrderExceptionInfo();
            orderExceptionInfo.setId(1);
            orderExceptionInfo.setBusinessName("00000000");
            orderExceptionInfo.setCreateTime(new Date());
            dataSource.update(orderExceptionInfo);
            try {
                Thread.sleep(10 * 1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (Exception e) {
            transactionManager.rollback(status);
        }
        transactionManager.commit(status);
        System.out.println("我要提交啦！！！！" + System.currentTimeMillis());
    }

}
