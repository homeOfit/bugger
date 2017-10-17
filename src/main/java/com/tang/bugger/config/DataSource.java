package com.tang.bugger.config;

import com.tang.bugger.dao.impl.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by junbaor on 2017/4/19.
 */
@Repository
public class DataSource extends BaseDao {

    @Resource
    public void setServiceSqlSessionFactory(SqlSessionFactory sessionFactory) {
        super.setSqlSessionFactory(sessionFactory);
    }
}
