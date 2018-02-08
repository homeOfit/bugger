package com.tang.bugger.model;


import com.tang.bugger.util.OrderStatus;
import lombok.Data;

/**
 * Created by lijingyao on 2017/11/9 15:18.
 */
@Data
public class OrderTest {


    private Integer id;


    private Integer orderId;

    private String status;


    public OrderTest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderTest{" +
                "orderId=" + orderId +
                ", status=" + status +
                '}';
    }
}
