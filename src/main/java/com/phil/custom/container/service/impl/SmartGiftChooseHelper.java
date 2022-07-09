package com.phil.custom.container.service.impl;

import com.phil.custom.container.annotation.Inject;
import com.phil.custom.container.model.Gift;
import com.phil.custom.container.model.Person;
import com.phil.custom.container.service.GiftChooseHelper;

public class SmartGiftChooseHelper implements GiftChooseHelper {
    @Inject
    private Recommendator recommendator;

    @Override
    public Gift choose(Person person) {
        recommendator.recommend();
        Gift gift = new Gift("Cool Present", 10000);
        System.out.println(String.format("Gift %s was chosen by %s", gift.getName(), person.getName()));;
        return gift;
    }
}
