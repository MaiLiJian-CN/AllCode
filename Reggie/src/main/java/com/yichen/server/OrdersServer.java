package com.yichen.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yichen.entity.Orders;

public interface OrdersServer extends IService<Orders> {
    public void submit(Orders orders);
}
