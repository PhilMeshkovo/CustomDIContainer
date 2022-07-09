package com.phil.custom.container.service.impl;

import com.phil.custom.container.model.Gift;
import com.phil.custom.container.service.PaymentSystem;

public class CardPaymentSystem implements PaymentSystem {
    @Override
    public void pay(Gift gift) {
        System.out.println(String.format("Pay %d for gift %s  by CARD", gift.getPrice(), gift.getName()));
    }
}
