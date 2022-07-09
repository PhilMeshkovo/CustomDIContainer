package com.phil.custom.container.service.impl;

import com.phil.custom.container.model.Gift;
import com.phil.custom.container.model.Person;
import com.phil.custom.container.service.DeliverySystem;

public class PostDeliverySystem implements DeliverySystem {
    @Override
    public void delivery(Person person, Gift gift) {
        System.out.println(String.format("Gift %s was delivered to %s", gift.getName(), person.getName()));
    }
}
