package io.github.hhcarlos.designpatterns.behavioral.strategy.order.payment;

import java.math.BigDecimal;

public interface ShippingStrategy {
    public BigDecimal calculateShippingCost(BigDecimal orderTotal);
}
