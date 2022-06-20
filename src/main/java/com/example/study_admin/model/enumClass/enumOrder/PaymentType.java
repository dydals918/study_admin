package com.example.study_admin.model.enumClass.enumOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentType {

    CARD(0, "카드", "카드 결제"),
    CHECK_CARD(1, "체크 카드", "체크 카드 결제"),
    BANK_TRANSFER(2, "송금", "은행 송금");

    private Integer id;
    private String title;
    private String description;

}
