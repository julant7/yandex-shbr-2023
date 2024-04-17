package ru.yandex.test_task.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.test_task.dto.order.CreateOrderRequest;
import ru.yandex.test_task.dto.order.CreateOrderResponse;
import ru.yandex.test_task.dto.order.GetOrdersResponse;
import ru.yandex.test_task.dto.order.OrderDto;
import ru.yandex.test_task.entity.Order;
import ru.yandex.test_task.service.OrderService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public ResponseEntity<CreateOrderResponse> createOrders(@RequestBody @Valid CreateOrderRequest createOrderRequests) {
        return ResponseEntity.ok(orderService.createOrders(createOrderRequests));
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable String order_id) {
        return ResponseEntity.ok(orderService.getOrderById(order_id));
    }

    @GetMapping("/")
    public ResponseEntity<GetOrdersResponse> getOrdersWithRestrictions(@RequestParam(defaultValue = "0") BigInteger offset,
                                                                       @RequestParam(defaultValue = "1") BigInteger limit) {
        return ResponseEntity.ok(orderService.getOrdersWithRestrictions(offset, limit));
    }
//
//    @PostMapping("/complete")
//    public

//    @PostMapping("/orders/assign")
//    public ResponseEntity<?>

}
