package ru.yandex.test_task.service;

import ru.yandex.test_task.dto.order.CreateOrderRequest;
import ru.yandex.test_task.dto.order.CreateOrderResponse;
import ru.yandex.test_task.dto.order.GetOrdersResponse;
import ru.yandex.test_task.dto.order.OrderDto;
import ru.yandex.test_task.entity.Order;

import java.math.BigInteger;
import java.util.List;

public interface OrderService {
    CreateOrderResponse createOrders(CreateOrderRequest createOrderRequest);
    OrderDto getOrderById(String id);
    GetOrdersResponse getOrdersWithRestrictions(BigInteger offset, BigInteger limit);
    void assignOrders();
}
