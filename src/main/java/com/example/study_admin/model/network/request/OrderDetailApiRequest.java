package com.example.study_admin.model.network.request;

import com.example.study_admin.model.enumClass.enumOrder.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDetailApiRequest {

    private Long id;

    private Long itemId;

    private Long orderGroupId;

    private OrderStatus status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

}
