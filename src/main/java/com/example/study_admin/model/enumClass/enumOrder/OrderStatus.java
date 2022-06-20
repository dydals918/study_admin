package com.example.study_admin.model.enumClass.enumOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {

    ORDERING(0, "주문", "상품 주문"),
    CONFIRM(1, "대기", "상품 대기"),
    COMPLETE(2, "완료", "상품 도착")
    ;

    private Integer id;
    private String title;
    private String description;

}
