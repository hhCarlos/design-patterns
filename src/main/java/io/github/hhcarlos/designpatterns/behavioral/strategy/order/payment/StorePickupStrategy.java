package io.github.hhcarlos.designpatterns.behavioral.strategy.order.payment;

import java.math.BigDecimal;

public class StorePickupStrategy implements ShippingStrategy {

    @Override
    public BigDecimal calculateShippingCost(BigDecimal orderTotal) {
        return BigDecimal.ZERO;
    }
}
