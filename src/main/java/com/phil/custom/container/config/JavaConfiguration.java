package com.phil.custom.container.config;

import com.phil.custom.container.service.PaymentSystem;
import com.phil.custom.container.service.impl.CashPaymentSystem;

import java.util.Map;

public class JavaConfiguration implements Configuration{
    @Override
    public String getPackageToScan() {
        return "com.phil.custom.container";
    }

    @Override
    public Map<Class, Class> getInterfaceToImplementations() {
        return Map.of(PaymentSystem.class, CashPaymentSystem.class);
    }
}
