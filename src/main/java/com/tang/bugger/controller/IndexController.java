package com.tang.bugger.controller;

import com.tang.bugger.service.IndexService;
import com.tang.bugger.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tangqia@ecej.com
 * @Description:
 * @Date: Create in 10:33 2017/10/19
 * @Modified by:
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("indexaa")
    public ResultMessage<String> getIndexHtml() {
        ResultMessage<String> index  = null;
        try {
            index = indexService.getIndex();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index;

    }
}
