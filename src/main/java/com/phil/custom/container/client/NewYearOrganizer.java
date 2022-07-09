package com.phil.custom.container.client;

import com.phil.custom.container.annotation.Inject;
import com.phil.custom.container.model.Person;
import com.phil.custom.container.service.GiftPresenter;

public class NewYearOrganizer {

    @Inject
    private GiftPresenter giftPresenter;

    public void prepareToCelebration() {
        Person friend = new Person("Иван Иванов");
        giftPresenter.present(friend);
    }
}
