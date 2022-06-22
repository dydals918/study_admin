package com.example.study_admin.model.network.response;

import com.example.study_admin.model.enumClass.enumOrder.OrderStatus;
import com.example.study_admin.model.enumClass.enumOrder.OrderType;
import com.example.study_admin.model.enumClass.enumOrder.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderGroupApiResponse {

    private Long id;

    private OrderStatus status;

    private OrderType orderType;

    private String revAddress;

    private String revName;

    private PaymentType paymentType;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private Long userId;

    private List<ItemApiResponse> itemApiResList;

}
