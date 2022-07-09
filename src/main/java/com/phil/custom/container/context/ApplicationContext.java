package com.phil.custom.container.context;

import com.phil.custom.container.factory.BeanFactory;
import com.phil.custom.container.postprocessor.BeanPostProcessor;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    private BeanFactory beanFactory;
    private Map<Class, Object> beanMap = new ConcurrentHashMap<>();


    public <T> T getBean(Class<T> clazz) {
        if (beanMap.containsKey(clazz)) {
            return (T) beanMap.get(clazz);
        }
        T bean = beanFactory.getBean(clazz);
        callPostProcessors(bean);
        beanMap.put(clazz, bean);
        return bean;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    private void callPostProcessors(Object bean) {
        Set<Class<? extends BeanPostProcessor>> subTypes = beanFactory.getBeanConfigurator().getScanner().getSubTypesOf(BeanPostProcessor.class);
        for (Class processor : subTypes) {
            BeanPostProcessor beanPostProcessor;
            try {
                beanPostProcessor = (BeanPostProcessor) processor.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            beanPostProcessor.process(bean);
        }
    }
}
