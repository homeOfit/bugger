package com.tang.bugger.dao;

import com.tang.bugger.util.ResultMessage;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("indexDao")
public class IndexDao {

    public ResultMessage<String> getIndex() {

            String aa = "index";
            List list = null;
            list.add(11);
            return new ResultMessage<>(200, "成功", aa);

    }
}
