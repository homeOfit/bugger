package com.tang.bugger;

import com.tang.bugger.config.DataSource;
import com.tang.bugger.model.OrderExceptionInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuggerApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	public void insert() {

		OrderExceptionInfo orderExceptionInfo = new OrderExceptionInfo();
		orderExceptionInfo.setId(1);
		dataSource.insert(orderExceptionInfo);
	}

}
