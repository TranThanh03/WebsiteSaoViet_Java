package com.websitesaoviet.WebsiteSaoViet.mapper;

import com.websitesaoviet.WebsiteSaoViet.dto.request.OrderCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.OrderUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.OrderResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order createOrder(OrderCreationRequest request);

    OrderResponse toOrderResponse(Order order);

    List<OrderResponse> toListOrdersResponse(List<Order> ordersList);
}
