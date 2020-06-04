package com.devin.proxy;

public class OrderServiceProxy implements OrderService{
    private OrderService orderService = new OrderServiceImpl();

    public void showOrder() {
        System.out.println("-----性能----");
        orderService.showOrder();
    }
}
