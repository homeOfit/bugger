package com.tang.bugger.service.impl;

import com.tang.bugger.service.IndexService;
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
    @Override
    public String getIndex() throws Exception {
        try {
            List l = null;
            l.add(1);
            return "indexaa";
        } catch (Exception e) {
            throw e;
        }

    }
}
