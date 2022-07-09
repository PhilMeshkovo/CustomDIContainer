package com.phil.custom.container.service;

import com.phil.custom.container.annotation.Inject;
import com.phil.custom.container.annotation.PostConstruct;
import com.phil.custom.container.model.Gift;
import com.phil.custom.container.model.Person;

public class GiftPresenter {
    @Inject
    private GiftChooseHelper giftChooseHelper;
    @Inject
    private PaymentSystem paymentSystem;
    @Inject
    private DeliverySystem deliverySystem;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Gift presenter has been initialized!!!");
    }

    public void present(Person person) {
        Gift gift = giftChooseHelper.choose(person);
        System.out.println(String.format("Gift has been chosen: %s", gift.getName()));
        paymentSystem.pay(gift);
        deliverySystem.delivery(person, gift);
    }
}
