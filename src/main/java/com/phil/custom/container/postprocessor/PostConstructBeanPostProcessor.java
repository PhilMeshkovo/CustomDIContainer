package com.phil.custom.container.postprocessor;

import com.phil.custom.container.annotation.PostConstruct;

import java.lang.reflect.Method;

public class PostConstructBeanPostProcessor implements BeanPostProcessor {
    @Override
    public void process(Object bean) {
        Method[] methods = bean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                try {
                    method.invoke(bean);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
