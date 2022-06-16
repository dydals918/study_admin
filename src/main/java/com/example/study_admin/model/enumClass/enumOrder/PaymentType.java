package com.example.study_admin.model.enumClass.enumOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentType {

    CARD(0, "카드", "카드 결제"),
    MONEY(1, "현금", "현금 결제");

    private Integer id;
    private String title;
    private String description;

}
