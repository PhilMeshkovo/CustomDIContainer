package com.phil.custom.container.factory;

import com.phil.custom.container.annotation.Inject;
import com.phil.custom.container.config.Configuration;
import com.phil.custom.container.config.JavaConfiguration;
import com.phil.custom.container.configurator.BeanConfigurator;
import com.phil.custom.container.configurator.JavaBeanConfigurator;
import com.phil.custom.container.context.ApplicationContext;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BeanFactory {

    private final BeanConfigurator beanConfigurator;
    private final Configuration configuration;
    private final ApplicationContext applicationContext;

    public BeanFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.configuration = new JavaConfiguration();
        this.beanConfigurator = new JavaBeanConfigurator(configuration.getPackageToScan(),
                configuration.getInterfaceToImplementations());
    }

    public <T> T getBean(Class<T> clazz) {
        Class<? extends T> implementationClass = clazz;
        if (implementationClass.isInterface()) {
            implementationClass = beanConfigurator.getImplementationClass(implementationClass);
        }
        try {
            T bean = implementationClass.getDeclaredConstructor().newInstance();
            List<Field> fields = Arrays.stream(implementationClass.getDeclaredFields()).filter(field ->
                    field.isAnnotationPresent(Inject.class)).collect(Collectors.toList());
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(bean, applicationContext.getBean(field.getType()));
            }

            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BeanConfigurator getBeanConfigurator() {
        return beanConfigurator;
    }
}
