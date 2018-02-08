package com.tang.bugger.dao.impl;

import com.tang.bugger.config.DataSource;
import com.tang.bugger.model.OrderTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("orderTestDao")
public class OrderTestDao {

   @Autowired
   private DataSource dataSource;


    public List<OrderTest> selectList(OrderTest orderTest) {
        return dataSource.selectList(orderTest);
    }

    public OrderTest selectOne(OrderTest query) {
        return dataSource.selectOne(query);
    }

    public void insert(OrderTest o) {
        dataSource.insert(o);
    }
}
