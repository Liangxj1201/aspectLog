package com.xjliang.aspect.service;

import com.xjliang.aspect.entity.Order;
import com.xjliang.aspect.utils.CommUtils;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    public Order getOrder(Long orderId){
        Order order =new Order();
        order.setOrderId(orderId);
        order.setCreateTime(CommUtils.getTimeStr());
        return order;
    }
}
