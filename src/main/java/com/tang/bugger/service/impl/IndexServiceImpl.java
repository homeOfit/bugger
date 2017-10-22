package com.tang.bugger.service.impl;

import com.tang.bugger.dao.IndexDao;
import com.tang.bugger.service.IndexService;
import com.tang.bugger.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: tangqia@ecej.com
 * @Description:
 * @Date: Create in 10:39 2017/10/19
 * @Modified by:
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService{

    @Autowired
    private IndexDao indexDao;

    @Override
    public ResultMessage<String> getIndex() throws Exception {
        try {

            return indexDao.getIndex();
        } catch (Exception e) {
            //e.getMessage();
            throw e;
        }

    }
}
