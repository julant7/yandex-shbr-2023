package ru.yandex.test_task.mapper;

import org.springframework.stereotype.Service;
import ru.yandex.test_task.dto.district.DistrictDto;
import ru.yandex.test_task.dto.order.CreateOrderDto;
import ru.yandex.test_task.dto.order.OrderDto;
import ru.yandex.test_task.dto.time_designation.TimeDesignationDto;
import ru.yandex.test_task.entity.Order;

import java.util.stream.Collectors;

@Service
public class OrderMapper {
    public Order toOrder(OrderDto orderDto) {
        return Order.builder()
                .weight(orderDto.getWeight())
                .price(orderDto.getPrice())
                .district(orderDto.getDistrict().toDistrict())
                .deliveryTime(orderDto.getDeliveryTime().stream()
                        .map(TimeDesignationDto::toTimeDesignation)
                        .collect(Collectors.toSet()))
                .build();
    }
    public OrderDto toDto(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .weight(order.getWeight())
                .price(order.getPrice())
                .district(new DistrictDto(order.getDistrict().getId()))
                .deliveryTime(order.getDeliveryTime().stream()
                        .map(TimeDesignationDto::fromTimeDesignation)
                        .collect(Collectors.toSet()))
                .build();
    }
    public OrderDto createOrderDtoToOrderDto(CreateOrderDto createOrderDto) {
        return OrderDto.builder()
                .weight(createOrderDto.getWeight())
                .price(createOrderDto.getPrice())
                .district(new DistrictDto(createOrderDto.getDistrict()))
                .deliveryTime(createOrderDto.getDeliveryTime().stream()
                        .map(timeInterval -> TimeDesignationDto.builder()
                                .timeInterval(timeInterval)
                                .build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
