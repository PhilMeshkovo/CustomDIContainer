package com.phil.custom.container.postprocessor;

public class LoggingPostProcessor implements BeanPostProcessor{
    @Override
    public void process(Object bean) {
        System.out.println(String.format("LOG: bean has been created: %s", bean.getClass()));
    }
}
