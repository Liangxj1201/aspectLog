package com.xjliang.aspect.service;

import com.xjliang.aspect.entity.Order;
import com.xjliang.aspect.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private OrderService orderService;

    public User getUser(User user){
        Order order=orderService.getOrder(1L);
        List<Order> orders =new ArrayList<Order>();
        orders.add(order);
        user.setOrders(orders);
        return user;
    }

}
