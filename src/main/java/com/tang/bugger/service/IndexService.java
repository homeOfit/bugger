package com.tang.bugger.service;

import com.tang.bugger.util.ResultMessage;

/**
 * @Author: tangqia@ecej.com
 * @Description:
 * @Date: Create in 10:39 2017/10/19
 * @Modified by:
 */
public interface IndexService {

    ResultMessage<String> getIndex() throws Exception;
}
