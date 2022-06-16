package com.example.study_admin.model.enumClass.enumOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {

    SEND(0, "발송", "상품 발송"),
    WAITING(1, "대기", "상품 대기"),
    COMPLETE(2, "완료", "상품 도착")
    ;

    private Integer id;
    private String title;
    private String description;

}
