package com.phil.custom.container.configurator;

import org.reflections.Reflections;

public interface BeanConfigurator {
    <T> Class<? extends T> getImplementationClass(Class<T> interfaceClass);
    Reflections getScanner();
}
