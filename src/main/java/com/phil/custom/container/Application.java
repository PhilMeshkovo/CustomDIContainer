package com.phil.custom.container;

import com.phil.custom.container.client.NewYearOrganizer;
import com.phil.custom.container.context.ApplicationContext;
import com.phil.custom.container.factory.BeanFactory;

public class Application {

    public ApplicationContext run() {
        ApplicationContext applicationContext = new ApplicationContext();
        BeanFactory beanFactory = new BeanFactory(applicationContext);
        applicationContext.setBeanFactory(beanFactory);
        return applicationContext;
    }

    public static void main(String[] args) {
       Application application = new Application();
       ApplicationContext applicationContext = application.run();
       NewYearOrganizer organizer = applicationContext.getBean(NewYearOrganizer.class);
       organizer.prepareToCelebration();
    }
}
