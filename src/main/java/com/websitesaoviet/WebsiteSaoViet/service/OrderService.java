package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.OrderCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.OrderUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.OrderResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.Order;
import com.websitesaoviet.WebsiteSaoViet.exception.AppException;
import com.websitesaoviet.WebsiteSaoViet.exception.ErrorCode;
import com.websitesaoviet.WebsiteSaoViet.mapper.OrderMapper;
import com.websitesaoviet.WebsiteSaoViet.repository.OrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderService {
    OrderRepository orderRepository;
    OrderMapper orderMapper;

    public OrderResponse createOrder(OrderCreationRequest request) {
        Order order = orderMapper.createOrder(request);

        order.setId(String.valueOf(generateNextId()));
        order.setOderDatetime(LocalDateTime.now());
        order.setStatus("Đang xử lý");

        return orderMapper.toOrderResponse(orderRepository.save(order));
    }

    public List<OrderResponse> getOrders() {
        return orderMapper.toListOrdersResponse(orderRepository.findAll());
    }

    public OrderResponse getOrderById(String id) {
        return  orderMapper.toOrderResponse(orderRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_EXITED)));
    }

    public OrderResponse updateOrder(String id, OrderUpdateRequest request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_EXITED));

        if (order == null) {
            throw new AppException(ErrorCode.ORDER_NOT_EXITED);
        }

        order.setStatus(request.getStatus());

        return orderMapper.toOrderResponse(orderRepository.save(order));
    }

    public void deleteOrder(String id) {
        if (!orderRepository.existsById(id)) {
            throw new AppException(ErrorCode.ORDER_NOT_EXITED);
        }

        orderRepository.deleteById(id);
    }

    public String generateNextId() {
        String maxId = orderRepository.findMaxId();
        if (maxId == null) {
            return "LD2500000001";
        }

        int currentMax = Integer.parseInt(maxId.substring(2));
        int nextId = currentMax + 1;
        return "LD" + nextId;
    }
}