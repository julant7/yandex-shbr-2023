package ru.yandex.test_task.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.test_task.dto.order.CreateOrderRequest;
import ru.yandex.test_task.dto.order.CreateOrderResponse;
import ru.yandex.test_task.dto.order.GetOrdersResponse;
import ru.yandex.test_task.dto.order.OrderDto;
import ru.yandex.test_task.entity.Order;
import ru.yandex.test_task.exception.OrderException;
import ru.yandex.test_task.mapper.OrderMapper;
import ru.yandex.test_task.repository.OrderRepository;
import ru.yandex.test_task.service.OrderService;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    @Override
    @Transactional
    public CreateOrderResponse createOrders(CreateOrderRequest createOrderRequest) {
        List<OrderDto> orderDtos = createOrderRequest.getOrders().stream()
                .map(orderMapper::createOrderDtoToOrderDto)
                .toList();

        List<Order> orders = orderDtos.stream()
                .map(orderMapper::toOrder)
                .toList();

        List<Order> savedOrders = orderRepository.saveAll(orders);

        List<OrderDto> savedOrderDtos = savedOrders.stream()
                .map(orderMapper::toDto)
                .toList();

        return new CreateOrderResponse(savedOrderDtos);
    }

    @Override
    public OrderDto getOrderById(String id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) return orderMapper.toDto(orderOptional.get());
        throw new OrderException(String.format("Order with id %s not found.", id));
    }

    @Override
    public GetOrdersResponse getOrdersWithRestrictions(BigInteger offset, BigInteger limit) {
        Optional<List<Order>> orderOptional = orderRepository.findOrdersWithRestrictions(offset, limit);
        if (orderOptional.isPresent()) {
            List<OrderDto> savedOrderDtos = orderOptional.get().stream()
                    .map(orderMapper::toDto)
                    .toList();

            return new GetOrdersResponse(savedOrderDtos);
        }
        throw new OrderException(String.format("Restriction isn't correct"));
    }

    @Override
    public void assignOrders() {

    }


}
