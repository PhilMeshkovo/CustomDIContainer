package com.phil.custom.container.service;

import com.phil.custom.container.model.Gift;
import com.phil.custom.container.model.Person;

public interface DeliverySystem {
    void delivery(Person person, Gift gift);
}
